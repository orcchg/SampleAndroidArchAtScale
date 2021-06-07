plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.orcchg.sample.atscale.app"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

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

    dynamicFeatures.add(":feature:stock_details:stock_details_main")
}

dependencies {
    implementation(project(":core:context:impl"))
    implementation(project(":core:schedulers:impl"))
    implementation(project(":feature:stock_list:data:api"))
    implementation(project(":feature:stock_list:data:wiring"))

    kapt(libs.daggerCompiler)

    implementation(libs.appCompat)
    implementation(libs.coreKtx)
    implementation(libs.dagger)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitAndroidExt)
    androidTestImplementation(libs.espresso)
}