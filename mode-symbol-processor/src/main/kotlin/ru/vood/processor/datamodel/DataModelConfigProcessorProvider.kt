package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import ru.vood.processor.datamodel.factory.FileGeneratorFactory
import ru.vood.processor.datamodel.factory.IFileGeneratorFactory

class DataModelConfigProcessorProvider(
    private val fileGeneratorFactory: IFileGeneratorFactory = FileGeneratorFactory()
) : SymbolProcessorProvider {

    internal lateinit var dataModelConfigProcessor : DataModelConfigProcessor
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        dataModelConfigProcessor = DataModelConfigProcessor(environment, fileGeneratorFactory)
        return dataModelConfigProcessor
    }
}