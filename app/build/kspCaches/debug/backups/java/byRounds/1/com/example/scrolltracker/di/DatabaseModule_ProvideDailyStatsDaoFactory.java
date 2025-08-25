package com.example.scrolltracker.di;

import com.example.scrolltracker.data.dao.DailyStatsDao;
import com.example.scrolltracker.data.db.ScrollDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideDailyStatsDaoFactory implements Factory<DailyStatsDao> {
  private final Provider<ScrollDatabase> databaseProvider;

  public DatabaseModule_ProvideDailyStatsDaoFactory(Provider<ScrollDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DailyStatsDao get() {
    return provideDailyStatsDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideDailyStatsDaoFactory create(
      Provider<ScrollDatabase> databaseProvider) {
    return new DatabaseModule_ProvideDailyStatsDaoFactory(databaseProvider);
  }

  public static DailyStatsDao provideDailyStatsDao(ScrollDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideDailyStatsDao(database));
  }
}
