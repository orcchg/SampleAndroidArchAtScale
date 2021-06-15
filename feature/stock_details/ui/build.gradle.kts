plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 30

    resourcePrefix = "stock_details"

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
    implementation(project(":design"))
    implementation(project(":feature:stock_details:api"))

    implementation(libs.constraintLayout)
    implementation(libs.dagger)
    implementation(libs.material)
}
