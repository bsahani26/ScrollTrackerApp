package com.example.scrolltracker.`data`.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.scrolltracker.`data`.entity.ScrollEvent
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Float
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
public class ScrollEventDao_Impl(
  __db: RoomDatabase,
) : ScrollEventDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfScrollEvent: EntityInsertAdapter<ScrollEvent>
  init {
    this.__db = __db
    this.__insertAdapterOfScrollEvent = object : EntityInsertAdapter<ScrollEvent>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `scroll_events` (`id`,`packageName`,`appName`,`scrollDirection`,`scrollDistance`,`scrollDistanceMeters`,`timestamp`,`screenPosition`,`viewClassName`,`sessionId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ScrollEvent) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.packageName)
        statement.bindText(3, entity.appName)
        statement.bindText(4, entity.scrollDirection)
        statement.bindDouble(5, entity.scrollDistance.toDouble())
        statement.bindDouble(6, entity.scrollDistanceMeters.toDouble())
        statement.bindLong(7, entity.timestamp)
        statement.bindText(8, entity.screenPosition)
        val _tmpViewClassName: String? = entity.viewClassName
        if (_tmpViewClassName == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpViewClassName)
        }
        statement.bindText(10, entity.sessionId)
      }
    }
  }

  public override suspend fun insertScrollEvent(event: ScrollEvent): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfScrollEvent.insert(_connection, event)
  }

  public override fun getScrollEventsByTimeRange(
    startTime: Long,
    endTime: Long,
    limit: Int,
  ): Flow<List<ScrollEvent>> {
    val _sql: String = """
        |
        |        SELECT * FROM scroll_events 
        |        WHERE timestamp >= ? AND timestamp <= ?
        |        ORDER BY timestamp DESC
        |        LIMIT ?
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("scroll_events")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, startTime)
        _argIndex = 2
        _stmt.bindLong(_argIndex, endTime)
        _argIndex = 3
        _stmt.bindLong(_argIndex, limit.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfPackageName: Int = getColumnIndexOrThrow(_stmt, "packageName")
        val _columnIndexOfAppName: Int = getColumnIndexOrThrow(_stmt, "appName")
        val _columnIndexOfScrollDirection: Int = getColumnIndexOrThrow(_stmt, "scrollDirection")
        val _columnIndexOfScrollDistance: Int = getColumnIndexOrThrow(_stmt, "scrollDistance")
        val _columnIndexOfScrollDistanceMeters: Int = getColumnIndexOrThrow(_stmt,
            "scrollDistanceMeters")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfScreenPosition: Int = getColumnIndexOrThrow(_stmt, "screenPosition")
        val _columnIndexOfViewClassName: Int = getColumnIndexOrThrow(_stmt, "viewClassName")
        val _columnIndexOfSessionId: Int = getColumnIndexOrThrow(_stmt, "sessionId")
        val _result: MutableList<ScrollEvent> = mutableListOf()
        while (_stmt.step()) {
          val _item: ScrollEvent
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpPackageName: String
          _tmpPackageName = _stmt.getText(_columnIndexOfPackageName)
          val _tmpAppName: String
          _tmpAppName = _stmt.getText(_columnIndexOfAppName)
          val _tmpScrollDirection: String
          _tmpScrollDirection = _stmt.getText(_columnIndexOfScrollDirection)
          val _tmpScrollDistance: Float
          _tmpScrollDistance = _stmt.getDouble(_columnIndexOfScrollDistance).toFloat()
          val _tmpScrollDistanceMeters: Float
          _tmpScrollDistanceMeters = _stmt.getDouble(_columnIndexOfScrollDistanceMeters).toFloat()
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpScreenPosition: String
          _tmpScreenPosition = _stmt.getText(_columnIndexOfScreenPosition)
          val _tmpViewClassName: String?
          if (_stmt.isNull(_columnIndexOfViewClassName)) {
            _tmpViewClassName = null
          } else {
            _tmpViewClassName = _stmt.getText(_columnIndexOfViewClassName)
          }
          val _tmpSessionId: String
          _tmpSessionId = _stmt.getText(_columnIndexOfSessionId)
          _item =
              ScrollEvent(_tmpId,_tmpPackageName,_tmpAppName,_tmpScrollDirection,_tmpScrollDistance,_tmpScrollDistanceMeters,_tmpTimestamp,_tmpScreenPosition,_tmpViewClassName,_tmpSessionId)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getScrollStatsByTime(
    startTime: Long,
    endTime: Long,
    groupByHour: Boolean,
  ): Flow<List<TimeBasedScrollStats>> {
    val _sql: String = """
        |
        |        SELECT 
        |            CASE 
        |                WHEN ? = 1 THEN strftime('%Y-%m-%d %H:00', timestamp/1000, 'unixepoch', 'localtime')
        |                ELSE strftime('%Y-%m-%d', timestamp/1000, 'unixepoch', 'localtime')
        |            END as timeGroup,
        |            COUNT(*) as scrollCount,
        |            SUM(scrollDistanceMeters) as totalDistance,
        |            AVG(scrollDistance) as avgDistance
        |        FROM scroll_events 
        |        WHERE timestamp >= ? AND timestamp <= ?
        |        GROUP BY timeGroup
        |        ORDER BY timeGroup
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("scroll_events")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        val _tmp: Int = if (groupByHour) 1 else 0
        _stmt.bindLong(_argIndex, _tmp.toLong())
        _argIndex = 2
        _stmt.bindLong(_argIndex, startTime)
        _argIndex = 3
        _stmt.bindLong(_argIndex, endTime)
        val _columnIndexOfTimeGroup: Int = 0
        val _columnIndexOfScrollCount: Int = 1
        val _columnIndexOfTotalDistance: Int = 2
        val _columnIndexOfAvgDistance: Int = 3
        val _result: MutableList<TimeBasedScrollStats> = mutableListOf()
        while (_stmt.step()) {
          val _item: TimeBasedScrollStats
          val _tmpTimeGroup: String
          _tmpTimeGroup = _stmt.getText(_columnIndexOfTimeGroup)
          val _tmpScrollCount: Int
          _tmpScrollCount = _stmt.getLong(_columnIndexOfScrollCount).toInt()
          val _tmpTotalDistance: Float
          _tmpTotalDistance = _stmt.getDouble(_columnIndexOfTotalDistance).toFloat()
          val _tmpAvgDistance: Float
          _tmpAvgDistance = _stmt.getDouble(_columnIndexOfAvgDistance).toFloat()
          _item =
              TimeBasedScrollStats(_tmpTimeGroup,_tmpScrollCount,_tmpTotalDistance,_tmpAvgDistance)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getAppScrollStats(
    startTime: Long,
    endTime: Long,
    limit: Int,
  ): Flow<List<AppScrollStats>> {
    val _sql: String = """
        |
        |        SELECT packageName, appName, 
        |               COUNT(*) as scrollCount,
        |               SUM(scrollDistanceMeters) as totalDistanceMeters,
        |               AVG(scrollDistance) as avgDistance
        |        FROM scroll_events 
        |        WHERE timestamp >= ? AND timestamp <= ?
        |        GROUP BY packageName 
        |        ORDER BY scrollCount DESC
        |        LIMIT ?
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("scroll_events")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, startTime)
        _argIndex = 2
        _stmt.bindLong(_argIndex, endTime)
        _argIndex = 3
        _stmt.bindLong(_argIndex, limit.toLong())
        val _columnIndexOfPackageName: Int = 0
        val _columnIndexOfAppName: Int = 1
        val _columnIndexOfScrollCount: Int = 2
        val _columnIndexOfTotalDistanceMeters: Int = 3
        val _columnIndexOfAvgDistance: Int = 4
        val _result: MutableList<AppScrollStats> = mutableListOf()
        while (_stmt.step()) {
          val _item: AppScrollStats
          val _tmpPackageName: String
          _tmpPackageName = _stmt.getText(_columnIndexOfPackageName)
          val _tmpAppName: String
          _tmpAppName = _stmt.getText(_columnIndexOfAppName)
          val _tmpScrollCount: Int
          _tmpScrollCount = _stmt.getLong(_columnIndexOfScrollCount).toInt()
          val _tmpTotalDistanceMeters: Float
          _tmpTotalDistanceMeters = _stmt.getDouble(_columnIndexOfTotalDistanceMeters).toFloat()
          val _tmpAvgDistance: Float
          _tmpAvgDistance = _stmt.getDouble(_columnIndexOfAvgDistance).toFloat()
          _item =
              AppScrollStats(_tmpPackageName,_tmpAppName,_tmpScrollCount,_tmpTotalDistanceMeters,_tmpAvgDistance)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getTotalScrollMetersForDate(date: String): Float? {
    val _sql: String =
        "SELECT SUM(scrollDistanceMeters) FROM scroll_events WHERE DATE(timestamp/1000, 'unixepoch', 'localtime') = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, date)
        val _result: Float?
        if (_stmt.step()) {
          val _tmp: Float?
          if (_stmt.isNull(0)) {
            _tmp = null
          } else {
            _tmp = _stmt.getDouble(0).toFloat()
          }
          _result = _tmp
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteOldEvents(cutoffTime: Long) {
    val _sql: String = "DELETE FROM scroll_events WHERE timestamp < ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, cutoffTime)
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
