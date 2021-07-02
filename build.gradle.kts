buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // TODO(m.alov): issuee https://github.com/gradle/gradle/issues/15383
        // TODO(m.alov): issue https://github.com/gradle/gradle/issues/16958
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath(libs.androidGradlePlugin)
        classpath(libs.kotlinPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
