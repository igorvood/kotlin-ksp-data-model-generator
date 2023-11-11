package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.FkPair
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.dmgen.intf.IMetaFkEntity
import ru.vood.dmgen.intf.IMetaUkEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.meta.ColumnEntityEnumGenerator.Companion.columnEntityEnumGeneratorNameClass

class ForeignKeyEnumGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = foreignKeyEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.metaForeignKeys.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData
                    .map { metaForeign ->
//                        "${ent.shortName}_${f.name.value}"
                        val fkCols = metaForeign.fkCols.map { fkPa ->

                            """FkPair(${metaForeign.fromEntity.designClassShortName}_${fkPa.from.name.value}, ${metaForeign.toEntity.designClassShortName}_${fkPa.to.name.value})"""
                        }.joinToString(",\n")

                        """${metaForeign.name.value}(
                            |${metaForeign.fromEntity.designClassShortName}, 
                            |${metaForeign.toEntity.designClassShortName}, 
                            |${metaForeign.uk.name.value},
                            |${RelationType::class.java.canonicalName}.${metaForeign.relationType.name},
                            |setOf($fkCols)
                            |)""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
import ${packageName.value}.${UniqueKeyEnumGenerator.uniqueKeyEnumGeneratorNameClass}.*
import ${FkPair::class.java.canonicalName}
import ${packageName.value}.${columnEntityEnumGeneratorNameClass}.*

enum class $nameClass(
    override val fromEntity: ${IMetaEntity::class.java.canonicalName},
    override val toEntity: ${IMetaEntity::class.java.canonicalName},
    override val uk: ${IMetaUkEntity::class.java.canonicalName},
    override val relationType: ${RelationType::class.java.canonicalName},
    override val fkCols: Set<FkPair>,
): ${IMetaFkEntity::class.java.canonicalName} {
$entities
}
"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName(nameClass), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val foreignKeyEnumGeneratorNameClass = "DataDictionaryForeignKeyEnum"
    }
}
