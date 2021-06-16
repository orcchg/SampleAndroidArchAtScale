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
    api(project(":feature:stock_list:data:api"))

    implementation(project(":core:model"))
    implementation(project(":util"))

    kapt(libs.daggerCompiler)
    kapt(libs.moshiKotlinCodegen)
    kapt(libs.roomCompiler)

    implementation(libs.dagger)
    implementation(libs.moshi)
    implementation(libs.retrofit)
    implementation(libs.room)
    implementation(libs.roomRx)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}