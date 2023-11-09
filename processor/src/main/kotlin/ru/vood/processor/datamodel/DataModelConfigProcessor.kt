package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.processor.datamodel.abstraction.model.metaInformation

class DataModelConfigProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val symbols: List<KSAnnotated> = resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.info("count entities ${symbols.size}")


        val metaInformation = metaInformation(symbols, logger)




        metaInformation.entities.values
            .forEach { metaEntity ->
                logger.info("read MetaEntity ${metaEntity}", metaEntity.ksAnnotated)
            }
        return symbols.toList()

    }
}