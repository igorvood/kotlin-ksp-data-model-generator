package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.UKEntityData
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.UkName
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator.Companion.contextDataClassesGeneratorPackageName
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator

class UniqueKeyMapGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = uniqueKeyEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData
                    .flatMap { metaEnt ->
                        metaEnt.uniqueKeysFields.keys
                            .map { ukDto ->
                                val ukCols =
                                    ukDto.cols.map { columnName -> """${ColumnName::class.java.canonicalName}("${metaEnt.shortName}_${columnName.value}")""" }
                                        .sorted()
                                        .joinToString(",")
                                val constructorParams = ukDto.cols.map { columnName -> """data.${columnName.value}""" }
                                    .sorted()
                                    .joinToString(",")
//
                                """${UkName::class.java.canonicalName}("${ukDto.name.value}") to UKEntityData(
                                    |setOf($ukCols),
                                    |${EntityName::class.java.canonicalName}("${metaEnt.shortName}"),
                                    |{data: ${metaEnt.shortName}Entity -> ${metaEnt.shortName}Context${ukDto.name.value}($constructorParams) }
                                    |//${rootPackage.value}${contextDataClassesGeneratorPackageName.value}.${metaEnt.shortName}Context${ukDto.name.value}::class,

                                    |)""".trimMargin()

//                                """${ukDto.name.value}(
//                                    |setOf($ukCols),
//                                    |${packageName.value}.${nameClassEntityEnumGenerator}.${metaEnt.shortName},
//                                    |${rootPackage.value}${contextDataClassesGeneratorPackageName.value}.${metaEnt.shortName}Context${ukDto.name.value}::class,
//                                    |)""".trimMargin()

                            }
                    }

                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${rootPackage.value}.${EntityDataClassesGenerator.entityDataClassesGeneratorPackageName.value}.*
import ${rootPackage.value}.${contextDataClassesGeneratorPackageName.value}.*
import ${UKEntityData::class.java.canonicalName}
import kotlin.reflect.KClass


val uniqueKeyMap = mapOf(
$entities

)


"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val uniqueKeyEnumGeneratorNameClass = "DataDictionaryUniqueKeyMap"
    }

}
