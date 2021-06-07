plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:di"))

    api(libs.bundles.rx)
}