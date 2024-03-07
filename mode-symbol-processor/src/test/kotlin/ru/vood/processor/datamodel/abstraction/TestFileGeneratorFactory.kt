package ru.vood.processor.datamodel.abstraction

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.factory.IFileGeneratorFactory
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator

class TestFileGeneratorFactory : IFileGeneratorFactory {
    override fun generators(
        metaInformation: MetaInformation,
        kspLogger: KSPLogger,
        environment: SymbolProcessorEnvironment,
    ): List<AbstractGenerator> {
        return listOf()
    }
}