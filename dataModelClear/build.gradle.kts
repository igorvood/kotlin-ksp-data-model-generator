import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxSerializationVersion: String by project

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
    implementation(project(":mode-symbol-processor"))
    ksp(project(":mode-symbol-processor"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
}

ksp {
    arg("nullableProbSetDefaultNull", "true")
}

kotlin {
    sourceSets.main {
        kotlin.srcDirs(
            "src/main/kotlin",
            "build/generated/ksp/main/kotlin"
        )
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val javaVersion: String by project
tasks.withType<KotlinCompile>{
    kotlinOptions{
        jvmTarget = javaVersion
    }
}
