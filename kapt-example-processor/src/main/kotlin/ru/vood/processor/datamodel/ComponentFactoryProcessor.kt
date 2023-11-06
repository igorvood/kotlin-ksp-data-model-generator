package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.validate
import ru.vood.dmgen.annotation.FlowEntity

class ComponentFactoryProcessor: SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val annotatedSymbols = resolver
            .getSymbolsWithAnnotation(FlowEntity::class.java.canonicalName)
            .groupBy { it.validate() }

        annotatedSymbols[false].orEmpty()



        return annotatedSymbols[false].orEmpty()
    }
}