plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:di"))
    api(project(":core:network:api"))
    api(project(":core:schedulers:api"))

    api(libs.bundles.rx)

    implementation(libs.dagger)
}