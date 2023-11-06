import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    id("org.springframework.boot") version "2.7.16"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("kapt") version "1.7.20"
    kotlin("plugin.serialization") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
//    id("io.arrow-kt.analysis.kotlin") version "2.0.2"
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
}


kapt {
    correctErrorTypes = true
    showProcessorStats = true
    arguments {
        arg("key", "value")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":kapt-example-core"))
    implementation(project(":kapt-example-processor"))
    // https://mvnrepository.com/artifact/io.arrow-kt/arrow-analysis-kotlin-plugin
//    implementation("io.arrow-kt:arrow-analysis-kotlin-plugin:2.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("io.arrow-kt:arrow-core:1.2.0")

    kapt(project(":kapt-example-processor"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask>()
    .configureEach {
        kaptProcessJvmArgs.add("-Xmx512m")
    }

tasks.withType<Test> {
    useJUnitPlatform()
}
