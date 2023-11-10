plugins {
    id("com.google.devtools.ksp")
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.7.20"

    id("org.springframework.boot") version "2.7.16"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("plugin.spring") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":processor"))
    ksp(project(":processor"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
//    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

}

ksp {
    arg("PROD", "prod")
    arg("TEST", "test")
    arg("DEV", "dev")
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}