plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")

    id("org.springframework.boot") version "2.7.16"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("plugin.spring")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":dataModel"))
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.liquibase:liquibase-core")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.4.1")




    runtimeOnly("org.postgresql:postgresql")


    testImplementation("com.charleskorn.kaml:kaml:0.48.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":dataModelSealed"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.5")

    testImplementation("com.fasterxml.jackson.module:jackson-module-jsonSchema:2.13.5")


}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}