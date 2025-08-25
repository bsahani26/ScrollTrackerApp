package com.example.scrolltracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "scroll_events")
data class ScrollEvent(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val packageName: String,
    val appName: String,
    val scrollDirection: String,
    val scrollDistance: Float, // in pixels
    val scrollDistanceMeters: Float, // converted to meters
    val timestamp: Long = System.currentTimeMillis(),
    val screenPosition: String,
    val viewClassName: String? = null,
    val sessionId: String // to track continuous usage
)

@Entity(tableName = "wake_count")
data class WakeCount(
    @PrimaryKey val id: Long = 0,
    val wakeCount: Long = 0
)

@Entity(tableName = "app_usage_sessions")
data class AppUsageSession(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val packageName: String,
    val appName: String,
    val sessionStart: Long,
    val sessionEnd: Long? = null,
    val totalTimeSpent: Long = 0, // in milliseconds
    val scrollCount: Int = 0,
    val wakeUpCount: Int = 0, // how many times app was opened
    val isActive: Boolean = true
)

@Entity(tableName = "daily_stats")
data class DailyStats(
    @PrimaryKey val date: String, // YYYY-MM-DD format
    val totalScrollDistance: Float, // in meters
    val totalScrollCount: Int, val totalScreenTime: Long, // in milliseconds
    val totalWakeUps: Int, val mostUsedApp: String, val timestamp: Long = System.currentTimeMillis()
)
