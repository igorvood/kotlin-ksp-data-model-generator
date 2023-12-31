pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    val kotlinSerialization: String by settings
    val kotlinSpring: String by settings

    plugins {
        id("com.google.devtools.ksp") version kspVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinSerialization
        kotlin("plugin.spring") version kotlinSpring
    }

    repositories {
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":processor")
include(":core")
include(":dataModelSealed")

include(":workload")
include(":dataModel")

