package ru.vood.processor.datamodel.abstraction

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import org.intellij.lang.annotations.Language
import ru.vood.processor.datamodel.DataModelConfigProcessorProvider
import java.util.function.Supplier

abstract class AbstractKoraAppProcessorTest(
    val symbolProcessors: List<SymbolProcessorProvider>
    ) : AbstractSymbolProcessorTest() {
//    override fun commonImports() = super.commonImports() + """
//        import ru.tinkoff.kora.application.graph.*;
//        import java.util.Optional;
//
//        """.trimIndent()


    protected fun compile(@Language("kotlin") vararg sources: String)/*: ApplicationGraphDraw*/ {
        val compileResult = compile(symbolProcessors, *sources)
        if (compileResult.isFailed()) {
            throw compileResult.compilationException()
        }

//        val appClass = compileResult.loadClass("ExampleApplicationGraph")
//        val `object` = appClass.getConstructor().newInstance() as Supplier<ApplicationGraphDraw>
//        return `object`.get()

        println(1)
    }

}
