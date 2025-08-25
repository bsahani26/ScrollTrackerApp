package com.example.scrolltracker.data.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.scrolltracker.data.entity.DailyStats;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class DailyStatsDao_Impl implements DailyStatsDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<DailyStats> __insertAdapterOfDailyStats;

  public DailyStatsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfDailyStats = new EntityInsertAdapter<DailyStats>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `daily_stats` (`date`,`totalScrollDistance`,`totalScrollCount`,`totalScreenTime`,`totalWakeUps`,`mostUsedApp`,`timestamp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final DailyStats entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getDate());
        }
        statement.bindDouble(2, entity.getTotalScrollDistance());
        statement.bindLong(3, entity.getTotalScrollCount());
        statement.bindLong(4, entity.getTotalScreenTime());
        statement.bindLong(5, entity.getTotalWakeUps());
        if (entity.getMostUsedApp() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getMostUsedApp());
        }
        statement.bindLong(7, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insertDailyStats(final DailyStats stats,
      final Continuation<? super Unit> $completion) {
    if (stats == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfDailyStats.insert(_connection, stats);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<DailyStats>> getRecentDailyStats(final int limit) {
    final String _sql = "SELECT * FROM daily_stats ORDER BY date DESC LIMIT ?";
    return FlowUtil.createFlow(__db, false, new String[] {"daily_stats"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, limit);
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfTotalScrollDistance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScrollDistance");
        final int _columnIndexOfTotalScrollCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScrollCount");
        final int _columnIndexOfTotalScreenTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScreenTime");
        final int _columnIndexOfTotalWakeUps = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalWakeUps");
        final int _columnIndexOfMostUsedApp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "mostUsedApp");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<DailyStats> _result = new ArrayList<DailyStats>();
        while (_stmt.step()) {
          final DailyStats _item;
          final String _tmpDate;
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmpDate = null;
          } else {
            _tmpDate = _stmt.getText(_columnIndexOfDate);
          }
          final float _tmpTotalScrollDistance;
          _tmpTotalScrollDistance = (float) (_stmt.getDouble(_columnIndexOfTotalScrollDistance));
          final int _tmpTotalScrollCount;
          _tmpTotalScrollCount = (int) (_stmt.getLong(_columnIndexOfTotalScrollCount));
          final long _tmpTotalScreenTime;
          _tmpTotalScreenTime = _stmt.getLong(_columnIndexOfTotalScreenTime);
          final int _tmpTotalWakeUps;
          _tmpTotalWakeUps = (int) (_stmt.getLong(_columnIndexOfTotalWakeUps));
          final String _tmpMostUsedApp;
          if (_stmt.isNull(_columnIndexOfMostUsedApp)) {
            _tmpMostUsedApp = null;
          } else {
            _tmpMostUsedApp = _stmt.getText(_columnIndexOfMostUsedApp);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new DailyStats(_tmpDate,_tmpTotalScrollDistance,_tmpTotalScrollCount,_tmpTotalScreenTime,_tmpTotalWakeUps,_tmpMostUsedApp,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getDailyStatsForDate(final String date,
      final Continuation<? super DailyStats> $completion) {
    final String _sql = "SELECT * FROM daily_stats WHERE date = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, date);
        }
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfTotalScrollDistance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScrollDistance");
        final int _columnIndexOfTotalScrollCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScrollCount");
        final int _columnIndexOfTotalScreenTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalScreenTime");
        final int _columnIndexOfTotalWakeUps = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalWakeUps");
        final int _columnIndexOfMostUsedApp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "mostUsedApp");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final DailyStats _result;
        if (_stmt.step()) {
          final String _tmpDate;
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmpDate = null;
          } else {
            _tmpDate = _stmt.getText(_columnIndexOfDate);
          }
          final float _tmpTotalScrollDistance;
          _tmpTotalScrollDistance = (float) (_stmt.getDouble(_columnIndexOfTotalScrollDistance));
          final int _tmpTotalScrollCount;
          _tmpTotalScrollCount = (int) (_stmt.getLong(_columnIndexOfTotalScrollCount));
          final long _tmpTotalScreenTime;
          _tmpTotalScreenTime = _stmt.getLong(_columnIndexOfTotalScreenTime);
          final int _tmpTotalWakeUps;
          _tmpTotalWakeUps = (int) (_stmt.getLong(_columnIndexOfTotalWakeUps));
          final String _tmpMostUsedApp;
          if (_stmt.isNull(_columnIndexOfMostUsedApp)) {
            _tmpMostUsedApp = null;
          } else {
            _tmpMostUsedApp = _stmt.getText(_columnIndexOfMostUsedApp);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _result = new DailyStats(_tmpDate,_tmpTotalScrollDistance,_tmpTotalScrollCount,_tmpTotalScreenTime,_tmpTotalWakeUps,_tmpMostUsedApp,_tmpTimestamp);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
