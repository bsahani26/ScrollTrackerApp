package com.example.scrolltracker

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ScrollMonitoringApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize notification channels
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        val serviceChannel = NotificationChannel(
            "scroll_monitoring_service",
            "Scroll Monitoring Service",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Persistent notification for accessibility service"
            setShowBadge(false)
        }

        val alertChannel = NotificationChannel(
            "scroll_monitoring_alerts",
            "Scroll Monitoring Alerts",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Notifications about service status and insights"
        }

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(serviceChannel)
        notificationManager.createNotificationChannel(alertChannel)
    }
}