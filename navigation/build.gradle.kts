plugins {
    id("com.android.library")
    id("kotlin-android")
//    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 23
        targetSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(libs.navigation)
    api(libs.navigationDynamicFeatures)
    api(libs.navigationUi)

    implementation(libs.appCompat)
}