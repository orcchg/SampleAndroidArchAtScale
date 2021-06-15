plugins {
    id("kotlin")
    id("kotlin-kapt")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":feature:stock_details:data:api"))

    implementation(project(":core:network:api"))
    implementation(project(":core:schedulers:api"))
    implementation(project(":feature:stock_details:data:real")) // switch implementation of data layer

    kapt(libs.daggerCompiler)

    implementation(libs.dagger)
    implementation(libs.room)
}
