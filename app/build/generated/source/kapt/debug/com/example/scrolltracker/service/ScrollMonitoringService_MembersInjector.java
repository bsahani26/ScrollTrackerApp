package com.example.scrolltracker.service;

import android.content.pm.PackageManager;
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

  private final Provider<PackageManager> packageManagerProvider;

  private ScrollMonitoringService_MembersInjector(Provider<ScrollRepository> repositoryProvider,
      Provider<PackageManager> packageManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.packageManagerProvider = packageManagerProvider;
  }

  public static MembersInjector<ScrollMonitoringService> create(
      Provider<ScrollRepository> repositoryProvider,
      Provider<PackageManager> packageManagerProvider) {
    return new ScrollMonitoringService_MembersInjector(repositoryProvider, packageManagerProvider);
  }

  @Override
  public void injectMembers(ScrollMonitoringService instance) {
    injectRepository(instance, repositoryProvider.get());
    injectPackageManager(instance, packageManagerProvider.get());
  }

  @InjectedFieldSignature("com.example.scrolltracker.service.ScrollMonitoringService.repository")
  public static void injectRepository(ScrollMonitoringService instance,
      ScrollRepository repository) {
    instance.repository = repository;
  }

  @InjectedFieldSignature("com.example.scrolltracker.service.ScrollMonitoringService.packageManager")
  public static void injectPackageManager(ScrollMonitoringService instance,
      PackageManager packageManager) {
    instance.packageManager = packageManager;
  }
}
