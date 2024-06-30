plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.bazan.devquiz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bazan.devquiz"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.1"

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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs("src\\main\\res", "src\\main\\res\\layouts\\components",
                    "src\\main\\res",
                    "src\\main\\res\\layouts\\home", "src\\main\\res", "src\\main\\res\\layouts\\topic",
                    "src\\main\\res",
                    "src\\main\\res\\layouts\\schedule"
                )
            }
        }
    }
}

dependencies {
    val navVersion = "2.7.7"
    val roomVersion = "2.6.1"
    val lottieVersion = "3.5.0"
    val fragmentVersion = "1.8.0"
    val activityVersion = "1.9.0"
    val lifecycleVersion = "2.8.2"
    val daggerHiltVersion = "2.51.1"

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")

    //Room
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    //Lottie
    implementation ("com.airbnb.android:lottie:$lottieVersion")

    //Activity
    implementation("androidx.activity:activity-ktx:$activityVersion")

    //Fragment
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    //NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}