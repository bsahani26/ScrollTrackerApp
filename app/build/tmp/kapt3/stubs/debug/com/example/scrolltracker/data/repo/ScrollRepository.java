package com.example.scrolltracker.data.repo;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010$J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u0011H\u0086@\u00a2\u0006\u0002\u0010 J\u0012\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00110\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/scrolltracker/data/repo/ScrollRepository;", "", "scrollEventDao", "Lcom/example/scrolltracker/data/dao/ScrollEventDao;", "appUsageSessionDao", "Lcom/example/scrolltracker/data/dao/AppUsageSessionDao;", "dailyStatsDao", "Lcom/example/scrolltracker/data/dao/DailyStatsDao;", "<init>", "(Lcom/example/scrolltracker/data/dao/ScrollEventDao;Lcom/example/scrolltracker/data/dao/AppUsageSessionDao;Lcom/example/scrolltracker/data/dao/DailyStatsDao;)V", "insertScrollEvent", "", "event", "Lcom/example/scrolltracker/data/entity/ScrollEvent;", "(Lcom/example/scrolltracker/data/entity/ScrollEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScrollStatsByTime", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/scrolltracker/data/dao/TimeBasedScrollStats;", "startTime", "", "endTime", "groupByHour", "", "getAppScrollStats", "Lcom/example/scrolltracker/data/dao/AppScrollStats;", "getAppUsageStats", "Lcom/example/scrolltracker/data/dao/AppUsageStats;", "getHourlyUsageStats", "Lcom/example/scrolltracker/data/dao/HourlyUsageStats;", "getTotalScrollMetersToday", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAppUsageSession", "session", "Lcom/example/scrolltracker/data/entity/AppUsageSession;", "(Lcom/example/scrolltracker/data/entity/AppUsageSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppUsageSession", "getActiveSessions", "getRecentDailyStats", "Lcom/example/scrolltracker/data/entity/DailyStats;", "app_debug"})
public final class ScrollRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scrolltracker.data.dao.ScrollEventDao scrollEventDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.scrolltracker.data.dao.AppUsageSessionDao appUsageSessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.scrolltracker.data.dao.DailyStatsDao dailyStatsDao = null;
    
    @javax.inject.Inject()
    public ScrollRepository(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.dao.ScrollEventDao scrollEventDao, @org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.dao.AppUsageSessionDao appUsageSessionDao, @org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.dao.DailyStatsDao dailyStatsDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertScrollEvent(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.ScrollEvent event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats>> getScrollStatsByTime(long startTime, long endTime, boolean groupByHour) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.AppScrollStats>> getAppScrollStats(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.AppUsageStats>> getAppUsageStats(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.HourlyUsageStats>> getHourlyUsageStats(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTotalScrollMetersToday(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Float> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertAppUsageSession(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.AppUsageSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAppUsageSession(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.AppUsageSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getActiveSessions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scrolltracker.data.entity.AppUsageSession>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.entity.DailyStats>> getRecentDailyStats() {
        return null;
    }
}