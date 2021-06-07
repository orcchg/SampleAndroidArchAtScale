plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:di"))
    api(project(":core:model"))

    api(libs.bundles.rx)
}