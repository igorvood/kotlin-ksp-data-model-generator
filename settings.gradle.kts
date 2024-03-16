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

//dependencyResolutionManagement {
//    versionCatalogs {
//        create("libs") {
//            version("jackson-serialization-version", "2.13.5")
//            version("kotlinx-serialization-version", "1.4.1")
//            val kotlinx_serialization_version = "1.4.1"
//            val jackson_serialization_version = "2.13.5"
//            val kspVersion: String by settings
//            //serialisation
//
//            library(
//                "kotlinx-serialization-json",
//                "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_serialization_version"
//            )
//            library(
//                "serialization-kotlinx-json",
//                "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0"
//            )
//            library(
//                "kotlinx-serialization-hocon",
//                "org.jetbrains.kotlinx:kotlinx-serialization-hocon:$kotlinx_serialization_version"
//            )
//
//            library(
//                "jackson-module-kotlin","com.fasterxml.jackson.module:jackson-module-kotlin:$jackson_serialization_version"
//            )
//            library(
//                "jackson-module-jsonSchema","com.fasterxml.jackson.module:jackson-module-jsonSchema:$jackson_serialization_version"
//            )
//
//            library("jackson-module-jsonSchema","com.fasterxml.jackson.module","jackson-module-jsonSchema").versionRef("jackson-serialization-version")
//
//
//            //reflection
//            library("org.reflections", "org.reflections:reflections:0.10.2")
//
//            library("symbol-processing-api","com.google.devtools.ksp:symbol-processing-api:$kspVersion")
//            library("symbol-processing-api","com.google.devtools.ksp:symbol-processing:$kspVersion")
//
//            val kotlinpoet_version = "1.12.0"
//            library("kotlinpoet","com.squareup:kotlinpoet:$kotlinpoet_version")
//            library("kotlin-poet-ksp","com.squareup:kotlinpoet-ksp:$kotlinpoet_version")
//
//        }
//    }
//}


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



