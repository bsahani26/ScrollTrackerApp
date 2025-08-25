package com.example.scrolltracker.ui.screens


import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.scrolltracker.data.dao.AppScrollStats
import com.example.scrolltracker.data.dao.AppUsageStats
import com.example.scrolltracker.data.dao.TimeBasedScrollStats
import com.example.scrolltracker.data.entity.WakeCount
import com.example.scrolltracker.formatDuration
import com.example.scrolltracker.getScrollDistanceComparison
import com.example.scrolltracker.isAccessibilityServiceEnabled
import com.example.scrolltracker.ui.ScrollAnalyticsViewModel
import com.example.scrolltracker.ui.TimeRange
import kotlin.collections.isNotEmpty

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    val viewModel: ScrollAnalyticsViewModel = hiltViewModel()
    val selectedTimeRange by viewModel.selectedTimeRange.collectAsState()
    val totalScrollMeters by viewModel.totalScrollMetersToday.collectAsState()
    val scrollStats by viewModel.scrollStats.collectAsState()
    val appUsageStats by viewModel.appUsageStats.collectAsState()
    val wakeCount by viewModel.wakeCount.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header with total scroll distance
        item {
            TodayStatsCard(totalScrollMeters = totalScrollMeters)
        }

        // Time range selector
        item {
            TimeRangeSelector(
                selectedTimeRange = selectedTimeRange,
                onTimeRangeSelected = viewModel::setTimeRange
            )
        }

        // Scroll activity chart
        item {
            ScrollActivityChart(
                data = scrollStats,
                timeRange = selectedTimeRange
            )
        }

        // Quick stats grid
        item {
            QuickStatsGrid(
                scrollStats = scrollStats,
                appUsageStats = appUsageStats,
                wakeCount = wakeCount
            )
        }

        // Top apps by usage
        item {
            TopAppsCard(appUsageStats = appUsageStats.take(5))
        }
    }
}

@Composable
fun TodayStatsCard(totalScrollMeters: Float) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Today's Scroll Distance",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${String.format("%.2f", totalScrollMeters)} meters",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "≈ ${(totalScrollMeters * 3.28084).toInt()} feet",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )
            }

            Icon(
                imageVector = Icons.Default.Height,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TimeRangeSelector(
    selectedTimeRange: TimeRange,
    onTimeRangeSelected: (TimeRange) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Time Range",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TimeRange.values().forEach { timeRange ->
                    FilterChip(
                        onClick = { onTimeRangeSelected(timeRange) },
                        label = {
                            Text(
                                text = timeRange.displayName,
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        selected = selectedTimeRange == timeRange,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollActivityChart(
    data: List<TimeBasedScrollStats>,
    timeRange: TimeRange
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Scroll Activity",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Timeline,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = if (timeRange.isHourly) "Hourly" else "Daily",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (data.isNotEmpty()) {
                ScrollChart(
                    data = data,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.BarChart,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "No data available",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ScrollChart(
    data: List<TimeBasedScrollStats>,
    modifier: Modifier = Modifier
) {
    // Custom chart implementation using Canvas
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val padding = 40.dp.toPx()

        if (data.isEmpty()) return@Canvas

        val maxValue = data.maxOfOrNull { it.scrollCount.toFloat() } ?: 1f
        val minValue = 0f
        val dataPoints = data.size

        val stepX = (width - 2 * padding) / (dataPoints - 1).coerceAtLeast(1)
        val stepY = height - 2 * padding

        val path = Path()
        val gradientPath = Path()

        // Create gradient
        val gradient = Brush.verticalGradient(
            colors = listOf(
                androidx.compose.ui.graphics.Color(0xFF6366F1).copy(alpha = 0.6f),
                androidx.compose.ui.graphics.Color(0xFF6366F1).copy(alpha = 0.1f)
            ),
            startY = padding,
            endY = height - padding
        )

        // Draw data points and lines
        data.forEachIndexed { index, point ->
            val x = padding + index * stepX
            val normalizedValue = (point.scrollCount - minValue) / (maxValue - minValue)
            val y = height - padding - (normalizedValue * stepY)

            if (index == 0) {
                path.moveTo(x, y)
                gradientPath.moveTo(x, height - padding)
                gradientPath.lineTo(x, y)
            } else {
                path.lineTo(x, y)
                gradientPath.lineTo(x, y)
            }

            // Draw data point
            drawCircle(
                color = androidx.compose.ui.graphics.Color(0xFF6366F1),
                radius = 4.dp.toPx(),
                center = Offset(x, y)
            )

            // Draw value text
            drawContext.canvas.nativeCanvas.drawText(
                point.scrollCount.toString(),
                x,
                y - 15.dp.toPx(),
                android.graphics.Paint().apply {
                    color = androidx.compose.ui.graphics.Color.White.toArgb()
                    textSize = 10.sp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }

        // Complete gradient path
        gradientPath.lineTo(padding + (dataPoints - 1) * stepX, height - padding)
        gradientPath.close()

        // Draw gradient fill
        drawPath(
            path = gradientPath,
            brush = gradient
        )

        // Draw line
        drawPath(
            path = path,
            color = androidx.compose.ui.graphics.Color(0xFF6366F1),
            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuickStatsGrid(
    scrollStats: List<TimeBasedScrollStats>,
    appUsageStats: List<AppUsageStats>,
    wakeCount: Long
) {
    val totalScrolls = scrollStats.sumOf { it.scrollCount }
    val totalDistance = scrollStats.sumOf { it.totalDistance.toDouble() }.toFloat()
    val totalScreenTime = appUsageStats.sumOf { it.totalTime }
    val totalWakeUps = appUsageStats.sumOf { it.totalWakeUps }

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        QuickStatCard(
            title = "Total Scrolls",
            value = totalScrolls.toString(),
            icon = Icons.Default.TouchApp,
            color = Color(0xFF10B981),
            modifier = Modifier.weight(1f)
        )

        QuickStatCard(
            title = "Distance",
            value = "${String.format("%.1f", totalDistance)}m",
            icon = Icons.Default.Height,
            color = Color(0xFF6366F1),
            modifier = Modifier.weight(1f)
        )

        QuickStatCard(
            title = "Screen Time",
            value = formatDuration(totalScreenTime),
            icon = Icons.Default.Schedule,
            color = Color(0xFFF59E0B),
            modifier = Modifier.weight(1f)
        )

        QuickStatCard(
            title = "Wake Ups",
            value = wakeCount.toString(),
            icon = Icons.Default.PhoneAndroid,
            color = Color(0xFFEF4444),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun QuickStatCard(
    title: String,
    value: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.1f)
        ),
        border = BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = color
                )
            }

            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = color
            )
        }
    }
}

@Composable
fun TopAppsCard(appUsageStats: List<AppUsageStats>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Top Apps",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Screen Time",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (appUsageStats.isNotEmpty()) {
                appUsageStats.forEach { app ->
                    AppUsageItem(
                        appName = app.appName,
                        screenTime = app.totalTime,
                        wakeUps = app.totalWakeUps,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No app usage data",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

@Composable
fun AppUsageItem(
    appName: String,
    screenTime: Long,
    wakeUps: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = appName,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$wakeUps wake-ups",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        Text(
            text = formatDuration(screenTime),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}
