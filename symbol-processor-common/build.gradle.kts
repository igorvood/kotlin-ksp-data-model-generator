val kspVersion: String by project

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":core"))

    implementation(libs.symbol.processing.api)
    implementation(libs.kotlin.poet.ksp)
    implementation(libs.kotlinpoet)

}
repositories {
    mavenCentral()
}