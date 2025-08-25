package com.example.scrolltracker.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.display.DisplayManager
import android.os.PowerManager
import android.util.Log
import android.view.Display
import android.view.accessibility.AccessibilityEvent
import androidx.core.app.NotificationCompat
import com.example.scrolltracker.AppUsageTracker
import com.example.scrolltracker.R
import com.example.scrolltracker.data.entity.AppUsageSession
import com.example.scrolltracker.data.entity.ScrollEvent
import com.example.scrolltracker.data.repo.ScrollRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class ScrollMonitoringService : AccessibilityService() {

    @Inject
    lateinit var repository: ScrollRepository

    //    @Inject lateinit var mPackageManager: PackageManager
    @Inject
    lateinit var displayManager: DisplayManager

    @Inject
    lateinit var appUsageTracker: AppUsageTracker

    private lateinit var broadcastReceiver: BroadcastReceiver
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val activeSessions = mutableMapOf<String, AppUsageSession>()
    private val pixelToMeterRatio = 0.0002645833f // Approximate conversion (96 DPI)


    val listener = object : DisplayManager.DisplayListener {
        override fun onDisplayAdded(displayId: Int) {}
        override fun onDisplayRemoved(displayId: Int) {}
        override fun onDisplayChanged(displayId: Int) {
            val display = displayManager.getDisplay(displayId)
            if (display.state == Display.STATE_ON) {
                serviceScope.launch {
                    repository.updateWakeCount(1)
                }
                Log.d("DisplayManager", "ScreenWake ${System.currentTimeMillis()}")
            } else if (display.state == Display.STATE_OFF) {
                Log.d("DisplayManager", "Screen OFF at ${System.currentTimeMillis()}")
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        startForegroundService()
        // Check permission first
        if (!appUsageTracker.hasUsageStatsPermission()) {
            // Request permission
//            showPermissionDialog()
        }

        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                context?.let {
                    when (intent?.action) {
                        Intent.ACTION_SCREEN_ON -> {
                            serviceScope.launch {
                                repository.updateWakeCount(1)
                            }
                            Log.d("ScreenWake", "Screen turned ON. Total wakes: ")
                        }
                    }
                }
            }
        }

    }

    private fun showPermissionDialog() {
        AlertDialog.Builder(this).setTitle("Usage Access Required")
            .setMessage("This app needs usage access permission to track app usage time.")
            .setPositiveButton("Grant Permission") { _, _ ->
                appUsageTracker.openUsageAccessSettings()
            }.setNegativeButton("Cancel", null).show()
    }


    override fun onServiceConnected() {
        super.onServiceConnected()

        val info = AccessibilityServiceInfo().apply {
            eventTypes =
                AccessibilityEvent.TYPE_VIEW_SCROLLED or AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags =
                AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS or AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
            notificationTimeout = 100
        }
        serviceInfo = info

        serviceScope.launch {
            loadActiveSessions()
        }
        registerReceiver(broadcastReceiver, IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
        })
//        displayManager.registerDisplayListener(listener,null)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event ?: return

        when (event.eventType) {
            AccessibilityEvent.TYPE_VIEW_SCROLLED -> handleScrollEvent(event)
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> handleWindowStateChanged(event)
            8192 -> {
                when (event.contentChangeTypes) {
                    AccessibilityEvent.CONTENT_CHANGE_TYPE_UNDEFINED -> {
                        // This fires both for ON and OFF, you need to check actual state
                        val pm = getSystemService(POWER_SERVICE) as PowerManager
                        if (pm.isInteractive) {
                            Log.d("ScreenWake 3", "Screen turned ON. Total wakes: ")
                        } else {
                            Log.d("MyAccessibilityService", "Screen OFF at ${System.currentTimeMillis()}")
                        }
                    }
                }
            }

        }
    }

    private fun handleScrollEvent(event: AccessibilityEvent) {
        serviceScope.launch {
            try {
                val packageName = event.packageName?.toString() ?: return@launch
                if (packageName == this@ScrollMonitoringService.packageName) return@launch

                val appName = getAppName(packageName)
                val scrollDistance = calculateScrollDistance(event)
                val scrollDistanceMeters = scrollDistance * pixelToMeterRatio
                val direction = calculateScrollDirection(event)

                val scrollEvent = ScrollEvent(
                    packageName = packageName,
                    appName = appName,
                    scrollDirection = direction,
                    scrollDistance = scrollDistance,
                    scrollDistanceMeters = scrollDistanceMeters,
                    screenPosition = """{"x": ${event.scrollX}, "y": ${event.scrollY}}""",
                    viewClassName = event.className?.toString(),
                    sessionId = getOrCreateSessionId(packageName)
                )

                repository.insertScrollEvent(scrollEvent)
                updateSessionScrollCount(packageName)

            } catch (e: Exception) {
                Log.e("ScrollService", "Error handling scroll event", e)
            }
        }
    }

    private fun handleWindowStateChanged(event: AccessibilityEvent) {
        serviceScope.launch {
            val packageName = event.packageName?.toString() ?: return@launch
            if (packageName == this@ScrollMonitoringService.packageName) return@launch

            val appName = getAppName(packageName)
            handleAppForeground(packageName, appName)
        }
    }

    private suspend fun handleAppForeground(packageName: String, appName: String) {
        // End any existing active sessions for other apps
        activeSessions.values.filter { it.packageName != packageName && it.isActive }
            .forEach { session ->
                val foregroundTime = appUsageTracker.getAppActiveTime(packageName)
                val updatedSession = session.copy(
                    sessionEnd = System.currentTimeMillis(),
//                    totalTimeSpent = System.currentTimeMillis() - session.sessionStart,
                    totalTimeSpent = foregroundTime, isActive = false
                )
                repository.updateAppUsageSession(updatedSession)
                activeSessions.remove(session.packageName)
            }

        // Start new session or continue existing one
        val existingSession = activeSessions[packageName]
        if (existingSession == null || !existingSession.isActive) {
            val newSession = AppUsageSession(
                packageName = packageName,
                appName = appName,
                sessionStart = System.currentTimeMillis(),
                wakeUpCount = 1,
                isActive = true
            )
            repository.insertAppUsageSession(newSession)
            activeSessions[packageName] = newSession
        }
    }

    private suspend fun getAppName(packageName: String): String {
        return try {
            val applicationInfo = packageManager.getApplicationInfo(packageName, 0)
            packageManager.getApplicationLabel(applicationInfo).toString()
        } catch (e: Exception) {
            packageName
        }
    }

    private fun calculateScrollDistance(event: AccessibilityEvent): Float {
        return maxOf(abs(event.scrollDeltaX.toFloat()), abs(event.scrollDeltaY.toFloat()))
    }

    private fun calculateScrollDirection(event: AccessibilityEvent): String {
        return when {
            abs(event.scrollDeltaY) > abs(event.scrollDeltaX) -> {
                if (event.scrollDeltaY > 0) "DOWN" else "UP"
            }

            else -> {
                if (event.scrollDeltaX > 0) "RIGHT" else "LEFT"
            }
        }
    }

    private fun getOrCreateSessionId(packageName: String): String {
        return activeSessions[packageName]?.id?.toString() ?: "unknown"
    }

    private suspend fun updateSessionScrollCount(packageName: String) {
        activeSessions[packageName]?.let { session ->
            val updatedSession = session.copy(scrollCount = session.scrollCount + 1)
            repository.updateAppUsageSession(updatedSession)
            activeSessions[packageName] = updatedSession
        }
    }

    private suspend fun loadActiveSessions() {
        val sessions = repository.getActiveSessions()
        sessions.forEach { session ->
            activeSessions[session.packageName] = session
        }
    }

    private fun startForegroundService() {
        val channelId = "scroll_monitoring_service"

        val channel = NotificationChannel(
            channelId, "Scroll Monitoring Service", NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Monitors scroll behavior and app usage"
            setShowBadge(false)
        }

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

        val notification =
            NotificationCompat.Builder(this, channelId).setContentTitle("Digital Wellbeing Active")
                .setContentText("Monitoring app usage and scroll behavior")
                .setSmallIcon(R.drawable.ic_monitor).setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_LOW).build()

        startForeground(1001, notification)
    }

    override fun onInterrupt() {}

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
        stopForeground(true)
        unregisterReceiver(broadcastReceiver)
    }
}
