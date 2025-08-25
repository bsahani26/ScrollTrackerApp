package com.example.scrolltracker.di;

import android.content.Context;
import com.example.scrolltracker.data.db.ScrollDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideScrollDatabaseFactory implements Factory<ScrollDatabase> {
  private final Provider<Context> contextProvider;

  private DatabaseModule_ProvideScrollDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ScrollDatabase get() {
    return provideScrollDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideScrollDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideScrollDatabaseFactory(contextProvider);
  }

  public static ScrollDatabase provideScrollDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideScrollDatabase(context));
  }
}
