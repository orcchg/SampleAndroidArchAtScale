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
    api(project(":design"))
    api(project(":feature:stock_list:api"))

    implementation(project(":androidUtil"))
    implementation(project(":util"))

    kapt(libs.daggerCompiler)

    implementation(libs.constraintLayout)
    implementation(libs.coreKtx)
    implementation(libs.dagger)
    implementation(libs.glide)
    implementation(libs.material)
    implementation(libs.recyclerView)
    implementation(libs.rxBinding)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}