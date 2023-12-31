package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
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
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator

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

        logger.warn("root package ${rootPackage.value}")



        runBlocking {

            val listOf = listOf(
                async { EntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async { InterfaceGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async { ColumnEntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async { UniqueKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async { ForeignKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async { ContextDataClassesGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
                async {
                    SyntheticFieldExtractorsGenerator(codeGenerator, rootPackage, logger).createFiles(
                        metaInformation
                    )
                },
                async {
                    OriginEntityDataClassesGenerator(
                        codeGenerator,
                        rootPackage,
                        logger
                    ).createFiles(metaInformation)
                },
            )
            listOf

            val awaitAll = listOf.awaitAll()
            awaitAll
        }
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