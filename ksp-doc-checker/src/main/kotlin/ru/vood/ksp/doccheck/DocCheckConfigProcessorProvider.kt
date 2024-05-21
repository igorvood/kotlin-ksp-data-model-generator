package ru.vood.ksp.doccheck

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class DocCheckConfigProcessorProvider : SymbolProcessorProvider {


    private lateinit var dataModelConfigProcessor: DocCheckProcessor
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        dataModelConfigProcessor = DocCheckProcessor(environment)
        return dataModelConfigProcessor
    }

}