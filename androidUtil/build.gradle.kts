plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 23
        targetSdk = 30
    }
    buildFeatures {
        viewBinding = true
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
    implementation(libs.appCompat)
    implementation(libs.bundles.rx)
    implementation(libs.fragmentKtx)
    implementation(libs.lifecycle)
    implementation(libs.liveData)
    implementation(libs.navigation)
    implementation(libs.rxAndroid)
}