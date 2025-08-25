package com.example.scrolltracker.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ScrollMonitoringTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF6366F1),
            onPrimary = Color.White,
            secondary = Color(0xFF10B981),
            onSecondary = Color.White,
            surface = Color(0xFF1F2937),
            onSurface = Color(0xFFF9FAFB),
            background = Color(0xFF111827),
            onBackground = Color(0xFFF9FAFB)
        ),
        content = content
    )
}