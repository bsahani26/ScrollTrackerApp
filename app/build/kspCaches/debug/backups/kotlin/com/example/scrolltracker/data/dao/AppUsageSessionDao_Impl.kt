package com.example.scrolltracker.`data`.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.scrolltracker.`data`.entity.AppUsageSession
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppUsageSessionDao_Impl(
  __db: RoomDatabase,
) : AppUsageSessionDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfAppUsageSession: EntityInsertAdapter<AppUsageSession>

  private val __updateAdapterOfAppUsageSession: EntityDeleteOrUpdateAdapter<AppUsageSession>
  init {
    this.__db = __db
    this.__insertAdapterOfAppUsageSession = object : EntityInsertAdapter<AppUsageSession>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `app_usage_sessions` (`id`,`packageName`,`appName`,`sessionStart`,`sessionEnd`,`totalTimeSpent`,`scrollCount`,`wakeUpCount`,`isActive`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: AppUsageSession) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.packageName)
        statement.bindText(3, entity.appName)
        statement.bindLong(4, entity.sessionStart)
        val _tmpSessionEnd: Long? = entity.sessionEnd
        if (_tmpSessionEnd == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpSessionEnd)
        }
        statement.bindLong(6, entity.totalTimeSpent)
        statement.bindLong(7, entity.scrollCount.toLong())
        statement.bindLong(8, entity.wakeUpCount.toLong())
        val _tmp: Int = if (entity.isActive) 1 else 0
        statement.bindLong(9, _tmp.toLong())
      }
    }
    this.__updateAdapterOfAppUsageSession = object : EntityDeleteOrUpdateAdapter<AppUsageSession>()
        {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `app_usage_sessions` SET `id` = ?,`packageName` = ?,`appName` = ?,`sessionStart` = ?,`sessionEnd` = ?,`totalTimeSpent` = ?,`scrollCount` = ?,`wakeUpCount` = ?,`isActive` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: AppUsageSession) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.packageName)
        statement.bindText(3, entity.appName)
        statement.bindLong(4, entity.sessionStart)
        val _tmpSessionEnd: Long? = entity.sessionEnd
        if (_tmpSessionEnd == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpSessionEnd)
        }
        statement.bindLong(6, entity.totalTimeSpent)
        statement.bindLong(7, entity.scrollCount.toLong())
        statement.bindLong(8, entity.wakeUpCount.toLong())
        val _tmp: Int = if (entity.isActive) 1 else 0
        statement.bindLong(9, _tmp.toLong())
        statement.bindLong(10, entity.id)
      }
    }
  }

  public override suspend fun insertSession(session: AppUsageSession): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfAppUsageSession.insert(_connection, session)
  }

  public override suspend fun updateSession(session: AppUsageSession): Unit =
      performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfAppUsageSession.handle(_connection, session)
  }

  public override fun getWakeCount(): Flow<Long> {
    val _sql: String = "SELECT wakeCount FROM wake_count"
    return createFlow(__db, false, arrayOf("wake_count")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Long
        if (_stmt.step()) {
          _result = _stmt.getLong(0)
        } else {
          _result = 0L
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getActiveSessions(): List<AppUsageSession> {
    val _sql: String = "SELECT * FROM app_usage_sessions WHERE isActive = 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfPackageName: Int = getColumnIndexOrThrow(_stmt, "packageName")
        val _columnIndexOfAppName: Int = getColumnIndexOrThrow(_stmt, "appName")
        val _columnIndexOfSessionStart: Int = getColumnIndexOrThrow(_stmt, "sessionStart")
        val _columnIndexOfSessionEnd: Int = getColumnIndexOrThrow(_stmt, "sessionEnd")
        val _columnIndexOfTotalTimeSpent: Int = getColumnIndexOrThrow(_stmt, "totalTimeSpent")
        val _columnIndexOfScrollCount: Int = getColumnIndexOrThrow(_stmt, "scrollCount")
        val _columnIndexOfWakeUpCount: Int = getColumnIndexOrThrow(_stmt, "wakeUpCount")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<AppUsageSession> = mutableListOf()
        while (_stmt.step()) {
          val _item: AppUsageSession
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpPackageName: String
          _tmpPackageName = _stmt.getText(_columnIndexOfPackageName)
          val _tmpAppName: String
          _tmpAppName = _stmt.getText(_columnIndexOfAppName)
          val _tmpSessionStart: Long
          _tmpSessionStart = _stmt.getLong(_columnIndexOfSessionStart)
          val _tmpSessionEnd: Long?
          if (_stmt.isNull(_columnIndexOfSessionEnd)) {
            _tmpSessionEnd = null
          } else {
            _tmpSessionEnd = _stmt.getLong(_columnIndexOfSessionEnd)
          }
          val _tmpTotalTimeSpent: Long
          _tmpTotalTimeSpent = _stmt.getLong(_columnIndexOfTotalTimeSpent)
          val _tmpScrollCount: Int
          _tmpScrollCount = _stmt.getLong(_columnIndexOfScrollCount).toInt()
          val _tmpWakeUpCount: Int
          _tmpWakeUpCount = _stmt.getLong(_columnIndexOfWakeUpCount).toInt()
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item =
              AppUsageSession(_tmpId,_tmpPackageName,_tmpAppName,_tmpSessionStart,_tmpSessionEnd,_tmpTotalTimeSpent,_tmpScrollCount,_tmpWakeUpCount,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getAppUsageStats(startTime: Long, endTime: Long): Flow<List<AppUsageStats>> {
    val _sql: String = """
        |
        |        SELECT packageName, appName,
        |               SUM(totalTimeSpent) as totalTime,
        |               COUNT(*) as sessionCount,
        |               SUM(wakeUpCount) as totalWakeUps
        |        FROM app_usage_sessions 
        |        WHERE sessionStart >= ? AND sessionStart <= ?
        |        GROUP BY packageName
        |        ORDER BY totalTime DESC
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("app_usage_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, startTime)
        _argIndex = 2
        _stmt.bindLong(_argIndex, endTime)
        val _columnIndexOfPackageName: Int = 0
        val _columnIndexOfAppName: Int = 1
        val _columnIndexOfTotalTime: Int = 2
        val _columnIndexOfSessionCount: Int = 3
        val _columnIndexOfTotalWakeUps: Int = 4
        val _result: MutableList<AppUsageStats> = mutableListOf()
        while (_stmt.step()) {
          val _item: AppUsageStats
          val _tmpPackageName: String
          _tmpPackageName = _stmt.getText(_columnIndexOfPackageName)
          val _tmpAppName: String
          _tmpAppName = _stmt.getText(_columnIndexOfAppName)
          val _tmpTotalTime: Long
          _tmpTotalTime = _stmt.getLong(_columnIndexOfTotalTime)
          val _tmpSessionCount: Int
          _tmpSessionCount = _stmt.getLong(_columnIndexOfSessionCount).toInt()
          val _tmpTotalWakeUps: Int
          _tmpTotalWakeUps = _stmt.getLong(_columnIndexOfTotalWakeUps).toInt()
          _item =
              AppUsageStats(_tmpPackageName,_tmpAppName,_tmpTotalTime,_tmpSessionCount,_tmpTotalWakeUps)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getHourlyUsageStats(startTime: Long, endTime: Long):
      Flow<List<HourlyUsageStats>> {
    val _sql: String = """
        |
        |        SELECT 
        |            strftime('%Y-%m-%d %H:00', sessionStart/1000, 'unixepoch', 'localtime') as hour,
        |            SUM(totalTimeSpent) as totalTime,
        |            COUNT(*) as sessionCount
        |        FROM app_usage_sessions 
        |        WHERE sessionStart >= ? AND sessionStart <= ?
        |        GROUP BY hour
        |        ORDER BY hour
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("app_usage_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, startTime)
        _argIndex = 2
        _stmt.bindLong(_argIndex, endTime)
        val _columnIndexOfHour: Int = 0
        val _columnIndexOfTotalTime: Int = 1
        val _columnIndexOfSessionCount: Int = 2
        val _result: MutableList<HourlyUsageStats> = mutableListOf()
        while (_stmt.step()) {
          val _item: HourlyUsageStats
          val _tmpHour: String
          _tmpHour = _stmt.getText(_columnIndexOfHour)
          val _tmpTotalTime: Long
          _tmpTotalTime = _stmt.getLong(_columnIndexOfTotalTime)
          val _tmpSessionCount: Int
          _tmpSessionCount = _stmt.getLong(_columnIndexOfSessionCount).toInt()
          _item = HourlyUsageStats(_tmpHour,_tmpTotalTime,_tmpSessionCount)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateWakeCount(count: Long) {
    val _sql: String = """
        |
        |        INSERT INTO wake_count (id,wakeCount) VALUES(1,0)
        |        ON CONFLICT(id) DO
        |        UPDATE SET wakeCount = wakeCount + ?
        """.trimMargin()
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, count)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
