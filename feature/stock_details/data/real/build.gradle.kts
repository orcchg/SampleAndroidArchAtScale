plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    api(project(":feature:stock_details:data:api"))

    kapt(libs.moshiKotlinCodegen)

    implementation(libs.dagger)
    implementation(libs.moshiKotlin)
    implementation(libs.retrofit)
}
