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
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.hocon)

    implementation(libs.org.reflections)

    runtimeOnly("org.postgresql:postgresql")


//    testImplementation("com.charleskorn.kaml:kaml:0.48.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":dataModelSealed"))
    testImplementation(libs.jackson.module.jsonSchema)
    testImplementation(libs.jackson.module.kotlin)

}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}