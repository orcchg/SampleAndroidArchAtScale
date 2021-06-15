plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    api(project(":feature:stock_details:api"))

    implementation(project(":base"))
    implementation(project(":feature:stock_details:data:api"))

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
}
