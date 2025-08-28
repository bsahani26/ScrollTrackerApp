package com.example.scrolltracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.scrolltracker.data.dao.AppUsageSessionDao
import com.example.scrolltracker.data.dao.DailyStatsDao
import com.example.scrolltracker.data.dao.ScrollEventDao
import com.example.scrolltracker.data.entity.AppUsageSession
import com.example.scrolltracker.data.entity.DailyStats
import com.example.scrolltracker.data.entity.ScrollEvent
import com.example.scrolltracker.data.entity.WakeCount
import java.util.Date

@Database(
    entities = [ScrollEvent::class, AppUsageSession::class, DailyStats::class, WakeCount::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ScrollDatabase : RoomDatabase() {
    abstract fun scrollEventDao(): ScrollEventDao
    abstract fun appUsageSessionDao(): AppUsageSessionDao
    abstract fun dailyStatsDao(): DailyStatsDao
}

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long): Date = Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time
}