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
import ru.vood.processor.datamodel.gen.meta.*
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator
import ru.vood.processor.datamodel.gen.runtime.SyntheticFieldExtractorsGenerator

class DataModelConfigProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.info("count entities ${symbols.size}")


        val metaInformation = metaInformation(symbols, logger)

        metaInformation.entities.values
            .forEach { metaEntity ->
                logger.info("read MetaEntity ${metaEntity}", metaEntity.ksAnnotated)
            }


        val setMetaEnt = metaInformation.entities.values.toSet()
        val rootPackage = PackageName(commonPackage(setMetaEnt))

        logger.info("root package ${rootPackage.value}")

//        EntityEnumGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        EntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
//        EntityConstructorMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)

//        ColumnEntityEnumGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        ColumnEntityMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)

        UniqueKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
//        UniqueKeyEnumGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)

//        ForeignKeyEnumGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
        ForeignKeyMapGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)

//        DependencyGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)



//        EntityDataClassesGenerator(codeGenerator, rootPackage, logger).createFiles(metaInformation)
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

                    if (collector.isEmpty()) {
                        println(1)
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