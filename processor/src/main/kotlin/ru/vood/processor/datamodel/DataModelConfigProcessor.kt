package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

class DataModelConfigProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val symbols = resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.info("count entities ${symbols.size}")
        symbols
            .filterIsInstance<KSClassDeclaration>()
            .map {MetaEntity(it, logger)  }
            .forEach { metaEntity ->


                logger.info("read MetaEntity ${metaEntity}", metaEntity.ksAnnotated)


            }





        return symbols.toList()

    }
}