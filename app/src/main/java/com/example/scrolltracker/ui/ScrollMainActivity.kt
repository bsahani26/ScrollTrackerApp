package com.example.scrolltracker.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scrolltracker.service.AppUsageTracker
import com.example.scrolltracker.theme.ScrollMonitoringTheme
import com.example.scrolltracker.ui.screens.ScrollMonitoringApp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScrollMainActivity : ComponentActivity() {
    @Inject
    lateinit var appUsageTracker: AppUsageTracker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!appUsageTracker.hasUsageStatsPermission()) {
            val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
            this.startActivity(intent)
        }

        setContent {
            ScrollMonitoringTheme {
                ScrollMonitoringApp()
            }
        }
    }
}