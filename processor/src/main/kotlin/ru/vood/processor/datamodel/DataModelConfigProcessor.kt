package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.metaInformation
import ru.vood.processor.datamodel.gen.PackageName
import ru.vood.processor.datamodel.gen.meta.ColumnEntityMapGenerator
import ru.vood.processor.datamodel.gen.meta.EntityMapGenerator
import ru.vood.processor.datamodel.gen.meta.ForeignKeyMapGenerator
import ru.vood.processor.datamodel.gen.meta.UniqueKeyMapGenerator
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator
import ru.vood.processor.datamodel.gen.runtime.SyntheticFieldExtractorsGenerator

class DataModelConfigProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.warn("count entities ${symbols.size}")

        val metaInformation = metaInformation(symbols, logger)

        metaInformation.entities.values
            .forEach { metaEntity ->
                logger.warn("read MetaEntity ${metaEntity}", metaEntity.ksAnnotated)
            }


        val setMetaEnt = metaInformation.entities.values.toSet()
        val rootPackage = PackageName(commonPackage(setMetaEnt))

        logger.info("root package ${rootPackage.value}")

        EntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        ColumnEntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        UniqueKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        ForeignKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        ContextDataClassesGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        SyntheticFieldExtractorsGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        OriginEntityDataClassesGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        return symbols.toList()

    }

    fun commonPackage(setMetaEnt: Set<MetaEntity>): String {
        tailrec fun commonPackageRecurcive(currentPackage: String, packacges: List<String>): String {
            return when (packacges.isEmpty()) {
                true -> currentPackage
                false -> {
                    val nextPack = packacges[0]

                    var collector = ""

                    for (q in nextPack.withIndex()) {
                        if (currentPackage.getOrElse(q.index) { '~' } == q.value) {
                            collector = collector.plus(q.value)
                        } else {
                            break
                        }
                    }

                    commonPackageRecurcive(collector, packacges.drop(1))
                }
            }

        }

        val toList = setMetaEnt.toList().map { it.designClassPackageName }
        val value = toList[0]
        return commonPackageRecurcive(value, toList.drop(1))
    }
}