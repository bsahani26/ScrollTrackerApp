package com.example.scrolltracker.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/example/scrolltracker/di/DatabaseModule;", "", "<init>", "()V", "provideScrollDatabase", "Lcom/example/scrolltracker/data/db/ScrollDatabase;", "context", "Landroid/content/Context;", "provideScrollEventDao", "Lcom/example/scrolltracker/data/dao/ScrollEventDao;", "database", "provideAppUsageSessionDao", "Lcom/example/scrolltracker/data/dao/AppUsageSessionDao;", "provideDailyStatsDao", "Lcom/example/scrolltracker/data/dao/DailyStatsDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.scrolltracker.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scrolltracker.data.db.ScrollDatabase provideScrollDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scrolltracker.data.dao.ScrollEventDao provideScrollEventDao(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.db.ScrollDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scrolltracker.data.dao.AppUsageSessionDao provideAppUsageSessionDao(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.db.ScrollDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scrolltracker.data.dao.DailyStatsDao provideDailyStatsDao(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.db.ScrollDatabase database) {
        return null;
    }
}