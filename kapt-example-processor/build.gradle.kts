import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kspVersion: String by project

plugins {
    kotlin("jvm") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")

//    implementation(kotlin("stdlib"))
    implementation(project(":kapt-example-core"))
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
//    implementation("com.google.devtools.ksp:symbol-processing-api:1.7.20-1.0.8")
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")

}



tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
