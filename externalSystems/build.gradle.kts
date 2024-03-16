val kotlinxSerializationVersion: String by project

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

val googleProtobufVersion: String by project
val genGrpcKotlin: String by project
val grpcKotlinVersion: String by project

dependencies {
    implementation(project(":core"))
    implementation(project(":dataModelClear"))
    implementation(project(":grpc-common-client-server"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")

    implementation("com.google.protobuf:protobuf-kotlin:$googleProtobufVersion")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}