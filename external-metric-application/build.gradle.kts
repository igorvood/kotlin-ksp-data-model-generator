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
    implementation(project(":dataModelClear"))
    implementation(project(":grpc-common-client-server"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.liquibase:liquibase-core")
    implementation(libs.kotlinx.serialization.json)

    runtimeOnly("org.postgresql:postgresql")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.5")
//    testImplementation("com.fasterxml.jackson.module:jackson-module-jsonSchema:2.13.5")


}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}