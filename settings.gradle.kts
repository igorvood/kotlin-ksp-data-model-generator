pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings

    plugins {
        id("com.google.devtools.ksp") version kspVersion
        kotlin("jvm") version kotlinVersion
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":kapt-example-app")
include(":kapt-example-core")
include(":kapt-example-processor")
