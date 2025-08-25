package com.example.scrolltracker

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.provider.Settings
import java.util.concurrent.TimeUnit

class AppUsageTracker(private val context: Context) {

    private val usageStatsManager: UsageStatsManager by lazy {
        context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
    }

    /**
     * Get total foreground time for a specific app
     */
    fun getAppActiveTime(packageName: String, days: Int = 1): Long {
        val endTime = System.currentTimeMillis()
        val startTime = endTime - TimeUnit.DAYS.toMillis(days.toLong())

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
        )

        return usageStats
            .find { it.packageName == packageName }
            ?.totalTimeInForeground ?: 0L
    }

    /**
     * Get active time for all apps
     */
    fun getAllAppsActiveTime(days: Int = 1): Map<String, Long> {
        val endTime = System.currentTimeMillis()
        val startTime = endTime - TimeUnit.DAYS.toMillis(days.toLong())

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
        )

        return usageStats
            .filter { it.totalTimeInForeground > 0 }
            .associate { it.packageName to it.totalTimeInForeground }
            .toMap()
    }

    /**
     * Get detailed usage stats for an app
     */
    fun getDetailedAppStats(packageName: String, days: Int = 1): AppUsageStats? {
        val endTime = System.currentTimeMillis()
        val startTime = endTime - TimeUnit.DAYS.toMillis(days.toLong())

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
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
     * Check if usage stats permission is granted
     */
    fun hasUsageStatsPermission(): Boolean {
        val appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as android.app.AppOpsManager
        val mode = appOpsManager.checkOpNoThrow(
            android.app.AppOpsManager.OPSTR_GET_USAGE_STATS,
            android.os.Process.myUid(),
            context.packageName
        )
        return mode == android.app.AppOpsManager.MODE_ALLOWED
    }

    /**
     * Open usage access settings
     */
    fun openUsageAccessSettings() {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        context.startActivity(intent)
    }
}

// Data class to hold app usage statistics
data class AppUsageStats(
    val packageName: String,
    val totalTimeInForeground: Long,
    val lastTimeUsed: Long,
    val firstTimeStamp: Long,
    val lastTimeStamp: Long,
    val launchCount: Long
)