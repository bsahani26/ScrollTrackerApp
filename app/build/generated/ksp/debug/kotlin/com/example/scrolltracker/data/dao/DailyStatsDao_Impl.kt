package com.example.scrolltracker.`data`.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.scrolltracker.`data`.entity.DailyStats
import javax.`annotation`.processing.Generated
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
public class DailyStatsDao_Impl(
  __db: RoomDatabase,
) : DailyStatsDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfDailyStats: EntityInsertAdapter<DailyStats>
  init {
    this.__db = __db
    this.__insertAdapterOfDailyStats = object : EntityInsertAdapter<DailyStats>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `daily_stats` (`date`,`totalScrollDistance`,`totalScrollCount`,`totalScreenTime`,`totalWakeUps`,`mostUsedApp`,`timestamp`) VALUES (?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: DailyStats) {
        statement.bindText(1, entity.date)
        statement.bindDouble(2, entity.totalScrollDistance.toDouble())
        statement.bindLong(3, entity.totalScrollCount.toLong())
        statement.bindLong(4, entity.totalScreenTime)
        statement.bindLong(5, entity.totalWakeUps.toLong())
        statement.bindText(6, entity.mostUsedApp)
        statement.bindLong(7, entity.timestamp)
      }
    }
  }

  public override suspend fun insertDailyStats(stats: DailyStats): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfDailyStats.insert(_connection, stats)
  }

  public override fun getRecentDailyStats(limit: Int): Flow<List<DailyStats>> {
    val _sql: String = "SELECT * FROM daily_stats ORDER BY date DESC LIMIT ?"
    return createFlow(__db, false, arrayOf("daily_stats")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, limit.toLong())
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfTotalScrollDistance: Int = getColumnIndexOrThrow(_stmt,
            "totalScrollDistance")
        val _columnIndexOfTotalScrollCount: Int = getColumnIndexOrThrow(_stmt, "totalScrollCount")
        val _columnIndexOfTotalScreenTime: Int = getColumnIndexOrThrow(_stmt, "totalScreenTime")
        val _columnIndexOfTotalWakeUps: Int = getColumnIndexOrThrow(_stmt, "totalWakeUps")
        val _columnIndexOfMostUsedApp: Int = getColumnIndexOrThrow(_stmt, "mostUsedApp")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _result: MutableList<DailyStats> = mutableListOf()
        while (_stmt.step()) {
          val _item: DailyStats
          val _tmpDate: String
          _tmpDate = _stmt.getText(_columnIndexOfDate)
          val _tmpTotalScrollDistance: Float
          _tmpTotalScrollDistance = _stmt.getDouble(_columnIndexOfTotalScrollDistance).toFloat()
          val _tmpTotalScrollCount: Int
          _tmpTotalScrollCount = _stmt.getLong(_columnIndexOfTotalScrollCount).toInt()
          val _tmpTotalScreenTime: Long
          _tmpTotalScreenTime = _stmt.getLong(_columnIndexOfTotalScreenTime)
          val _tmpTotalWakeUps: Int
          _tmpTotalWakeUps = _stmt.getLong(_columnIndexOfTotalWakeUps).toInt()
          val _tmpMostUsedApp: String
          _tmpMostUsedApp = _stmt.getText(_columnIndexOfMostUsedApp)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          _item =
              DailyStats(_tmpDate,_tmpTotalScrollDistance,_tmpTotalScrollCount,_tmpTotalScreenTime,_tmpTotalWakeUps,_tmpMostUsedApp,_tmpTimestamp)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getDailyStatsForDate(date: String): DailyStats? {
    val _sql: String = "SELECT * FROM daily_stats WHERE date = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, date)
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfTotalScrollDistance: Int = getColumnIndexOrThrow(_stmt,
            "totalScrollDistance")
        val _columnIndexOfTotalScrollCount: Int = getColumnIndexOrThrow(_stmt, "totalScrollCount")
        val _columnIndexOfTotalScreenTime: Int = getColumnIndexOrThrow(_stmt, "totalScreenTime")
        val _columnIndexOfTotalWakeUps: Int = getColumnIndexOrThrow(_stmt, "totalWakeUps")
        val _columnIndexOfMostUsedApp: Int = getColumnIndexOrThrow(_stmt, "mostUsedApp")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _result: DailyStats?
        if (_stmt.step()) {
          val _tmpDate: String
          _tmpDate = _stmt.getText(_columnIndexOfDate)
          val _tmpTotalScrollDistance: Float
          _tmpTotalScrollDistance = _stmt.getDouble(_columnIndexOfTotalScrollDistance).toFloat()
          val _tmpTotalScrollCount: Int
          _tmpTotalScrollCount = _stmt.getLong(_columnIndexOfTotalScrollCount).toInt()
          val _tmpTotalScreenTime: Long
          _tmpTotalScreenTime = _stmt.getLong(_columnIndexOfTotalScreenTime)
          val _tmpTotalWakeUps: Int
          _tmpTotalWakeUps = _stmt.getLong(_columnIndexOfTotalWakeUps).toInt()
          val _tmpMostUsedApp: String
          _tmpMostUsedApp = _stmt.getText(_columnIndexOfMostUsedApp)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          _result =
              DailyStats(_tmpDate,_tmpTotalScrollDistance,_tmpTotalScrollCount,_tmpTotalScreenTime,_tmpTotalWakeUps,_tmpMostUsedApp,_tmpTimestamp)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
