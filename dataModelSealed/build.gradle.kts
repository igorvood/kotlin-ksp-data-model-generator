import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    id("com.google.devtools.ksp")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":processor"))
    ksp(project(":processor"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
}

ksp {
    arg("PROD", "prod")
    arg("TEST", "test")
    arg("DEV", "dev")
}

kotlin {
    sourceSets.main {
        kotlin.srcDirs(
            "src/main/kotlin",
            "build/generated/ksp/main/kotlin")
    }
}