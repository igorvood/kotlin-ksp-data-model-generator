//плугшин с кодо генерацией https://habr.com/ru/companies/yota/articles/565440/
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



