plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    api(project(":feature:stock_list:api"))

    implementation(project(":base"))
}