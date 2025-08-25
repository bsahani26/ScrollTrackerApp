package com.example.scrolltracker.ui;

import com.example.scrolltracker.AppUsageTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class ScrollMainActivity_MembersInjector implements MembersInjector<ScrollMainActivity> {
  private final Provider<AppUsageTracker> appUsageTrackerProvider;

  public ScrollMainActivity_MembersInjector(Provider<AppUsageTracker> appUsageTrackerProvider) {
    this.appUsageTrackerProvider = appUsageTrackerProvider;
  }

  public static MembersInjector<ScrollMainActivity> create(
      Provider<AppUsageTracker> appUsageTrackerProvider) {
    return new ScrollMainActivity_MembersInjector(appUsageTrackerProvider);
  }

  @Override
  public void injectMembers(ScrollMainActivity instance) {
    injectAppUsageTracker(instance, appUsageTrackerProvider.get());
  }

  @InjectedFieldSignature("com.example.scrolltracker.ui.ScrollMainActivity.appUsageTracker")
  public static void injectAppUsageTracker(ScrollMainActivity instance,
      AppUsageTracker appUsageTracker) {
    instance.appUsageTracker = appUsageTracker;
  }
}
