package ru.vood.processor.datamodel.abstraction

import org.intellij.lang.annotations.Language
import ru.vood.processor.datamodel.DataModelConfigProcessorProvider
import java.util.function.Supplier

abstract class AbstractKoraAppProcessorTest : AbstractSymbolProcessorTest() {
    override fun commonImports() = super.commonImports() + """
        import ru.tinkoff.kora.application.graph.*;
        import java.util.Optional;
        
        """.trimIndent()


    protected fun compile(@Language("kotlin") vararg sources: String)/*: ApplicationGraphDraw*/ {
        val compileResult = compile(listOf(DataModelConfigProcessorProvider()), *sources)
        if (compileResult.isFailed()) {
            throw compileResult.compilationException()
        }

//        val appClass = compileResult.loadClass("ExampleApplicationGraph")
//        val `object` = appClass.getConstructor().newInstance() as Supplier<ApplicationGraphDraw>
//        return `object`.get()
    }

}
