package ru.vood.processor.json

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

class JsonSchemeConfigProcessor(codeGenerator: CodeGenerator, logger: KSPLogger) : SymbolProcessor  {
    override fun process(resolver: Resolver): List<KSAnnotated> {

        return emptyList()
    }
}