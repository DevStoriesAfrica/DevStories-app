object BuildPlugins {
    val androidPluggin by lazy { "com.android.tools.build:gradle:7.0.4" }
    val kotlinGradlePluggin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10" }
    val navSafeArgsPluggin by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5" }
    val hiltAndroidGradlePluggin by lazy { "com.google.dagger:hilt-android-gradle-plugin:2.38.1" }
}

/**
 * To define dependencies
 */
object Deps {
    // android common libs
    val androidxCore by lazy { "androidx.core:core-ktx:1.7.0" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintlayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:1.0.0" }
    val playServices by lazy { "com.google.android.gms:play-services-auth:20.0.0" }

    // tests
    val junit by lazy { "junit:junit:4.+" }
    val extJUnit by lazy { "androidx.test.ext:junit:1.1.3" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }

    // jetpack navigation components
    val navFragmentKtx by lazy { "androidx.navigation:navigation-fragment-ktx:2.3.5" }
    val navUIKtx by lazy { "androidx.navigation:navigation-ui-ktx:2.3.5" }

    // Lifecycle
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0" }
    val lifecyleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0" }
    val lifecycleExtension by lazy { "androidx.lifecycle:lifecycle-extensions:2.2.0" }

    //Retrofit and Gson
     val retrofit by lazy { "com.squareup.retrofit2:retrofit:2.9.0" }
     val retrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:2.9.0" }

    //Dagger-Hilt
    val daggerHiltAndroid  by lazy { "com.google.dagger:hilt-android:2.38.1" }
    val kaptGoogleDaggerHiltCompiler by lazy { "com.google.dagger:hilt-compiler:2.38.1" }
    val hiltLifecycle by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03" }
    val kaptHiltCompiler by lazy { "androidx.hilt:hilt-compiler:1.0.0" }

     // KTX for viewModels()
     val activityKtx by lazy { "androidx.activity:activity-ktx:1.4.0" }
     val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:1.4.0" }

     // circle image
     val circleimageview by lazy { "de.hdodenhof:circleimageview:3.1.0" }

     // Glide
     val bumptechGlide by lazy { "com.github.bumptech.glide:glide:4.12.0" }
     val kaptBumptechGlideCompiler by lazy { "com.github.bumptech.glide:compiler:4.12.0" }

    // Coroutines
     val kotlinxCoroutinesCore  by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1" }
     val kotlixCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2" }

    // Scalable size unit
    val sdpAndroid by lazy { "com.intuit.sdp:sdp-android:1.0.6" }
    val sspAndroid by lazy { "com.intuit.ssp:ssp-android:1.0.6" }

    // OtpView
    val aabhasr1OtpView by lazy { "com.github.aabhasr1:OtpView:v1.1.2" }

    // Jetpack Datastore
    val datastorePref by lazy { "androidx.datastore:datastore-preferences:1.0.0" }
    val datastoreCore by lazy { "androidx.datastore:datastore-core:1.0.0" }
}

