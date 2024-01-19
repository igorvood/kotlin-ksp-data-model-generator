plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}


gradlePlugin {
    plugins {
        create("functionGeneratorPlugin"){
            id = "codes.metadata.function.generate"
            implementationClass ="ru.vood.codes.metadata.function.generate.FunctionGeneratePlugin"
        }
    }
}

dependencies{

}
//val kspVersion: String by project
//
//plugins {
//    kotlin("jvm")
//}
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    implementation(project(":core"))
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
//}