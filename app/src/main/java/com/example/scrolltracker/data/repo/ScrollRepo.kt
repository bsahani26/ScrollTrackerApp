package com.example.scrolltracker.data.repo

import com.example.scrolltracker.data.dao.AppScrollStats
import com.example.scrolltracker.data.dao.AppUsageSessionDao
import com.example.scrolltracker.data.dao.AppUsageStats
import com.example.scrolltracker.data.dao.DailyStatsDao
import com.example.scrolltracker.data.dao.HourlyUsageStats
import com.example.scrolltracker.data.dao.ScrollEventDao
import com.example.scrolltracker.data.dao.TimeBasedScrollStats
import com.example.scrolltracker.data.entity.AppUsageSession
import com.example.scrolltracker.data.entity.DailyStats
import com.example.scrolltracker.data.entity.ScrollEvent
import com.example.scrolltracker.data.entity.WakeCount
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScrollRepository @Inject constructor(
    private val scrollEventDao: ScrollEventDao,
    private val appUsageSessionDao: AppUsageSessionDao,
    private val dailyStatsDao: DailyStatsDao
) {

    suspend fun insertScrollEvent(event: ScrollEvent) {
        scrollEventDao.insertScrollEvent(event)
    }

    fun getScrollStatsByTime(
        startTime: Long,
        endTime: Long,
        groupByHour: Boolean = false
    ): Flow<List<TimeBasedScrollStats>> {
        return scrollEventDao.getScrollStatsByTime(startTime, endTime, groupByHour)
    }

    fun getAppScrollStats(startTime: Long, endTime: Long): Flow<List<AppScrollStats>> {
        return scrollEventDao.getAppScrollStats(startTime, endTime)
    }

    fun getAppUsageStats(startTime: Long, endTime: Long): Flow<List<AppUsageStats>> {
        return appUsageSessionDao.getAppUsageStats(startTime, endTime)
    }

    fun getHourlyUsageStats(startTime: Long, endTime: Long): Flow<List<HourlyUsageStats>> {
        return appUsageSessionDao.getHourlyUsageStats(startTime, endTime)
    }

    suspend fun getTotalScrollMetersToday(): Float {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return scrollEventDao.getTotalScrollMetersForDate(today) ?: 0f
    }

    suspend fun insertAppUsageSession(session: AppUsageSession) {
        appUsageSessionDao.insertSession(session)
    }

    suspend fun updateAppUsageSession(session: AppUsageSession) {
        appUsageSessionDao.updateSession(session)
    }

    suspend fun getActiveSessions(): List<AppUsageSession> {
        return appUsageSessionDao.getActiveSessions()
    }

    fun getRecentDailyStats(): Flow<List<DailyStats>> {
        return dailyStatsDao.getRecentDailyStats()
    }

    suspend fun updateWakeCount(wakeCount: Long) {
        appUsageSessionDao.updateWakeCount(wakeCount)
    }

    suspend fun getWakeCount(): Flow<Long> {
        return appUsageSessionDao.getWakeCount()
    }
}