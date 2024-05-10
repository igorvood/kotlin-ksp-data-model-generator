import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.protobuf
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    jcenter()
    mavenCentral()
}

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
}

val protobufVersion: String by project
val ioGrpc: String by project
val genGrpcKotlin: String by project
val grpcVersion : String by project
val grpcKotlinVersion : String by project
val kotlinVersion : String by project
val kotlinxCoroutines : String by project

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
    implementation("io.grpc:protoc-gen-grpc-kotlin:$genGrpcKotlin")


    implementation("io.grpc:grpc-inprocess:$ioGrpc")
    implementation("io.grpc:grpc-netty-shaded:$ioGrpc")
    implementation("io.grpc:grpc-protobuf:$ioGrpc")
    implementation("io.grpc:grpc-services:$ioGrpc")
    implementation("io.grpc:grpc-core:$ioGrpc")

    protobuf(files("src/main/resources/proto/"))
}


protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:${protobufVersion}"
    }
    plugins {
        // Optional: an artifact spec for a protoc plugin, with "grpc" as
        // the identifier, which can be referred to in the "plugins"
        // container of the "generateProtoTasks" closure.
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
        id("grpckotlin") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${grpcKotlinVersion}:jdk8@jar"
        }

    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without
                // options. Note the braces cannot be omitted, otherwise the
                // plugin will not be added. This is because of the implicit way
                // NamedDomainObjectContainer binds the methods.
                id("grpc") { }
                id("grpckotlin") {}
            }
        }
    }
}

java {
    val mainJavaSourceSet: SourceDirectorySet = sourceSets.getByName("main").java
    mainJavaSourceSet.srcDirs(
        "src/main/kotlin",
        "build/generated/source/proto/main/grpc",
        "build/generated/source/proto/main/java",
        "build/generated/source/proto/main/kotlin",
        "build/generated/source/proto/main/grpckotlin"
    )
    println("java srcDirs -> " + mainJavaSourceSet.srcDirs)
}
kotlin {
    val mainJavaSourceSet: SourceDirectorySet = sourceSets.getByName("main").kotlin
    mainJavaSourceSet.srcDirs(
        "src/main/kotlin",
        "build/generated/source/proto/main/grpc",
        "build/generated/source/proto/main/java",
        "build/generated/source/proto/main/kotlin",
        "build/generated/source/proto/main/grpckotlin"
    )
    println("kotlin srcDirs -> " + mainJavaSourceSet.srcDirs)
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

