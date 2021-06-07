plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

dependencies {
    api(project(":core:schedulers:api"))

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
    implementation(libs.rxAndroid)
}