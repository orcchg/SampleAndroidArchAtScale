plugins {
    id("kotlin")
}

dependencies {
    api(project(":feature:stock_details:data:api"))

    implementation(libs.dagger)
}
