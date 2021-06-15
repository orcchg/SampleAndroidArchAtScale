plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.orcchg.sample.atscale.stockdetails.demo"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
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
}

dependencies {
    implementation(project(":androidUtil"))
    implementation(project(":core:ui"))
    implementation(project(":design"))
    implementation(project(":feature:stock_details:fake"))
    implementation(project(":feature:stock_details:ui"))
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
    implementation(libs.timber)
}
