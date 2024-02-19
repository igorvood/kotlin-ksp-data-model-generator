package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.metaInformation
import ru.vood.processor.datamodel.gen.appendText

class DataModelConfigProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val (symbols: List<KSAnnotated>, metaInformation, rootPackage) = triple(resolver)

        logger.warn("root package ${rootPackage.value}")



        runBlocking {

            val listOf: List<Deferred<Unit>> = listOf(
//                async { EntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async { InterfaceGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async { ColumnEntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async { UniqueKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async { ForeignKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async { ContextDataClassesGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation) },
//                async {
//                    SyntheticFieldExtractorsGenerator(codeGenerator, rootPackage, logger).createFiles(
//                        metaInformation
//                    )
//                },
//                async {
//                    OriginEntityDataClassesGenerator(
//                        codeGenerator,
//                        rootPackage,
//                        logger
//                    ).createFiles(metaInformation)
//                },
            )


            val awaitAll = listOf.awaitAll()
            awaitAll
        }
        kotlin.runCatching {
            val createNewFileByPath = codeGenerator.createNewFileByPath(
                Dependencies(
                    true,
                ), "QWERTY", "json"
            )

            createNewFileByPath.appendText("genFile.generatedCode.value")

            createNewFileByPath.close()
        }

        return symbols.toList()

    }

    private fun triple(resolver: Resolver): Triple<List<KSAnnotated>, MetaInformation, PackageName> {
        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.warn("count entities ${symbols.size}")

        val metaInformation = metaInformation(symbols, logger, false)

        val rootPackage = PackageName(commonPackage(metaInformation.entities.values.toSet()))
        CommonClassNames.setRootPackage(rootPackage)
        return Triple(symbols, metaInformation, rootPackage)
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