package com.example.scrolltracker.data.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.scrolltracker.data.entity.ScrollEvent;
import java.lang.Class;
import java.lang.Float;
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
public final class ScrollEventDao_Impl implements ScrollEventDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<ScrollEvent> __insertAdapterOfScrollEvent;

  public ScrollEventDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfScrollEvent = new EntityInsertAdapter<ScrollEvent>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `scroll_events` (`id`,`packageName`,`appName`,`scrollDirection`,`scrollDistance`,`scrollDistanceMeters`,`timestamp`,`screenPosition`,`viewClassName`,`sessionId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final ScrollEvent entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPackageName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getPackageName());
        }
        if (entity.getAppName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getAppName());
        }
        if (entity.getScrollDirection() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getScrollDirection());
        }
        statement.bindDouble(5, entity.getScrollDistance());
        statement.bindDouble(6, entity.getScrollDistanceMeters());
        statement.bindLong(7, entity.getTimestamp());
        if (entity.getScreenPosition() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getScreenPosition());
        }
        if (entity.getViewClassName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getViewClassName());
        }
        if (entity.getSessionId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getSessionId());
        }
      }
    };
  }

  @Override
  public Object insertScrollEvent(final ScrollEvent event,
      final Continuation<? super Unit> $completion) {
    if (event == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfScrollEvent.insert(_connection, event);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<ScrollEvent>> getScrollEventsByTimeRange(final long startTime,
      final long endTime, final int limit) {
    final String _sql = "\n"
            + "        SELECT * FROM scroll_events \n"
            + "        WHERE timestamp >= ? AND timestamp <= ?\n"
            + "        ORDER BY timestamp DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"scroll_events"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, startTime);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, endTime);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, limit);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfPackageName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "packageName");
        final int _columnIndexOfAppName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "appName");
        final int _columnIndexOfScrollDirection = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scrollDirection");
        final int _columnIndexOfScrollDistance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scrollDistance");
        final int _columnIndexOfScrollDistanceMeters = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scrollDistanceMeters");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final int _columnIndexOfScreenPosition = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "screenPosition");
        final int _columnIndexOfViewClassName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "viewClassName");
        final int _columnIndexOfSessionId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sessionId");
        final List<ScrollEvent> _result = new ArrayList<ScrollEvent>();
        while (_stmt.step()) {
          final ScrollEvent _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpPackageName;
          if (_stmt.isNull(_columnIndexOfPackageName)) {
            _tmpPackageName = null;
          } else {
            _tmpPackageName = _stmt.getText(_columnIndexOfPackageName);
          }
          final String _tmpAppName;
          if (_stmt.isNull(_columnIndexOfAppName)) {
            _tmpAppName = null;
          } else {
            _tmpAppName = _stmt.getText(_columnIndexOfAppName);
          }
          final String _tmpScrollDirection;
          if (_stmt.isNull(_columnIndexOfScrollDirection)) {
            _tmpScrollDirection = null;
          } else {
            _tmpScrollDirection = _stmt.getText(_columnIndexOfScrollDirection);
          }
          final float _tmpScrollDistance;
          _tmpScrollDistance = (float) (_stmt.getDouble(_columnIndexOfScrollDistance));
          final float _tmpScrollDistanceMeters;
          _tmpScrollDistanceMeters = (float) (_stmt.getDouble(_columnIndexOfScrollDistanceMeters));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          final String _tmpScreenPosition;
          if (_stmt.isNull(_columnIndexOfScreenPosition)) {
            _tmpScreenPosition = null;
          } else {
            _tmpScreenPosition = _stmt.getText(_columnIndexOfScreenPosition);
          }
          final String _tmpViewClassName;
          if (_stmt.isNull(_columnIndexOfViewClassName)) {
            _tmpViewClassName = null;
          } else {
            _tmpViewClassName = _stmt.getText(_columnIndexOfViewClassName);
          }
          final String _tmpSessionId;
          if (_stmt.isNull(_columnIndexOfSessionId)) {
            _tmpSessionId = null;
          } else {
            _tmpSessionId = _stmt.getText(_columnIndexOfSessionId);
          }
          _item = new ScrollEvent(_tmpId,_tmpPackageName,_tmpAppName,_tmpScrollDirection,_tmpScrollDistance,_tmpScrollDistanceMeters,_tmpTimestamp,_tmpScreenPosition,_tmpViewClassName,_tmpSessionId);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<TimeBasedScrollStats>> getScrollStatsByTime(final long startTime,
      final long endTime, final boolean groupByHour) {
    final String _sql = "\n"
            + "        SELECT \n"
            + "            CASE \n"
            + "                WHEN ? = 1 THEN strftime('%Y-%m-%d %H:00', timestamp/1000, 'unixepoch', 'localtime')\n"
            + "                ELSE strftime('%Y-%m-%d', timestamp/1000, 'unixepoch', 'localtime')\n"
            + "            END as timeGroup,\n"
            + "            COUNT(*) as scrollCount,\n"
            + "            SUM(scrollDistanceMeters) as totalDistance,\n"
            + "            AVG(scrollDistance) as avgDistance\n"
            + "        FROM scroll_events \n"
            + "        WHERE timestamp >= ? AND timestamp <= ?\n"
            + "        GROUP BY timeGroup\n"
            + "        ORDER BY timeGroup\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"scroll_events"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        final int _tmp = groupByHour ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, startTime);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, endTime);
        final int _columnIndexOfTimeGroup = 0;
        final int _columnIndexOfScrollCount = 1;
        final int _columnIndexOfTotalDistance = 2;
        final int _columnIndexOfAvgDistance = 3;
        final List<TimeBasedScrollStats> _result = new ArrayList<TimeBasedScrollStats>();
        while (_stmt.step()) {
          final TimeBasedScrollStats _item;
          final String _tmpTimeGroup;
          if (_stmt.isNull(_columnIndexOfTimeGroup)) {
            _tmpTimeGroup = null;
          } else {
            _tmpTimeGroup = _stmt.getText(_columnIndexOfTimeGroup);
          }
          final int _tmpScrollCount;
          _tmpScrollCount = (int) (_stmt.getLong(_columnIndexOfScrollCount));
          final float _tmpTotalDistance;
          _tmpTotalDistance = (float) (_stmt.getDouble(_columnIndexOfTotalDistance));
          final float _tmpAvgDistance;
          _tmpAvgDistance = (float) (_stmt.getDouble(_columnIndexOfAvgDistance));
          _item = new TimeBasedScrollStats(_tmpTimeGroup,_tmpScrollCount,_tmpTotalDistance,_tmpAvgDistance);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<AppScrollStats>> getAppScrollStats(final long startTime, final long endTime,
      final int limit) {
    final String _sql = "\n"
            + "        SELECT packageName, appName, \n"
            + "               COUNT(*) as scrollCount,\n"
            + "               SUM(scrollDistanceMeters) as totalDistanceMeters,\n"
            + "               AVG(scrollDistance) as avgDistance\n"
            + "        FROM scroll_events \n"
            + "        WHERE timestamp >= ? AND timestamp <= ?\n"
            + "        GROUP BY packageName \n"
            + "        ORDER BY scrollCount DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"scroll_events"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, startTime);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, endTime);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, limit);
        final int _columnIndexOfPackageName = 0;
        final int _columnIndexOfAppName = 1;
        final int _columnIndexOfScrollCount = 2;
        final int _columnIndexOfTotalDistanceMeters = 3;
        final int _columnIndexOfAvgDistance = 4;
        final List<AppScrollStats> _result = new ArrayList<AppScrollStats>();
        while (_stmt.step()) {
          final AppScrollStats _item;
          final String _tmpPackageName;
          if (_stmt.isNull(_columnIndexOfPackageName)) {
            _tmpPackageName = null;
          } else {
            _tmpPackageName = _stmt.getText(_columnIndexOfPackageName);
          }
          final String _tmpAppName;
          if (_stmt.isNull(_columnIndexOfAppName)) {
            _tmpAppName = null;
          } else {
            _tmpAppName = _stmt.getText(_columnIndexOfAppName);
          }
          final int _tmpScrollCount;
          _tmpScrollCount = (int) (_stmt.getLong(_columnIndexOfScrollCount));
          final float _tmpTotalDistanceMeters;
          _tmpTotalDistanceMeters = (float) (_stmt.getDouble(_columnIndexOfTotalDistanceMeters));
          final float _tmpAvgDistance;
          _tmpAvgDistance = (float) (_stmt.getDouble(_columnIndexOfAvgDistance));
          _item = new AppScrollStats(_tmpPackageName,_tmpAppName,_tmpScrollCount,_tmpTotalDistanceMeters,_tmpAvgDistance);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getTotalScrollMetersForDate(final String date,
      final Continuation<? super Float> $completion) {
    final String _sql = "SELECT SUM(scrollDistanceMeters) FROM scroll_events WHERE DATE(timestamp/1000, 'unixepoch', 'localtime') = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, date);
        }
        final Float _result;
        if (_stmt.step()) {
          final Float _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (float) (_stmt.getDouble(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteOldEvents(final long cutoffTime,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM scroll_events WHERE timestamp < ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, cutoffTime);
        _stmt.step();
        return Unit.INSTANCE;
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
