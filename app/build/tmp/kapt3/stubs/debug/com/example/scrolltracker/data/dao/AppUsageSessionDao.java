package com.example.scrolltracker.data.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\'J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\'\u00a8\u0006\u0013\u00c0\u0006\u0003"}, d2 = {"Lcom/example/scrolltracker/data/dao/AppUsageSessionDao;", "", "insertSession", "", "session", "Lcom/example/scrolltracker/data/entity/AppUsageSession;", "(Lcom/example/scrolltracker/data/entity/AppUsageSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "getActiveSessions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppUsageStats", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/scrolltracker/data/dao/AppUsageStats;", "startTime", "", "endTime", "getHourlyUsageStats", "Lcom/example/scrolltracker/data/dao/HourlyUsageStats;", "app_debug"})
@androidx.room.Dao()
public abstract interface AppUsageSessionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.AppUsageSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.entity.AppUsageSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM app_usage_sessions WHERE isActive = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveSessions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scrolltracker.data.entity.AppUsageSession>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT packageName, appName,\n               SUM(totalTimeSpent) as totalTime,\n               COUNT(*) as sessionCount,\n               SUM(wakeUpCount) as totalWakeUps\n        FROM app_usage_sessions \n        WHERE sessionStart >= :startTime AND sessionStart <= :endTime\n        GROUP BY packageName\n        ORDER BY totalTime DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.AppUsageStats>> getAppUsageStats(long startTime, long endTime);
    
    @androidx.room.Query(value = "\n        SELECT \n            strftime(\'%Y-%m-%d %H:00\', sessionStart/1000, \'unixepoch\', \'localtime\') as hour,\n            SUM(totalTimeSpent) as totalTime,\n            COUNT(*) as sessionCount\n        FROM app_usage_sessions \n        WHERE sessionStart >= :startTime AND sessionStart <= :endTime\n        GROUP BY hour\n        ORDER BY hour\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.scrolltracker.data.dao.HourlyUsageStats>> getHourlyUsageStats(long startTime, long endTime);
}