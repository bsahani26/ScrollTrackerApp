package com.example.scrolltracker.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.scrolltracker.data.dao.AppUsageStats
import com.example.scrolltracker.data.dao.HourlyUsageStats
import com.example.scrolltracker.formatDuration
import com.example.scrolltracker.ui.ScrollAnalyticsViewModel
import com.example.scrolltracker.ui.TimeRange

@Composable
fun AppUsageScreen() {
    val viewModel: ScrollAnalyticsViewModel = hiltViewModel()
    val appUsageStats by viewModel.appUsageStats.collectAsState()
    val hourlyUsageStats by viewModel.hourlyUsageStats.collectAsState()
    val selectedTimeRange by viewModel.selectedTimeRange.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "App Usage Analytics", style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ), color = MaterialTheme.colorScheme.onBackground
            )
        }

        item {
            TimeRangeSelector(
                selectedTimeRange = selectedTimeRange, onTimeRangeSelected = viewModel::setTimeRange
            )
        }

        item {
            UsageTimeChart(
                data = hourlyUsageStats, timeRange = selectedTimeRange
            )
        }

        item {
            AppUsageDetailsList(appUsageStats = appUsageStats)
        }
    }
}

@Composable
fun UsageTimeChart(
    data: List<HourlyUsageStats>, timeRange: TimeRange
) {
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Screen Time Distribution",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (data.isNotEmpty()) {
                UsageChart(
                    data = data, modifier = Modifier.fillMaxWidth().height(200.dp)
                )
            } else {
                EmptyChartPlaceholder()
            }
        }
    }
}

@Composable
fun UsageChart(
    data: List<HourlyUsageStats>, modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val padding = 40.dp.toPx()
        val barWidth = (width - 2 * padding) / data.size.coerceAtLeast(1)

        if (data.isEmpty()) return@Canvas

        val maxValue = data.maxOfOrNull { it.totalTime.toFloat() } ?: 1f

        data.forEachIndexed { index, stat ->
            val barHeight = (stat.totalTime.toFloat() / maxValue) * (height - 2 * padding)
            val x = padding + index * barWidth
            val y = height - padding - barHeight

            // Draw bar
            drawRect(
                color = androidx.compose.ui.graphics.Color(0xFF10B981),
                topLeft = Offset(x + barWidth * 0.2f, y),
                size = Size(barWidth * 0.6f, barHeight)
            )

            // Draw hour label
            drawContext.canvas.nativeCanvas.drawText(
                stat.hour.takeLast(5), // Show HH:MM
                x + barWidth / 2, height - padding + 20.dp.toPx(), android.graphics.Paint().apply {
                    color = androidx.compose.ui.graphics.Color.White.toArgb()
                    textSize = 8.sp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                })
        }
    }
}

@Composable
fun AppUsageDetailsList(appUsageStats: List<AppUsageStats>) {
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Detailed App Usage",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (appUsageStats.isNotEmpty()) {
                appUsageStats.forEach { app ->
                    DetailedAppUsageItem(
                        appUsageStats = app, modifier = Modifier.padding(vertical = 8.dp)
                    )

                    if (app != appUsageStats.last()) {
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 4.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                        )
                    }
                }
            } else {
                EmptyDataPlaceholder("No app usage data available")
            }
        }
    }
}

@Composable
fun DetailedAppUsageItem(
    appUsageStats: AppUsageStats, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = appUsageStats.appName,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = appUsageStats.packageName,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                text = formatDuration(appUsageStats.totalTime),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatChip(
                label = "Sessions",
                value = appUsageStats.sessionCount.toString(),
                icon = Icons.Default.PlayCircleOutline
            )

            StatChip(
                label = "Wake-ups",
                value = appUsageStats.totalWakeUps.toString(),
                icon = Icons.Default.Notifications
            )
        }
    }
}
