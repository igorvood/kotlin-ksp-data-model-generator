val kspVersion: String by project

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")


}
repositories {
    mavenCentral()
}