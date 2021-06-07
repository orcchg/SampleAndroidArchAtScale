plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:schedulers:api"))

    api(libs.bundles.rx)
}