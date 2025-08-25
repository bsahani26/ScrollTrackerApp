package com.example.scrolltracker.data.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.scrolltracker.data.entity.AppUsageSession;
import java.lang.Class;
import java.lang.Long;
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
public final class AppUsageSessionDao_Impl implements AppUsageSessionDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<AppUsageSession> __insertAdapterOfAppUsageSession;

  private final EntityDeleteOrUpdateAdapter<AppUsageSession> __updateAdapterOfAppUsageSession;

  public AppUsageSessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfAppUsageSession = new EntityInsertAdapter<AppUsageSession>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `app_usage_sessions` (`id`,`packageName`,`appName`,`sessionStart`,`sessionEnd`,`totalTimeSpent`,`scrollCount`,`wakeUpCount`,`isActive`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final AppUsageSession entity) {
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
        statement.bindLong(4, entity.getSessionStart());
        if (entity.getSessionEnd() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getSessionEnd());
        }
        statement.bindLong(6, entity.getTotalTimeSpent());
        statement.bindLong(7, entity.getScrollCount());
        statement.bindLong(8, entity.getWakeUpCount());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(9, _tmp);
      }
    };
    this.__updateAdapterOfAppUsageSession = new EntityDeleteOrUpdateAdapter<AppUsageSession>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `app_usage_sessions` SET `id` = ?,`packageName` = ?,`appName` = ?,`sessionStart` = ?,`sessionEnd` = ?,`totalTimeSpent` = ?,`scrollCount` = ?,`wakeUpCount` = ?,`isActive` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final AppUsageSession entity) {
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
        statement.bindLong(4, entity.getSessionStart());
        if (entity.getSessionEnd() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getSessionEnd());
        }
        statement.bindLong(6, entity.getTotalTimeSpent());
        statement.bindLong(7, entity.getScrollCount());
        statement.bindLong(8, entity.getWakeUpCount());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getId());
      }
    };
  }

  @Override
  public Object insertSession(final AppUsageSession session,
      final Continuation<? super Unit> $completion) {
    if (session == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfAppUsageSession.insert(_connection, session);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object updateSession(final AppUsageSession session,
      final Continuation<? super Unit> $completion) {
    if (session == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfAppUsageSession.handle(_connection, session);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getActiveSessions(final Continuation<? super List<AppUsageSession>> $completion) {
    final String _sql = "SELECT * FROM app_usage_sessions WHERE isActive = 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfPackageName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "packageName");
        final int _columnIndexOfAppName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "appName");
        final int _columnIndexOfSessionStart = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sessionStart");
        final int _columnIndexOfSessionEnd = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sessionEnd");
        final int _columnIndexOfTotalTimeSpent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalTimeSpent");
        final int _columnIndexOfScrollCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scrollCount");
        final int _columnIndexOfWakeUpCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "wakeUpCount");
        final int _columnIndexOfIsActive = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isActive");
        final List<AppUsageSession> _result = new ArrayList<AppUsageSession>();
        while (_stmt.step()) {
          final AppUsageSession _item;
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
          final long _tmpSessionStart;
          _tmpSessionStart = _stmt.getLong(_columnIndexOfSessionStart);
          final Long _tmpSessionEnd;
          if (_stmt.isNull(_columnIndexOfSessionEnd)) {
            _tmpSessionEnd = null;
          } else {
            _tmpSessionEnd = _stmt.getLong(_columnIndexOfSessionEnd);
          }
          final long _tmpTotalTimeSpent;
          _tmpTotalTimeSpent = _stmt.getLong(_columnIndexOfTotalTimeSpent);
          final int _tmpScrollCount;
          _tmpScrollCount = (int) (_stmt.getLong(_columnIndexOfScrollCount));
          final int _tmpWakeUpCount;
          _tmpWakeUpCount = (int) (_stmt.getLong(_columnIndexOfWakeUpCount));
          final boolean _tmpIsActive;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsActive));
          _tmpIsActive = _tmp != 0;
          _item = new AppUsageSession(_tmpId,_tmpPackageName,_tmpAppName,_tmpSessionStart,_tmpSessionEnd,_tmpTotalTimeSpent,_tmpScrollCount,_tmpWakeUpCount,_tmpIsActive);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Flow<List<AppUsageStats>> getAppUsageStats(final long startTime, final long endTime) {
    final String _sql = "\n"
            + "        SELECT packageName, appName,\n"
            + "               SUM(totalTimeSpent) as totalTime,\n"
            + "               COUNT(*) as sessionCount,\n"
            + "               SUM(wakeUpCount) as totalWakeUps\n"
            + "        FROM app_usage_sessions \n"
            + "        WHERE sessionStart >= ? AND sessionStart <= ?\n"
            + "        GROUP BY packageName\n"
            + "        ORDER BY totalTime DESC\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"app_usage_sessions"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, startTime);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, endTime);
        final int _columnIndexOfPackageName = 0;
        final int _columnIndexOfAppName = 1;
        final int _columnIndexOfTotalTime = 2;
        final int _columnIndexOfSessionCount = 3;
        final int _columnIndexOfTotalWakeUps = 4;
        final List<AppUsageStats> _result = new ArrayList<AppUsageStats>();
        while (_stmt.step()) {
          final AppUsageStats _item;
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
          final long _tmpTotalTime;
          _tmpTotalTime = _stmt.getLong(_columnIndexOfTotalTime);
          final int _tmpSessionCount;
          _tmpSessionCount = (int) (_stmt.getLong(_columnIndexOfSessionCount));
          final int _tmpTotalWakeUps;
          _tmpTotalWakeUps = (int) (_stmt.getLong(_columnIndexOfTotalWakeUps));
          _item = new AppUsageStats(_tmpPackageName,_tmpAppName,_tmpTotalTime,_tmpSessionCount,_tmpTotalWakeUps);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<HourlyUsageStats>> getHourlyUsageStats(final long startTime,
      final long endTime) {
    final String _sql = "\n"
            + "        SELECT \n"
            + "            strftime('%Y-%m-%d %H:00', sessionStart/1000, 'unixepoch', 'localtime') as hour,\n"
            + "            SUM(totalTimeSpent) as totalTime,\n"
            + "            COUNT(*) as sessionCount\n"
            + "        FROM app_usage_sessions \n"
            + "        WHERE sessionStart >= ? AND sessionStart <= ?\n"
            + "        GROUP BY hour\n"
            + "        ORDER BY hour\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"app_usage_sessions"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, startTime);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, endTime);
        final int _columnIndexOfHour = 0;
        final int _columnIndexOfTotalTime = 1;
        final int _columnIndexOfSessionCount = 2;
        final List<HourlyUsageStats> _result = new ArrayList<HourlyUsageStats>();
        while (_stmt.step()) {
          final HourlyUsageStats _item;
          final String _tmpHour;
          if (_stmt.isNull(_columnIndexOfHour)) {
            _tmpHour = null;
          } else {
            _tmpHour = _stmt.getText(_columnIndexOfHour);
          }
          final long _tmpTotalTime;
          _tmpTotalTime = _stmt.getLong(_columnIndexOfTotalTime);
          final int _tmpSessionCount;
          _tmpSessionCount = (int) (_stmt.getLong(_columnIndexOfSessionCount));
          _item = new HourlyUsageStats(_tmpHour,_tmpTotalTime,_tmpSessionCount);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
