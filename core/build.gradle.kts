import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxSerializationVersion: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")

}

repositories {
    jcenter()
    mavenCentral()
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
