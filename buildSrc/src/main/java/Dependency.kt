object Dependency {

    const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.serializationConverter}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"

    object Material {
        const val material = "com.google.android.material:material:${Version.material}"
        const val composeAdapter = "com.google.android.material:compose-theme-adapter:${Version.compose}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val constraintCompose = "androidx.constraintlayout:constraintlayout-compose:${Version.composeIntgr}"

        object Activity {
            const val compose = "androidx.activity:activity-compose:${Version.activityCompose}"
        }

        object LifeCycle  {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifeCycle}"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifeCycle}"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Version.compose}"
            const val uiPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
            const val material = "androidx.compose.material:material:${Version.compose}"
            const val animation = "androidx.compose.animation:animation:${Version.compose}"

            const val jUnit4 = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:${Version.navigation}"
        }

        object Paging3 {
            const val compose = "androidx.paging:paging-compose:${Version.paging3}"
        }

        object Room {
            const val runtime = "androidx.room:room-runtime:${Version.room}"
            const val ktx = "androidx.room:room-ktx:${Version.room}"
            const val paging = "androidx.room:room-paging:${Version.room}"
            const val compiler = "androidx.room:room-compiler:${Version.room}"
        }

        object Test {
            const val extJUnit = "androidx.test.ext:junit:${Version.extJUnit}"

            object Espresso {
                const val core = "androidx.test.espresso:espresso-core:${Version.espresso}"
            }
        }
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Version.okHttp}"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val logging = "com.squareup.okhttp3:logging-interceptor"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Version.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
        const val compose = "androidx.hilt:hilt-navigation-compose:${Version.composeIntgr}"
    }

    object ExoPlayer {
        const val core = "com.google.android.exoplayer:exoplayer-core:${Version.exoplayer}"
        const val dash = "com.google.android.exoplayer:exoplayer-dash:${Version.exoplayer}"
        const val ui = "com.google.android.exoplayer:exoplayer-ui:${Version.exoplayer}"
        const val hsl = "com.google.android.exoplayer:exoplayer-hls:${Version.exoplayer}"
    }

    object JUnit {
        const val jUnit = "junit:junit:${Version.jUnit}"
    }
}
