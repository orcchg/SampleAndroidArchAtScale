buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.androidGradlePlugin)
        classpath(libs.kotlinPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
