package com.example.scrolltracker.ui.screens;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007\u001a \u0010\u000f\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a$\u0010\u0012\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a9\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010 \u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a*\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\'"}, d2 = {"DashboardScreen", "", "TodayStatsCard", "totalScrollMeters", "", "TimeRangeSelector", "selectedTimeRange", "Lcom/example/scrolltracker/ui/TimeRange;", "onTimeRangeSelected", "Lkotlin/Function1;", "ScrollActivityChart", "data", "", "Lcom/example/scrolltracker/data/dao/TimeBasedScrollStats;", "timeRange", "ScrollChart", "modifier", "Landroidx/compose/ui/Modifier;", "QuickStatsGrid", "scrollStats", "appUsageStats", "Lcom/example/scrolltracker/data/dao/AppUsageStats;", "QuickStatCard", "title", "", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "color", "Landroidx/compose/ui/graphics/Color;", "QuickStatCard-42QJj7c", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLandroidx/compose/ui/Modifier;)V", "TopAppsCard", "AppUsageItem", "appName", "screenTime", "", "wakeUps", "", "app_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TodayStatsCard(float totalScrollMeters) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    public static final void TimeRangeSelector(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.ui.TimeRange selectedTimeRange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.scrolltracker.ui.TimeRange, kotlin.Unit> onTimeRangeSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ScrollActivityChart(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats> data, @org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.ui.TimeRange timeRange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ScrollChart(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats> data, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    public static final void QuickStatsGrid(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats> scrollStats, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.data.dao.AppUsageStats> appUsageStats) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TopAppsCard(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.data.dao.AppUsageStats> appUsageStats) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AppUsageItem(@org.jetbrains.annotations.NotNull()
    java.lang.String appName, long screenTime, int wakeUps, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}