package com.example.scrolltracker.data.repo;

import com.example.scrolltracker.data.dao.AppUsageSessionDao;
import com.example.scrolltracker.data.dao.DailyStatsDao;
import com.example.scrolltracker.data.dao.ScrollEventDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ScrollRepository_Factory implements Factory<ScrollRepository> {
  private final Provider<ScrollEventDao> scrollEventDaoProvider;

  private final Provider<AppUsageSessionDao> appUsageSessionDaoProvider;

  private final Provider<DailyStatsDao> dailyStatsDaoProvider;

  private ScrollRepository_Factory(Provider<ScrollEventDao> scrollEventDaoProvider,
      Provider<AppUsageSessionDao> appUsageSessionDaoProvider,
      Provider<DailyStatsDao> dailyStatsDaoProvider) {
    this.scrollEventDaoProvider = scrollEventDaoProvider;
    this.appUsageSessionDaoProvider = appUsageSessionDaoProvider;
    this.dailyStatsDaoProvider = dailyStatsDaoProvider;
  }

  @Override
  public ScrollRepository get() {
    return newInstance(scrollEventDaoProvider.get(), appUsageSessionDaoProvider.get(), dailyStatsDaoProvider.get());
  }

  public static ScrollRepository_Factory create(Provider<ScrollEventDao> scrollEventDaoProvider,
      Provider<AppUsageSessionDao> appUsageSessionDaoProvider,
      Provider<DailyStatsDao> dailyStatsDaoProvider) {
    return new ScrollRepository_Factory(scrollEventDaoProvider, appUsageSessionDaoProvider, dailyStatsDaoProvider);
  }

  public static ScrollRepository newInstance(ScrollEventDao scrollEventDao,
      AppUsageSessionDao appUsageSessionDao, DailyStatsDao dailyStatsDao) {
    return new ScrollRepository(scrollEventDao, appUsageSessionDao, dailyStatsDao);
  }
}
