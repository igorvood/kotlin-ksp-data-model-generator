val kotlinxSerializationVersion: String by project
val orgReflections: String by project
val jacksonSerializationVersion: String by project


plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")

    id("org.springframework.boot")
    id("io.spring.dependency-management")
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

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:$kotlinxSerializationVersion")

    implementation("org.reflections:reflections:$orgReflections")
    runtimeOnly("org.postgresql:postgresql")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":dataModelSealed"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonSerializationVersion")
    testImplementation("com.fasterxml.jackson.module:jackson-module-jsonSchema:$jacksonSerializationVersion")


}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}