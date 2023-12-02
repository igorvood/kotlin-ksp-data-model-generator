import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-metadata-jvm
    implementation("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.6.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
//    compile 'org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.0.3'
//    implementation("com.sun.java:tools:11.0.1")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
}

repositories {
    jcenter()
    mavenCentral()
}
