package com.example.scrolltracker.data.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\'J,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\'J.\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u001c\u00a8\u0006\u001d\u00c0\u0006\u0003"}, d2 = {"Lcom/example/scrolltracker/data/dao/ScrollEventDao;", "", "insertScrollEvent", "", "event", "Lcom/example/scrolltracker/data/entity/ScrollEvent;", "(Lcom/example/scrolltracker/data/entity/ScrollEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScrollEventsByTimeRange", "Lkotlinx/coroutines/flow/Flow;", "", "startTime", "", "endTime", "limit", "", "getScrollStatsByTime", "Lcom/example/scrolltracker/data/dao/TimeBasedScrollStats;", "groupByHour", "", "getAppScrollStats", "Lcom/example/scrolltracker/data/dao/AppScrollStats;", "getTotalScrollMetersForDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldEvents", "cutoffTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ScrollEventDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertScrollEvent(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.ScrollEvent event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM scroll_events \n        WHERE timestamp >= :startTime AND timestamp <= :endTime\n        ORDER BY timestamp DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.entity.ScrollEvent>> getScrollEventsByTimeRange(long startTime, long endTime, int limit);
    
    @androidx.room.Query(value = "\n        SELECT \n            CASE \n                WHEN :groupByHour = 1 THEN strftime(\'%Y-%m-%d %H:00\', timestamp/1000, \'unixepoch\', \'localtime\')\n                ELSE strftime(\'%Y-%m-%d\', timestamp/1000, \'unixepoch\', \'localtime\')\n            END as timeGroup,\n            COUNT(*) as scrollCount,\n            SUM(scrollDistanceMeters) as totalDistance,\n            AVG(scrollDistance) as avgDistance\n        FROM scroll_events \n        WHERE timestamp >= :startTime AND timestamp <= :endTime\n        GROUP BY timeGroup\n        ORDER BY timeGroup\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.TimeBasedScrollStats>> getScrollStatsByTime(long startTime, long endTime, boolean groupByHour);
    
    @androidx.room.Query(value = "\n        SELECT packageName, appName, \n               COUNT(*) as scrollCount,\n               SUM(scrollDistanceMeters) as totalDistanceMeters,\n               AVG(scrollDistance) as avgDistance\n        FROM scroll_events \n        WHERE timestamp >= :startTime AND timestamp <= :endTime\n        GROUP BY packageName \n        ORDER BY scrollCount DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.AppScrollStats>> getAppScrollStats(long startTime, long endTime, int limit);
    
    @androidx.room.Query(value = "SELECT SUM(scrollDistanceMeters) FROM scroll_events WHERE DATE(timestamp/1000, \'unixepoch\', \'localtime\') = :date")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalScrollMetersForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Float> $completion);
    
    @androidx.room.Query(value = "DELETE FROM scroll_events WHERE timestamp < :cutoffTime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldEvents(long cutoffTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}