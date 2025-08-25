package com.example.scrolltracker.ui;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\u001fH\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/example/scrolltracker/ui/ScrollAnalyticsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/scrolltracker/data/repo/ScrollRepository;", "<init>", "(Lcom/example/scrolltracker/data/repo/ScrollRepository;)V", "_selectedTimeRange", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/scrolltracker/ui/TimeRange;", "selectedTimeRange", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedTimeRange", "()Lkotlinx/coroutines/flow/StateFlow;", "_totalScrollMetersToday", "", "totalScrollMetersToday", "getTotalScrollMetersToday", "scrollStats", "", "Lcom/example/scrolltracker/data/dao/TimeBasedScrollStats;", "getScrollStats", "appScrollStats", "Lcom/example/scrolltracker/data/dao/AppScrollStats;", "getAppScrollStats", "appUsageStats", "Lcom/example/scrolltracker/data/dao/AppUsageStats;", "getAppUsageStats", "hourlyUsageStats", "Lcom/example/scrolltracker/data/dao/HourlyUsageStats;", "getHourlyUsageStats", "setTimeRange", "", "timeRange", "loadTotalScrollMetersToday", "refresh", "getTimeRangeMillis", "Lkotlin/Pair;", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ScrollAnalyticsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scrolltracker.data.repo.ScrollRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.scrolltracker.ui.TimeRange> _selectedTimeRange = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.scrolltracker.ui.TimeRange> selectedTimeRange = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> _totalScrollMetersToday = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> totalScrollMetersToday = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats>> scrollStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.AppScrollStats>> appScrollStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.AppUsageStats>> appUsageStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.HourlyUsageStats>> hourlyUsageStats = null;
    
    @javax.inject.Inject()
    public ScrollAnalyticsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.repo.ScrollRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.scrolltracker.ui.TimeRange> getSelectedTimeRange() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getTotalScrollMetersToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats>> getScrollStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.AppScrollStats>> getAppScrollStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.AppUsageStats>> getAppUsageStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.scrolltracker.data.dao.HourlyUsageStats>> getHourlyUsageStats() {
        return null;
    }
    
    public final void setTimeRange(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.ui.TimeRange timeRange) {
    }
    
    private final void loadTotalScrollMetersToday() {
    }
    
    public final void refresh() {
    }
    
    private final kotlin.Pair<java.lang.Long, java.lang.Long> getTimeRangeMillis(com.example.scrolltracker.ui.TimeRange timeRange) {
        return null;
    }
}