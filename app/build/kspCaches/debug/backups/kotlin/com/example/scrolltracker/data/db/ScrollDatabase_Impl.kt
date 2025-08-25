package com.example.scrolltracker.`data`.db

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.scrolltracker.`data`.dao.AppUsageSessionDao
import com.example.scrolltracker.`data`.dao.AppUsageSessionDao_Impl
import com.example.scrolltracker.`data`.dao.DailyStatsDao
import com.example.scrolltracker.`data`.dao.DailyStatsDao_Impl
import com.example.scrolltracker.`data`.dao.ScrollEventDao
import com.example.scrolltracker.`data`.dao.ScrollEventDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ScrollDatabase_Impl : ScrollDatabase() {
  private val _scrollEventDao: Lazy<ScrollEventDao> = lazy {
    ScrollEventDao_Impl(this)
  }

  private val _appUsageSessionDao: Lazy<AppUsageSessionDao> = lazy {
    AppUsageSessionDao_Impl(this)
  }

  private val _dailyStatsDao: Lazy<DailyStatsDao> = lazy {
    DailyStatsDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(3,
        "0cea742aa17b751a000a05b9dba76fe0", "2969f471efb67f5d09e3094881577103") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `scroll_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `appName` TEXT NOT NULL, `scrollDirection` TEXT NOT NULL, `scrollDistance` REAL NOT NULL, `scrollDistanceMeters` REAL NOT NULL, `timestamp` INTEGER NOT NULL, `screenPosition` TEXT NOT NULL, `viewClassName` TEXT, `sessionId` TEXT NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `app_usage_sessions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `appName` TEXT NOT NULL, `sessionStart` INTEGER NOT NULL, `sessionEnd` INTEGER, `totalTimeSpent` INTEGER NOT NULL, `scrollCount` INTEGER NOT NULL, `wakeUpCount` INTEGER NOT NULL, `isActive` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `daily_stats` (`date` TEXT NOT NULL, `totalScrollDistance` REAL NOT NULL, `totalScrollCount` INTEGER NOT NULL, `totalScreenTime` INTEGER NOT NULL, `totalWakeUps` INTEGER NOT NULL, `mostUsedApp` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`date`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `wake_count` (`id` INTEGER NOT NULL, `wakeCount` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0cea742aa17b751a000a05b9dba76fe0')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `scroll_events`")
        connection.execSQL("DROP TABLE IF EXISTS `app_usage_sessions`")
        connection.execSQL("DROP TABLE IF EXISTS `daily_stats`")
        connection.execSQL("DROP TABLE IF EXISTS `wake_count`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsScrollEvents: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsScrollEvents.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("packageName", TableInfo.Column("packageName", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("appName", TableInfo.Column("appName", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("scrollDirection", TableInfo.Column("scrollDirection", "TEXT",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("scrollDistance", TableInfo.Column("scrollDistance", "REAL", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("scrollDistanceMeters", TableInfo.Column("scrollDistanceMeters",
            "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("timestamp", TableInfo.Column("timestamp", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("screenPosition", TableInfo.Column("screenPosition", "TEXT", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("viewClassName", TableInfo.Column("viewClassName", "TEXT", false,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScrollEvents.put("sessionId", TableInfo.Column("sessionId", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysScrollEvents: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesScrollEvents: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoScrollEvents: TableInfo = TableInfo("scroll_events", _columnsScrollEvents,
            _foreignKeysScrollEvents, _indicesScrollEvents)
        val _existingScrollEvents: TableInfo = read(connection, "scroll_events")
        if (!_infoScrollEvents.equals(_existingScrollEvents)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |scroll_events(com.example.scrolltracker.data.entity.ScrollEvent).
              | Expected:
              |""".trimMargin() + _infoScrollEvents + """
              |
              | Found:
              |""".trimMargin() + _existingScrollEvents)
        }
        val _columnsAppUsageSessions: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsAppUsageSessions.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("packageName", TableInfo.Column("packageName", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("appName", TableInfo.Column("appName", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("sessionStart", TableInfo.Column("sessionStart", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("sessionEnd", TableInfo.Column("sessionEnd", "INTEGER", false,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("totalTimeSpent", TableInfo.Column("totalTimeSpent", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("scrollCount", TableInfo.Column("scrollCount", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("wakeUpCount", TableInfo.Column("wakeUpCount", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAppUsageSessions.put("isActive", TableInfo.Column("isActive", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysAppUsageSessions: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesAppUsageSessions: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoAppUsageSessions: TableInfo = TableInfo("app_usage_sessions",
            _columnsAppUsageSessions, _foreignKeysAppUsageSessions, _indicesAppUsageSessions)
        val _existingAppUsageSessions: TableInfo = read(connection, "app_usage_sessions")
        if (!_infoAppUsageSessions.equals(_existingAppUsageSessions)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |app_usage_sessions(com.example.scrolltracker.data.entity.AppUsageSession).
              | Expected:
              |""".trimMargin() + _infoAppUsageSessions + """
              |
              | Found:
              |""".trimMargin() + _existingAppUsageSessions)
        }
        val _columnsDailyStats: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsDailyStats.put("date", TableInfo.Column("date", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("totalScrollDistance", TableInfo.Column("totalScrollDistance",
            "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("totalScrollCount", TableInfo.Column("totalScrollCount", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("totalScreenTime", TableInfo.Column("totalScreenTime", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("totalWakeUps", TableInfo.Column("totalWakeUps", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("mostUsedApp", TableInfo.Column("mostUsedApp", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsDailyStats.put("timestamp", TableInfo.Column("timestamp", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysDailyStats: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesDailyStats: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoDailyStats: TableInfo = TableInfo("daily_stats", _columnsDailyStats,
            _foreignKeysDailyStats, _indicesDailyStats)
        val _existingDailyStats: TableInfo = read(connection, "daily_stats")
        if (!_infoDailyStats.equals(_existingDailyStats)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |daily_stats(com.example.scrolltracker.data.entity.DailyStats).
              | Expected:
              |""".trimMargin() + _infoDailyStats + """
              |
              | Found:
              |""".trimMargin() + _existingDailyStats)
        }
        val _columnsWakeCount: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsWakeCount.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsWakeCount.put("wakeCount", TableInfo.Column("wakeCount", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysWakeCount: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesWakeCount: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoWakeCount: TableInfo = TableInfo("wake_count", _columnsWakeCount,
            _foreignKeysWakeCount, _indicesWakeCount)
        val _existingWakeCount: TableInfo = read(connection, "wake_count")
        if (!_infoWakeCount.equals(_existingWakeCount)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |wake_count(com.example.scrolltracker.data.entity.WakeCount).
              | Expected:
              |""".trimMargin() + _infoWakeCount + """
              |
              | Found:
              |""".trimMargin() + _existingWakeCount)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "scroll_events",
        "app_usage_sessions", "daily_stats", "wake_count")
  }

  public override fun clearAllTables() {
    super.performClear(false, "scroll_events", "app_usage_sessions", "daily_stats", "wake_count")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(ScrollEventDao::class, ScrollEventDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(AppUsageSessionDao::class,
        AppUsageSessionDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(DailyStatsDao::class, DailyStatsDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun scrollEventDao(): ScrollEventDao = _scrollEventDao.value

  public override fun appUsageSessionDao(): AppUsageSessionDao = _appUsageSessionDao.value

  public override fun dailyStatsDao(): DailyStatsDao = _dailyStatsDao.value
}
