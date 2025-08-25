package com.example.scrolltracker

import android.content.Context
import android.provider.Settings

fun formatDuration(milliseconds: Long): String {
    val seconds = milliseconds / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    return when {
        days > 0 -> "${days}d ${hours % 24}h"
        hours > 0 -> "${hours}h ${minutes % 60}m"
        minutes > 0 -> "${minutes}m"
        else -> "${seconds}s"
    }
}

fun getScrollDistanceComparison(meters: Float): String {
    return when {
        meters < 1 -> "Less than 1 meter"
        meters < 10 -> "About ${meters.toInt()} meters\n(Like walking across a room)"
        meters < 100 -> "About ${meters.toInt()} meters\n(Like walking down a hallway)"
        meters < 1000 -> "About ${meters.toInt()} meters\n(Like walking ${(meters / 100).toInt()} city blocks)"
        else -> "About ${
            String.format(
                "%.1f",
                meters / 1000
            )
        } kilometers\n(That's a lot of scrolling!)"
    }
}

fun isAccessibilityServiceEnabled(context: Context): Boolean {
    val enabledServices = Settings.Secure.getString(
        context.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
    )
    return enabledServices?.contains(context.packageName) ?: false
}