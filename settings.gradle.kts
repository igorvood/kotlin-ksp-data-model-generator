// как настраивать версии в грейдл для мульти модульных проектов https://docs.gradle.org/current/userguide/platforms.html

//плугин с кодо генерацией https://habr.com/ru/companies/yota/articles/565440/
//Kotlin Symbol Processing. От теории до практики https://habr.com/ru/companies/cian/articles/705278/
// пример генератора от тинькова https://github.com/Tinkoff/kora?ysclid=ltojwtlwp7423328427
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
        id("org.springframework.boot") version "2.7.16"
        id("io.spring.dependency-management") version "1.0.15.RELEASE"
    }

    repositories {
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            //serialisation
            version("kotlinx-serialization", "1.4.1")
            library("kotlinx-serialization-json","org.jetbrains.kotlinx","kotlinx-serialization-json").versionRef("kotlinx-serialization")
            library(
                "kotlinx-serialization-hocon",
                "org.jetbrains.kotlinx",
                "kotlinx-serialization-hocon"
            ).versionRef("kotlinx-serialization")

            //reflection
            library("org.reflections", "org.reflections:reflections:0.10.2")


        }
    }
}


include(":core")
include(":symbol-processor-common")
include(":mode-symbol-processor")


include(":dataModelSealed")
include(":dataModel")


include(":workload")


include(":dataModelClear")
include(":grpc-common-client-server")
include(":externalSystems")
include(":external-metric-application")


//include(":functionGeneratorPlugin")



