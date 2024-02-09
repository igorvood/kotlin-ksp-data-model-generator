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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
}

ksp {
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