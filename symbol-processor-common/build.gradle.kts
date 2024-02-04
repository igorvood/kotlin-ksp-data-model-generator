val kspVersion: String by project

plugins {
    kotlin("jvm")
//    kotlin("plugin.serialization")
}

dependencies {
//    implementation(project(":core"))
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
//    implementation("com.charleskorn.kaml:kaml:0.48.0")
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")


}
repositories {
    mavenCentral()
}