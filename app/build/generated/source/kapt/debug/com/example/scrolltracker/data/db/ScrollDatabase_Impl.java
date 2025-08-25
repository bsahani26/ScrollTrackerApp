package com.example.scrolltracker.data.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.example.scrolltracker.data.dao.AppUsageSessionDao;
import com.example.scrolltracker.data.dao.AppUsageSessionDao_Impl;
import com.example.scrolltracker.data.dao.DailyStatsDao;
import com.example.scrolltracker.data.dao.DailyStatsDao_Impl;
import com.example.scrolltracker.data.dao.ScrollEventDao;
import com.example.scrolltracker.data.dao.ScrollEventDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ScrollDatabase_Impl extends ScrollDatabase {
  private volatile ScrollEventDao _scrollEventDao;

  private volatile AppUsageSessionDao _appUsageSessionDao;

  private volatile DailyStatsDao _dailyStatsDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "712e7ac5936721f7aae0f5f81bd43998", "193509a2644f97245d74ef9623005851") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `scroll_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `appName` TEXT NOT NULL, `scrollDirection` TEXT NOT NULL, `scrollDistance` REAL NOT NULL, `scrollDistanceMeters` REAL NOT NULL, `timestamp` INTEGER NOT NULL, `screenPosition` TEXT NOT NULL, `viewClassName` TEXT, `sessionId` TEXT NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `app_usage_sessions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `appName` TEXT NOT NULL, `sessionStart` INTEGER NOT NULL, `sessionEnd` INTEGER, `totalTimeSpent` INTEGER NOT NULL, `scrollCount` INTEGER NOT NULL, `wakeUpCount` INTEGER NOT NULL, `isActive` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `daily_stats` (`date` TEXT NOT NULL, `totalScrollDistance` REAL NOT NULL, `totalScrollCount` INTEGER NOT NULL, `totalScreenTime` INTEGER NOT NULL, `totalWakeUps` INTEGER NOT NULL, `mostUsedApp` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`date`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '712e7ac5936721f7aae0f5f81bd43998')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `scroll_events`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `app_usage_sessions`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `daily_stats`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsScrollEvents = new HashMap<String, TableInfo.Column>(10);
        _columnsScrollEvents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("appName", new TableInfo.Column("appName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("scrollDirection", new TableInfo.Column("scrollDirection", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("scrollDistance", new TableInfo.Column("scrollDistance", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("scrollDistanceMeters", new TableInfo.Column("scrollDistanceMeters", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("screenPosition", new TableInfo.Column("screenPosition", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("viewClassName", new TableInfo.Column("viewClassName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScrollEvents.put("sessionId", new TableInfo.Column("sessionId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysScrollEvents = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesScrollEvents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScrollEvents = new TableInfo("scroll_events", _columnsScrollEvents, _foreignKeysScrollEvents, _indicesScrollEvents);
        final TableInfo _existingScrollEvents = TableInfo.read(connection, "scroll_events");
        if (!_infoScrollEvents.equals(_existingScrollEvents)) {
          return new RoomOpenDelegate.ValidationResult(false, "scroll_events(com.example.scrolltracker.data.entity.ScrollEvent).\n"
                  + " Expected:\n" + _infoScrollEvents + "\n"
                  + " Found:\n" + _existingScrollEvents);
        }
        final Map<String, TableInfo.Column> _columnsAppUsageSessions = new HashMap<String, TableInfo.Column>(9);
        _columnsAppUsageSessions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("appName", new TableInfo.Column("appName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("sessionStart", new TableInfo.Column("sessionStart", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("sessionEnd", new TableInfo.Column("sessionEnd", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("totalTimeSpent", new TableInfo.Column("totalTimeSpent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("scrollCount", new TableInfo.Column("scrollCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("wakeUpCount", new TableInfo.Column("wakeUpCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUsageSessions.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysAppUsageSessions = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesAppUsageSessions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppUsageSessions = new TableInfo("app_usage_sessions", _columnsAppUsageSessions, _foreignKeysAppUsageSessions, _indicesAppUsageSessions);
        final TableInfo _existingAppUsageSessions = TableInfo.read(connection, "app_usage_sessions");
        if (!_infoAppUsageSessions.equals(_existingAppUsageSessions)) {
          return new RoomOpenDelegate.ValidationResult(false, "app_usage_sessions(com.example.scrolltracker.data.entity.AppUsageSession).\n"
                  + " Expected:\n" + _infoAppUsageSessions + "\n"
                  + " Found:\n" + _existingAppUsageSessions);
        }
        final Map<String, TableInfo.Column> _columnsDailyStats = new HashMap<String, TableInfo.Column>(7);
        _columnsDailyStats.put("date", new TableInfo.Column("date", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("totalScrollDistance", new TableInfo.Column("totalScrollDistance", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("totalScrollCount", new TableInfo.Column("totalScrollCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("totalScreenTime", new TableInfo.Column("totalScreenTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("totalWakeUps", new TableInfo.Column("totalWakeUps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("mostUsedApp", new TableInfo.Column("mostUsedApp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyStats.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysDailyStats = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesDailyStats = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailyStats = new TableInfo("daily_stats", _columnsDailyStats, _foreignKeysDailyStats, _indicesDailyStats);
        final TableInfo _existingDailyStats = TableInfo.read(connection, "daily_stats");
        if (!_infoDailyStats.equals(_existingDailyStats)) {
          return new RoomOpenDelegate.ValidationResult(false, "daily_stats(com.example.scrolltracker.data.entity.DailyStats).\n"
                  + " Expected:\n" + _infoDailyStats + "\n"
                  + " Found:\n" + _existingDailyStats);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scroll_events", "app_usage_sessions", "daily_stats");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "scroll_events", "app_usage_sessions", "daily_stats");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ScrollEventDao.class, ScrollEventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AppUsageSessionDao.class, AppUsageSessionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DailyStatsDao.class, DailyStatsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ScrollEventDao scrollEventDao() {
    if (_scrollEventDao != null) {
      return _scrollEventDao;
    } else {
      synchronized(this) {
        if(_scrollEventDao == null) {
          _scrollEventDao = new ScrollEventDao_Impl(this);
        }
        return _scrollEventDao;
      }
    }
  }

  @Override
  public AppUsageSessionDao appUsageSessionDao() {
    if (_appUsageSessionDao != null) {
      return _appUsageSessionDao;
    } else {
      synchronized(this) {
        if(_appUsageSessionDao == null) {
          _appUsageSessionDao = new AppUsageSessionDao_Impl(this);
        }
        return _appUsageSessionDao;
      }
    }
  }

  @Override
  public DailyStatsDao dailyStatsDao() {
    if (_dailyStatsDao != null) {
      return _dailyStatsDao;
    } else {
      synchronized(this) {
        if(_dailyStatsDao == null) {
          _dailyStatsDao = new DailyStatsDao_Impl(this);
        }
        return _dailyStatsDao;
      }
    }
  }
}
