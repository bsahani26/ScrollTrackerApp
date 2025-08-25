package com.example.scrolltracker.di;

import android.content.Context;
import android.hardware.display.DisplayManager;
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
public final class AppModule_ProvideDisplayManagerFactory implements Factory<DisplayManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideDisplayManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DisplayManager get() {
    return provideDisplayManager(contextProvider.get());
  }

  public static AppModule_ProvideDisplayManagerFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideDisplayManagerFactory(contextProvider);
  }

  public static DisplayManager provideDisplayManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDisplayManager(context));
  }
}
