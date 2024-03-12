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

val googleProtobufVersion = "3.19.3"
dependencies {
    implementation(project(":core"))
    implementation(project(":dataModelClear"))
    implementation(project(":grpc-common-client-server"))
//    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation(libs.kotlinx.serialization.json)

    implementation("com.google.protobuf:protobuf-kotlin:$googleProtobufVersion")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
    implementation("io.grpc:protoc-gen-grpc-kotlin:1.3.0")


//    io.grpc:grpc-api:1.58.0 (*)
//    implementation("io.grpc:grpc-stub:1.58.0 (*)
    implementation("io.grpc:grpc-inprocess:1.58.0")
    implementation("io.grpc:grpc-netty-shaded:1.58.0")
    implementation("io.grpc:grpc-protobuf:1.58.0")
    implementation("io.grpc:grpc-services:1.58.0")
    implementation("io.grpc:grpc-core:1.58.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
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