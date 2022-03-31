plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.edwardjdp.devdaily"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
        kotlinCompilerVersion = "1.5.21"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":common"))

    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appCompat)
    implementation(Dependency.Material.material)
    implementation(Dependency.AndroidX.LifeCycle.runtime)
    implementation(Dependency.AndroidX.Activity.compose)

    implementation(Dependency.AndroidX.Compose.ui)
    implementation(Dependency.AndroidX.Compose.material)
    implementation(Dependency.AndroidX.Compose.uiPreview)
    implementation(Dependency.AndroidX.Compose.animation)
    implementation(Dependency.Material.composeAdapter)
    implementation(Dependency.AndroidX.LifeCycle.viewModelCompose)
    implementation(Dependency.AndroidX.constraintCompose)

    // Coroutines
    implementation(Dependency.Coroutines.core)
    implementation(Dependency.Coroutines.android)

    // Serialization
    implementation(Dependency.serialization)

    // Retrofit
    implementation(Dependency.Retrofit.retrofit)
    implementation(Dependency.Retrofit.gsonConverter)
    implementation(Dependency.serializationConverter)

    // OkHttp
    implementation(platform(Dependency.OkHttp.bom))
    implementation(Dependency.OkHttp.okHttp)
    implementation(Dependency.OkHttp.logging)

    // Hilt
    implementation(Dependency.DaggerHilt.android)
    implementation(Dependency.DaggerHilt.compose)
    kapt(Dependency.DaggerHilt.hiltCompiler)
    kapt(Dependency.DaggerHilt.androidCompiler)

    // Navigation
    implementation(Dependency.AndroidX.Navigation.compose)

    // ExoPlayer
    implementation(Dependency.ExoPlayer.core)
    implementation(Dependency.ExoPlayer.dash)
    implementation(Dependency.ExoPlayer.ui)
    implementation(Dependency.ExoPlayer.hsl)

    // Room
    implementation(Dependency.AndroidX.Room.runtime)
    implementation(Dependency.AndroidX.Room.ktx)
    implementation(Dependency.AndroidX.Room.paging)
    kapt(Dependency.AndroidX.Room.compiler)

    // Paging 3
    implementation(Dependency.AndroidX.Paging3.compose)

    // RichText
    implementation(Dependency.RichText.common)
    implementation(Dependency.RichText.ui)

    testImplementation(Dependency.JUnit.jUnit)
    androidTestImplementation(Dependency.AndroidX.Test.extJUnit)
    androidTestImplementation(Dependency.AndroidX.Test.Espresso.core)
    androidTestImplementation(Dependency.AndroidX.Compose.jUnit4)
    debugImplementation(Dependency.AndroidX.Compose.uiTooling)
}
