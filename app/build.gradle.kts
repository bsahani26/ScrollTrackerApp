import org.gradle.kotlin.dsl.implementation

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") // Use KSP instead of kapt
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.compose") // Apply the new plugin
}

android {
    namespace = "com.example.scrolltracker"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.scrolltracker"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = "2.0.0"
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Compose BOM
    implementation(platform("androidx.compose:compose-bom:2025.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    // Activity Compose
    implementation("androidx.activity:activity-compose:1.10.1")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.9.3")

    // ViewModel Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.56.2")
    ksp("com.google.dagger:hilt-compiler:2.56.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    ksp("androidx.hilt:hilt-compiler:1.2.0")

    // Room
    implementation("androidx.room:room-runtime:2.7.2")
    implementation("androidx.room:room-ktx:2.7.2")
    ksp("androidx.room:room-compiler:2.7.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2") // Latest on Maven Central is not 1.10.2, use 1.12.0

    // Charts
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0") // Latest release from 2019, check for compatibility

    // Date/Time
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.1")

    // Gson for JSON
    implementation("com.google.code.gson:gson:2.13.1")

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.10.3")
    implementation("androidx.hilt:hilt-work:1.2.0")

    // Accompanist
    implementation("com.google.accompanist:accompanist-permissions:0.37.3")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    // Paging
    implementation("androidx.paging:paging-compose:3.3.6")
}