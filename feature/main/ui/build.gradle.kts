plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30
    resourcePrefix = "main"

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
    implementation(project(":androidUtil"))
    implementation(project(":core:ui"))
    implementation(project(":design"))
    implementation(project(":feature:stock_list:impl"))
    implementation(project(":feature:stock_list:ui"))
    implementation(project(":navigation"))
    implementation(project(":util"))

    kapt(libs.daggerCompiler)

    implementation(libs.appCompat)
    implementation(libs.autoDispose)
    implementation(libs.autoDisposeAndroidAC)
    implementation(libs.bundles.rx)
    implementation(libs.constraintLayout)
    implementation(libs.coreKtx)
    implementation(libs.dagger)
    implementation(libs.fragmentKtx)
    implementation(libs.material)
    implementation(libs.recyclerView)
    implementation(libs.rxBinding)
    implementation(libs.timber)
}
