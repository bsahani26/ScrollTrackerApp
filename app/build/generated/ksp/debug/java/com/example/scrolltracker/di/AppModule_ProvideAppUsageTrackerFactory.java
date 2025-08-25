package com.example.scrolltracker.di;

import android.content.Context;
import com.example.scrolltracker.AppUsageTracker;
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
public final class AppModule_ProvideAppUsageTrackerFactory implements Factory<AppUsageTracker> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideAppUsageTrackerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AppUsageTracker get() {
    return provideAppUsageTracker(contextProvider.get());
  }

  public static AppModule_ProvideAppUsageTrackerFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideAppUsageTrackerFactory(contextProvider);
  }

  public static AppUsageTracker provideAppUsageTracker(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppUsageTracker(context));
  }
}
