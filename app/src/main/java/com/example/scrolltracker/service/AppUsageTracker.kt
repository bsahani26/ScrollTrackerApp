package com.example.scrolltracker.service

import android.app.AppOpsManager
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.Process
import android.provider.Settings
import com.example.scrolltracker.data.dao.AppUsageStats
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Calendar
import java.util.TimeZone

class AppUsageTracker(private val context: Context) {

    private val usageStatsManager: UsageStatsManager by lazy {
        context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
    }

    /**
     * Get total foreground time for a specific app
     */
    fun getAppActiveTime(packageName: String, days: Int = 1): Long {

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startTime = calendar.timeInMillis
        val endTime = System.currentTimeMillis()

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY, startTime, endTime
        )

        return usageStats.find { it.packageName == packageName }?.totalTimeInForeground ?: 0L
    }

    /**
     * Get active time for all apps
     */
    fun getAllAppsActiveTime(days: Int = 1): Flow<Map<String, Long>> = flow {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startTime = calendar.timeInMillis
        val endTime = System.currentTimeMillis()

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY, startTime, endTime
        )

        emit(usageStats.filter { it.totalTimeInForeground > 0 }
            .associate { it.packageName to it.totalTimeInForeground }.toMap())
    }

    /**
     * Get detailed usage stats for an app
     */
    fun getDetailedAppStats(packageName: String, days: Int = 1): AppUsageStats? {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startTime = calendar.timeInMillis
        val endTime = System.currentTimeMillis()

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY, startTime, endTime
        )

        val stats = usageStats.find { it.packageName == packageName }

        return stats?.let {
            AppUsageStats(
                packageName = it.packageName,
                totalTimeInForeground = it.totalTimeInForeground,
                lastTimeUsed = it.lastTimeUsed,
                firstTimeStamp = it.firstTimeStamp,
                lastTimeStamp = it.lastTimeStamp,
                launchCount = it.totalTimeInForeground // Note: Launch count varies by API level
            )
        }
    }

    /**
     * Get detailed usage stats for all apps
     */
    fun getAllAppsDetailedState(days: Int = 1): Flow<List<AppUsageStats>> = flow {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startTime = calendar.timeInMillis

        calendar.add(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MILLISECOND, -1)
        val endTime = calendar.timeInMillis

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_BEST, startTime, endTime
        )

        val events = usageStatsManager.queryEvents(startTime, endTime)

        val appsRealUsedTime = getAllAppsRealUsedTime(events)

        emit(usageStats.map { stats ->
            AppUsageStats(
                packageName = stats.packageName,
                totalTimeInForeground = appsRealUsedTime[stats.packageName]?.totalForegroundTime
                    ?: 0L,
                lastTimeUsed = stats.lastTimeUsed,
                firstTimeStamp = stats.firstTimeStamp,
                lastTimeStamp = stats.lastTimeStamp,
                launchCount = appsRealUsedTime[stats.packageName]?.totalLaunchTime
                    ?: 0L// Note: Launch count varies by API level
            )
        }.filter { it.totalTimeInForeground > 0 }.sortedByDescending { it.totalTimeInForeground }
            .take(20))
    }

    /**
     * Get real foreground time of all apps
     */
    private fun getAllAppsRealUsedTime(events: UsageEvents): Map<String, AppRealUsage> {
        val usageStatsTime = HashMap<String, AppRealUsage>()
        var sessionStart = 0L
        while (events.hasNextEvent()) {
            var totalTime = 0L
            val event = UsageEvents.Event()
            events.getNextEvent(event)

            when (event.eventType) {

                UsageEvents.Event.ACTIVITY_RESUMED -> {
                    sessionStart = event.timeStamp
                }

                UsageEvents.Event.ACTIVITY_PAUSED -> {
                    if (sessionStart > 0) {
                        val sessionTime = event.timeStamp - sessionStart
                        // Only count sessions longer than 1 seconds
                        if (sessionTime >= 1000L) {
                            totalTime += sessionTime
                        }
                    }
                    sessionStart = 0
                }
            }
            var usageStats = usageStatsTime[event.packageName]
            if (usageStats != null) {
                usageStats.totalForegroundTime += totalTime
                usageStats.totalLaunchTime++
                usageStatsTime[event.packageName] = usageStats
            } else {
                usageStats = AppRealUsage(totalTime, 1)
            }
            usageStatsTime[event.packageName] = usageStats
        }
        return usageStatsTime
    }

    /**
     * Check if usage stats permission is granted
     */
    fun hasUsageStatsPermission(): Boolean {
        val appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = appOpsManager.checkOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS, Process.myUid(), context.packageName
        )
        return mode == AppOpsManager.MODE_ALLOWED
    }

    /**
     * Open usage access settings
     */
    fun openUsageAccessSettings() {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        context.startActivity(intent)
    }
}

data class AppRealUsage(
    var totalForegroundTime: Long, var totalLaunchTime: Long
)