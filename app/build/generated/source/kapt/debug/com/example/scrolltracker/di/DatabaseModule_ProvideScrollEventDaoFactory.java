package com.example.scrolltracker.di;

import com.example.scrolltracker.data.dao.ScrollEventDao;
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
public final class DatabaseModule_ProvideScrollEventDaoFactory implements Factory<ScrollEventDao> {
  private final Provider<ScrollDatabase> databaseProvider;

  private DatabaseModule_ProvideScrollEventDaoFactory(Provider<ScrollDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ScrollEventDao get() {
    return provideScrollEventDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideScrollEventDaoFactory create(
      Provider<ScrollDatabase> databaseProvider) {
    return new DatabaseModule_ProvideScrollEventDaoFactory(databaseProvider);
  }

  public static ScrollEventDao provideScrollEventDao(ScrollDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideScrollEventDao(database));
  }
}
