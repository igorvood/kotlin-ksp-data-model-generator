package ru.vood.ksp.doccheck.example

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestEnvClass {
    @Test
    fun `test my annotation processor`() {
        val kotlinSource = SourceFile.kotlin(
            "KClass.kt", """
        class KClass {
            fun foo() {
                // Classes from the test environment are visible to the compiled sources
                val testEnvClass = "TestEnvClass()" 
            }
        }
    """
        )

        val javaSource = SourceFile.java(
            "JClass.java", """
        public class JClass {
            public void bar() {
                // compiled Kotlin classes are visible to Java sources
                KClass kClass = new KClass(); 
            }
	    }
    """
        )
        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource, javaSource)

            // pass your own instance of an annotation processor
//            annotationProcessors = listOf(MyAnnotationProcessor())

            // pass your own instance of a compiler plugin
//            compilerPlugins = listOf(MyComponentRegistrar())
//            commandLineProcessors = listOf(MyCommandlineProcessor())

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assertions.assertEquals(result.exitCode, KotlinCompilation.ExitCode.OK)

        // Test diagnostic output of compiler
//        Assertions.assertTrue(result.messages.contains("My annotation processor was called"))

        // Load compiled classes and inspect generated code through reflection
//        val kClazz = result.classLoader.loadClass("KClass")
//        assertThat(kClazz).hasDeclaredMethods("foo")
    }
}