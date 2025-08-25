package com.example.scrolltracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.scrolltracker.data.entity.AppUsageSession
import com.example.scrolltracker.data.entity.DailyStats
import com.example.scrolltracker.data.entity.ScrollEvent
import com.example.scrolltracker.data.entity.WakeCount
import kotlinx.coroutines.flow.Flow

@Dao
interface ScrollEventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScrollEvent(event: ScrollEvent)

    @Query("""
        SELECT * FROM scroll_events 
        WHERE timestamp >= :startTime AND timestamp <= :endTime
        ORDER BY timestamp DESC
        LIMIT :limit
    """)
    fun getScrollEventsByTimeRange(
        startTime: Long,
        endTime: Long,
        limit: Int = 100
    ): Flow<List<ScrollEvent>>

    @Query("""
        SELECT 
            CASE 
                WHEN :groupByHour = 1 THEN strftime('%Y-%m-%d %H:00', timestamp/1000, 'unixepoch', 'localtime')
                ELSE strftime('%Y-%m-%d', timestamp/1000, 'unixepoch', 'localtime')
            END as timeGroup,
            COUNT(*) as scrollCount,
            SUM(scrollDistanceMeters) as totalDistance,
            AVG(scrollDistance) as avgDistance
        FROM scroll_events 
        WHERE timestamp >= :startTime AND timestamp <= :endTime
        GROUP BY timeGroup
        ORDER BY timeGroup
    """)
    fun getScrollStatsByTime(
        startTime: Long,
        endTime: Long,
        groupByHour: Boolean
    ): Flow<List<TimeBasedScrollStats>>

    @Query("""
        SELECT packageName, appName, 
               COUNT(*) as scrollCount,
               SUM(scrollDistanceMeters) as totalDistanceMeters,
               AVG(scrollDistance) as avgDistance
        FROM scroll_events 
        WHERE timestamp >= :startTime AND timestamp <= :endTime
        GROUP BY packageName 
        ORDER BY scrollCount DESC
        LIMIT :limit
    """)
    fun getAppScrollStats(
        startTime: Long,
        endTime: Long,
        limit: Int = 20
    ): Flow<List<AppScrollStats>>

    @Query("SELECT SUM(scrollDistanceMeters) FROM scroll_events WHERE DATE(timestamp/1000, 'unixepoch', 'localtime') = :date")
    suspend fun getTotalScrollMetersForDate(date: String): Float?

    @Query("DELETE FROM scroll_events WHERE timestamp < :cutoffTime")
    suspend fun deleteOldEvents(cutoffTime: Long)
}

@Dao
interface AppUsageSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: AppUsageSession)

    @Query("""
        INSERT INTO wake_count (id,wakeCount) VALUES(1,0)
        ON CONFLICT(id) DO
        UPDATE SET wakeCount = wakeCount + :count""")
    suspend fun updateWakeCount(count: Long)

    @Query("SELECT wakeCount FROM wake_count")
    fun getWakeCount(): Flow<Long>

    @Update
    suspend fun updateSession(session: AppUsageSession)

    @Query("SELECT * FROM app_usage_sessions WHERE isActive = 1")
    suspend fun getActiveSessions(): List<AppUsageSession>

    @Query("""
        SELECT packageName, appName,
               SUM(totalTimeSpent) as totalTime,
               COUNT(*) as sessionCount,
               SUM(wakeUpCount) as totalWakeUps
        FROM app_usage_sessions 
        WHERE sessionStart >= :startTime AND sessionStart <= :endTime
        GROUP BY packageName
        ORDER BY totalTime DESC
    """)
    fun getAppUsageStats(startTime: Long, endTime: Long): Flow<List<AppUsageStats>>

    @Query("""
        SELECT 
            strftime('%Y-%m-%d %H:00', sessionStart/1000, 'unixepoch', 'localtime') as hour,
            SUM(totalTimeSpent) as totalTime,
            COUNT(*) as sessionCount
        FROM app_usage_sessions 
        WHERE sessionStart >= :startTime AND sessionStart <= :endTime
        GROUP BY hour
        ORDER BY hour
    """)
    fun getHourlyUsageStats(startTime: Long, endTime: Long): Flow<List<HourlyUsageStats>>
}

@Dao
interface DailyStatsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyStats(stats: DailyStats)

    @Query("SELECT * FROM daily_stats ORDER BY date DESC LIMIT :limit")
    fun getRecentDailyStats(limit: Int = 30): Flow<List<DailyStats>>

    @Query("SELECT * FROM daily_stats WHERE date = :date")
    suspend fun getDailyStatsForDate(date: String): DailyStats?
}

// Data classes for query results
data class TimeBasedScrollStats(
    val timeGroup: String,
    val scrollCount: Int,
    val totalDistance: Float,
    val avgDistance: Float
)

data class AppScrollStats(
    val packageName: String,
    val appName: String,
    val scrollCount: Int,
    val totalDistanceMeters: Float,
    val avgDistance: Float
)

data class AppUsageStats(
    val packageName: String,
    val appName: String,
    val totalTime: Long,
    val sessionCount: Int,
    val totalWakeUps: Int
)

data class HourlyUsageStats(
    val hour: String,
    val totalTime: Long,
    val sessionCount: Int
)
