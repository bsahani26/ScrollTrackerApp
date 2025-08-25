package com.example.scrolltracker.service;

import android.hardware.display.DisplayManager;
import com.example.scrolltracker.AppUsageTracker;
import com.example.scrolltracker.data.repo.ScrollRepository;
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
public final class ScrollMonitoringService_MembersInjector implements MembersInjector<ScrollMonitoringService> {
  private final Provider<ScrollRepository> repositoryProvider;

  private final Provider<DisplayManager> displayManagerProvider;

  private final Provider<AppUsageTracker> appUsageTrackerProvider;

  public ScrollMonitoringService_MembersInjector(Provider<ScrollRepository> repositoryProvider,
      Provider<DisplayManager> displayManagerProvider,
      Provider<AppUsageTracker> appUsageTrackerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.displayManagerProvider = displayManagerProvider;
    this.appUsageTrackerProvider = appUsageTrackerProvider;
  }

  public static MembersInjector<ScrollMonitoringService> create(
      Provider<ScrollRepository> repositoryProvider,
      Provider<DisplayManager> displayManagerProvider,
      Provider<AppUsageTracker> appUsageTrackerProvider) {
    return new ScrollMonitoringService_MembersInjector(repositoryProvider, displayManagerProvider, appUsageTrackerProvider);
  }

  @Override
  public void injectMembers(ScrollMonitoringService instance) {
    injectRepository(instance, repositoryProvider.get());
    injectDisplayManager(instance, displayManagerProvider.get());
    injectAppUsageTracker(instance, appUsageTrackerProvider.get());
  }

  @InjectedFieldSignature("com.example.scrolltracker.service.ScrollMonitoringService.repository")
  public static void injectRepository(ScrollMonitoringService instance,
      ScrollRepository repository) {
    instance.repository = repository;
  }

  @InjectedFieldSignature("com.example.scrolltracker.service.ScrollMonitoringService.displayManager")
  public static void injectDisplayManager(ScrollMonitoringService instance,
      DisplayManager displayManager) {
    instance.displayManager = displayManager;
  }

  @InjectedFieldSignature("com.example.scrolltracker.service.ScrollMonitoringService.appUsageTracker")
  public static void injectAppUsageTracker(ScrollMonitoringService instance,
      AppUsageTracker appUsageTracker) {
    instance.appUsageTracker = appUsageTracker;
  }
}
