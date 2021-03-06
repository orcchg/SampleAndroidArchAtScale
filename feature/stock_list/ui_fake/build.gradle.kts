plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    resourcePrefix = "stock"

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
    api(project(":feature:stock_list:ui"))

    implementation(project(":util"))

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
    implementation(libs.material)
}