package ru.vood.processor.datamodel.factory

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator

interface IFileGeneratorFactory {
    fun generators(
        metaInformation: MetaInformation,
        kspLogger: KSPLogger,
        environment: SymbolProcessorEnvironment,
    ): List<AbstractGenerator>
}