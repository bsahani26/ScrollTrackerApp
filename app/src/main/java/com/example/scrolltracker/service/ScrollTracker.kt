package com.example.scrolltracker.service

import android.app.usage.UsageStatsManager
import android.content.Context
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.sqrt

class ScrollTracker {
    private val appScrollData = ConcurrentHashMap<String, MutableList<ScrollPoint>>()
    private val appScrollMetrics = ConcurrentHashMap<String, ScrollMetrics>()
    private val scrollThreshold =
        50L // ms - minimum time between scroll events to consider as separate scroll session

    fun trackScroll(packageName: String, scrollX: Int, scrollY: Int, timestamp: Long) {
        val scrollPoints = appScrollData.getOrPut(packageName) { mutableListOf() }
        val newPoint = ScrollPoint(scrollX, scrollY, timestamp)

        scrollPoints.add(newPoint)

        // Calculate metrics when we have enough data points
        if (scrollPoints.size >= 2) {
            calculateScrollMetrics(packageName, scrollPoints)
        }

        // Keep only recent scroll points (last 100) to prevent memory issues
        if (scrollPoints.size > 100) {
            scrollPoints.removeAt(0)
        }
    }

    private fun calculateScrollMetrics(packageName: String, scrollPoints: List<ScrollPoint>) {
        if (scrollPoints.size < 2) return

        var totalDistance = 0f
        var totalDuration = 0L
        var activeDuration = 0L
        val speeds = mutableListOf<Float>()

        for (i in 1 until scrollPoints.size) {
            val prev = scrollPoints[i - 1]
            val current = scrollPoints[i]

            // Calculate distance between points
            val deltaX = (current.x - prev.x).toFloat()
            val deltaY = (current.y - prev.y).toFloat()
            val distance = sqrt(deltaX * deltaX + deltaY * deltaY)

            // Calculate time difference
            val timeDelta = current.timestamp - prev.timestamp

            if (timeDelta > 0 && distance > 0) {
                totalDistance += distance
                totalDuration += timeDelta

                // Calculate speed (pixels per second)
                val speed = distance / (timeDelta / 1000f)
                speeds.add(speed)

                // Consider as active scrolling if time difference is reasonable
                if (timeDelta <= scrollThreshold * 10) {
                    activeDuration += timeDelta
                }
            }
        }

        val averageSpeed = if (speeds.isNotEmpty()) speeds.average().toFloat() else 0f

        // Update metrics
        appScrollMetrics[packageName] = ScrollMetrics(
            totalDistance = totalDistance,
            averageSpeed = averageSpeed,
            activeDuration = activeDuration,
            scrollCount = scrollPoints.size
        )
    }

    fun getScrollMetrics(packageName: String): ScrollMetrics {
        return appScrollMetrics[packageName] ?: ScrollMetrics()
    }

    fun getAllScrollMetrics(): Map<String, ScrollMetrics> {
        return appScrollMetrics.toMap()
    }

    fun resetMetrics(packageName: String) {
        appScrollData.remove(packageName)
        appScrollMetrics.remove(packageName)
    }

    fun saveState() {
        // Implement saving to SharedPreferences or database if needed
        // This is where you'd persist the scroll data
    }
}