package ru.vood.processor.datamodel.abstraction.model.gen

import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.FkPair
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.dmgen.intf.IMetaFkEntity
import ru.vood.dmgen.intf.IMetaUkEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.gen.ColumnEntityEnumGenerator.Companion.columnEntityEnumGeneratorNameClass
import ru.vood.processor.datamodel.abstraction.model.gen.dto.FileName
import ru.vood.processor.datamodel.abstraction.model.gen.dto.GeneratedCode
import ru.vood.processor.datamodel.abstraction.model.gen.dto.GeneratedFile
import ru.vood.processor.datamodel.abstraction.model.gen.dto.PackageName
import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment
import javax.tools.Diagnostic

class ForeignKeyEnumGenerator(
    messager: Messager,

    processingEnv: ProcessingEnvironment,
    rootPackage: PackageName

) : AbstractDataDictionaryGenerator<Set<MetaForeignKey>>(messager, processingEnv, rootPackage) {

    override val nameClass: String
        get() = foreignKeyEnumGeneratorNameClass

    override fun textGenerator(generatedClassData: Set<MetaForeignKey>): Set<GeneratedFile> {
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData
                    .map { metaForeign ->
//                        "${ent.shortName}_${f.name.value}"
                        val fkCols = metaForeign.fkCols.map { fkPa ->

                            """FkPair(${metaForeign.fromEntity.name}_${fkPa.from.name.value}, ${metaForeign.toEntity.name}_${fkPa.to.name.value})"""
                        }.joinToString(",\n")

                        """${metaForeign.name.value}(
                            |${metaForeign.fromEntity.shortName}, 
                            |${metaForeign.toEntity.shortName}, 
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
                log(Diagnostic.Kind.NOTE, "Create $nameClass")
                setOf(GeneratedFile(FileName(nameClass), GeneratedCode(trimIndent)))
            }
        }


    }

    companion object {
        val foreignKeyEnumGeneratorNameClass = "DataDictionaryForeignKeyEnum"
    }
}
