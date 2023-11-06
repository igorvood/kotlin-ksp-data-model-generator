import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.7.20"
//    kotlin("kapt") version "1.7.20"
}

//kapt {
//    correctErrorTypes = true
//}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":kapt-example-core"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.7.20-1.0.8")
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")


//    implementation("com.google.auto.service:auto-service:1.0.1")
//    implementation ("com.squareup:kotlinpoet:0.5.0")
//    implementation ("com.squareup:kotlinpoet:1.14.2")
//    implementation("io.arrow-kt:arrow-core:1.2.1")

//    kapt("com.google.auto.service:auto-service:1.0.1")
}

repositories {
    mavenCentral()
    google()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
