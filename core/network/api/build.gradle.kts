plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:di"))

    api(libs.retrofit)
}