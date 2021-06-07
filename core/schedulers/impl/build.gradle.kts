plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    api(project(":core:schedulers:api"))

    implementation(libs.rxAndroid)
}