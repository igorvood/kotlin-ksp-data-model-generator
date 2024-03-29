package ru.vood.processor.datamodel.abstraction

import com.google.devtools.ksp.processing.SymbolProcessorProvider
import ru.vood.processor.datamodel.util.readFile

abstract class AbstractKoraAppProcessorTest(
    val symbolProcessors: List<SymbolProcessorProvider>,
    val sourceList: List<String> = listOf(),
) : AbstractSymbolProcessorTest() {
//    override fun commonImports() = super.commonImports() + """
//        import ru.tinkoff.kora.application.graph.*;
//        import java.util.Optional;
//
//        """.trimIndent()


    protected fun compile()/*: ApplicationGraphDraw*/ {
        val sources = sourceList.map {
            this::class.java.readFile(it)
        }.toTypedArray()

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
