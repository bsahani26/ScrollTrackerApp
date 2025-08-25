package com.example.scrolltracker.di;

import com.example.scrolltracker.data.dao.AppUsageSessionDao;
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
public final class DatabaseModule_ProvideAppUsageSessionDaoFactory implements Factory<AppUsageSessionDao> {
  private final Provider<ScrollDatabase> databaseProvider;

  private DatabaseModule_ProvideAppUsageSessionDaoFactory(
      Provider<ScrollDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AppUsageSessionDao get() {
    return provideAppUsageSessionDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideAppUsageSessionDaoFactory create(
      Provider<ScrollDatabase> databaseProvider) {
    return new DatabaseModule_ProvideAppUsageSessionDaoFactory(databaseProvider);
  }

  public static AppUsageSessionDao provideAppUsageSessionDao(ScrollDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAppUsageSessionDao(database));
  }
}
