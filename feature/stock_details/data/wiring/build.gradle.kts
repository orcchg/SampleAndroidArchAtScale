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
    api(project(":feature:stock_details:data:api"))

    implementation(project(":core:network:api"))
    implementation(project(":core:schedulers:api"))
    implementation(project(":feature:stock_details:data:real")) // switch implementation of data layer

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
    implementation(libs.room)
}
