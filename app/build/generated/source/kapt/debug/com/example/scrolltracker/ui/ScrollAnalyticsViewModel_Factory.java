package com.example.scrolltracker.ui;

import com.example.scrolltracker.data.repo.ScrollRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ScrollAnalyticsViewModel_Factory implements Factory<ScrollAnalyticsViewModel> {
  private final Provider<ScrollRepository> repositoryProvider;

  private ScrollAnalyticsViewModel_Factory(Provider<ScrollRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ScrollAnalyticsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static ScrollAnalyticsViewModel_Factory create(
      Provider<ScrollRepository> repositoryProvider) {
    return new ScrollAnalyticsViewModel_Factory(repositoryProvider);
  }

  public static ScrollAnalyticsViewModel newInstance(ScrollRepository repository) {
    return new ScrollAnalyticsViewModel(repository);
  }
}
