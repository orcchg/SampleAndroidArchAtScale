plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:model"))

    api(libs.bundles.rx)
}