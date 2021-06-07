plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    api(project(":feature:stock_list:api"))

    implementation(project(":base"))
    implementation(project(":feature:stock_list:data:api"))

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
}