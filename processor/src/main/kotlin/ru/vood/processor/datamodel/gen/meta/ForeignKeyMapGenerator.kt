package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.FKEntityData
import ru.vood.dmgen.intf.newIntf.IMetaFkEntityNew
import ru.vood.dmgen.intf.newIntf.IMetaUkEntityNew
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.meta.ColumnEntityEnumGenerator.Companion.columnEntityEnumGeneratorNameClass

class ForeignKeyMapGenerator(
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

                            """FkPair(${metaForeign.fromEntity.shortName}_${fkPa.from.name.value}, ${metaForeign.toEntity.shortName}_${fkPa.to.name.value})"""
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

                val entitiesMap = generatedClassData
                    .map { metaForeign ->
//                        "${ent.shortName}_${f.name.value}"
                        val fkCols = metaForeign.fkCols.map { fkPa ->

                            """FkPair(${metaForeign.fromEntity.shortName}_${fkPa.from.name.value}, ${metaForeign.toEntity.shortName}_${fkPa.to.name.value})"""
                        }.joinToString(",\n")

                        """FkName ("${metaForeign.name.value}") to FKEntityData(
                        |EntityName("${metaForeign.fromEntity.shortName}"),
                        |EntityName("${metaForeign.toEntity.shortName}"),
                        |UkName("${metaForeign.uk.name.value}"),
                        |${RelationType::class.java.canonicalName}.${metaForeign.relationType.name},
                        |setOf($fkCols),
                        |
                        |)""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

//                data class FKEntityData<T : IEntity<T>>(
//                    override val fromEntity: IMetaUkEntityNew<T>,
//                    override val toEntity: IMetaUkEntityNew<T>,
//                    override val uk: IMetaUkEntityNew<T>,
//                    override val relationType: RelationType,
//                    override val fkCols: Set<FkPair>
////    override val contextOfClass: KClass<IContextOf<T>>
//                ) : IMetaFkEntityNew<T> {


                    val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
import ${packageName.value}.${UniqueKeyEnumGenerator.uniqueKeyEnumGeneratorNameClass}.*
import ${FkPair::class.java.canonicalName}
import ${FkName::class.java.canonicalName}
import ${FKEntityData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${UkName::class.java.canonicalName}
import ${packageName.value}.${columnEntityEnumGeneratorNameClass}.*


val foreignKeyMap = mapOf(
$entitiesMap

)


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
        val foreignKeyEnumGeneratorNameClass = "DataDictionaryForeignKeyMap"
    }
}
