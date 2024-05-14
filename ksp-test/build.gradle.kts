import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


val kspVersion: String by project
val kotlinxSerializationVersion: String by project
val kotlinpoet: String by project
val kotlinVersion: String by project
val kotlinxCoroutines: String by project
val ioMockk: String by project
val junitJupiter: String by project
val kotlinCompileTesting: String by project


plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":symbol-processor-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("com.google.devtools.ksp:symbol-processing:$kspVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
//    implementation("com.charleskorn.kaml:kaml:0.52.0")
    implementation("com.squareup:kotlinpoet:$kotlinpoet")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinpoet")
    implementation("org.junit.jupiter:junit-jupiter:$junitJupiter")
    testImplementation("io.mockk:mockk:$ioMockk")
    implementation("com.github.tschuchortdev:kotlin-compile-testing:$kotlinCompileTesting")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")
//    testImplementation()

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

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
    sourceSets.test {
        kotlin.srcDir("src/test/kotlin")
    }
}



//sourceSets {
//    test {
//        kotlin {
//            srcDirs("test/kotlin")
//        }
//    }
//}