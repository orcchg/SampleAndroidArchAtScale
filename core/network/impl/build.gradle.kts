plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
    api(project(":core:network:api"))

    implementation(project(":core:context:api"))

    kapt(libs.daggerCompiler)
    kapt(libs.moshiKotlinCodegen)

    implementation(libs.dagger)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)
    implementation(libs.okHttpLog)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.retrofitRx)
}