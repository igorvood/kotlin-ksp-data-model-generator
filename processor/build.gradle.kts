val kspVersion: String by project

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
}