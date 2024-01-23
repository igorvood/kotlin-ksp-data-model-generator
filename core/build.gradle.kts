import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.1")
}

repositories {
    jcenter()
    mavenCentral()
}
