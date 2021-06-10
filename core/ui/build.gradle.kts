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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:di"))

    implementation(libs.appCompat)
    implementation(libs.autoDispose)
    implementation(libs.autoDisposeAndroidAC)
    implementation(libs.bundles.rx)
    implementation(libs.dagger)
    implementation(libs.fragmentKtx)
    implementation(libs.liveData)
}