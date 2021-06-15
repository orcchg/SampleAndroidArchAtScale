plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    resourcePrefix = "stock_details"
    
    defaultConfig {
        minSdk = 23
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
    implementation(project(":app")) // dynamic feature base module
    implementation(project(":core:ui"))
    implementation(project(":feature:stock_details:impl"))
    implementation(project(":feature:stock_details:ui"))
    implementation(project(":feature:stock_list:api")) // for models and interactor
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
    implementation(libs.navigation)
    implementation(libs.recyclerView)
    implementation(libs.rxBinding)
    implementation(libs.timber)
}
