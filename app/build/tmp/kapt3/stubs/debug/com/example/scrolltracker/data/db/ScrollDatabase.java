package com.example.scrolltracker.data.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/scrolltracker/data/db/ScrollDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "scrollEventDao", "Lcom/example/scrolltracker/data/dao/ScrollEventDao;", "appUsageSessionDao", "Lcom/example/scrolltracker/data/dao/AppUsageSessionDao;", "dailyStatsDao", "Lcom/example/scrolltracker/data/dao/DailyStatsDao;", "app_debug"})
@androidx.room.Database(entities = {com.example.scrolltracker.data.entity.ScrollEvent.class, com.example.scrolltracker.data.entity.AppUsageSession.class, com.example.scrolltracker.data.entity.DailyStats.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.scrolltracker.data.db.Converters.class})
public abstract class ScrollDatabase extends androidx.room.RoomDatabase {
    
    public ScrollDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.scrolltracker.data.dao.ScrollEventDao scrollEventDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.scrolltracker.data.dao.AppUsageSessionDao appUsageSessionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.scrolltracker.data.dao.DailyStatsDao dailyStatsDao();
}