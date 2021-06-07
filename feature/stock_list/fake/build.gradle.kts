plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    api(project(":feature:stock_list:api"))

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
}