package com.example.scrolltracker.di

import android.app.NotificationManager
import android.content.Context
import androidx.room.Room
import com.example.scrolltracker.data.dao.AppUsageSessionDao
import com.example.scrolltracker.data.dao.DailyStatsDao
import com.example.scrolltracker.data.dao.ScrollEventDao
import com.example.scrolltracker.data.db.ScrollDatabase
import com.example.scrolltracker.service.AppUsageTracker
import com.example.scrolltracker.service.ScrollTracker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideScrollDatabase(@ApplicationContext context: Context): ScrollDatabase {
        return Room.databaseBuilder(
            context.applicationContext, ScrollDatabase::class.java, "scroll_monitoring_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideScrollEventDao(database: ScrollDatabase): ScrollEventDao = database.scrollEventDao()

    @Provides
    fun provideAppUsageSessionDao(database: ScrollDatabase): AppUsageSessionDao =
        database.appUsageSessionDao()

    @Provides
    fun provideDailyStatsDao(database: ScrollDatabase): DailyStatsDao = database.dailyStatsDao()
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppUsageTracker(@ApplicationContext context: Context): AppUsageTracker =
        AppUsageTracker(context)

    @Provides
    @Singleton
    fun provideNotificationManager(@ApplicationContext context: Context): NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @Provides
    @Singleton
    fun provideScrollTracker(@ApplicationContext context: Context): ScrollTracker = ScrollTracker()
}