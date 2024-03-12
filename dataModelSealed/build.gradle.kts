plugins {
    id("com.google.devtools.ksp")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":mode-symbol-processor"))
    ksp(project(":mode-symbol-processor"))
    implementation(libs.kotlinx.serialization.json)
}

ksp {
    arg("PROD", "prod")
    arg("TEST", "test")
    arg("DEV", "dev")
    arg("nullableProbSetDefaultNull", "true")
}

kotlin {
    sourceSets.main {
        kotlin.srcDirs(
            "src/main/kotlin",
            "build/generated/ksp/main/kotlin"
        )
    }
}