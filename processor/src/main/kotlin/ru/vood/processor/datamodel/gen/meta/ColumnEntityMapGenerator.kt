package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.ColumnName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.ColumnEntityData
import ru.vood.dmgen.intf.newIntf.ColumnKind
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator.Companion.entityDataClassesGeneratorPackageName

class ColumnEntityMapGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = columnEntityEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()
        val metaForeignKeys = metaInfo.metaForeignKeys
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val simpleColumn = generatedClassData
                    .flatMap { ent ->

                        val filter = metaForeignKeys
                            .filter { fk -> fk.fromEntity.flowEntityType != FlowEntityType.AGGREGATE }
                            .filter { fk -> fk.toEntity == ent }
                            .map { it.fromEntity }

                        val syntheticFieldInfos = syntheticFieldInfos(filter, metaForeignKeys, ent, logger)

                        logger.info(" syntheticFieldInfos     ${syntheticFieldInfos.size}   ${filter.size}  ${ent.entityFieldName}")


                        val map1 = syntheticFieldInfos
                            .sortedBy { it.metaEntity.entityFieldName }
                            .map { syntheticFieldInfo ->
                                val fromEntity = syntheticFieldInfo.metaEntity
                                val isOptional =
                                    syntheticFieldInfo.isOptional && syntheticFieldInfo.relationType == RelationType.ONE_TO_ONE_OPTIONAL

                                val columnKind = when (syntheticFieldInfo.relationType) {
                                    RelationType.ONE_TO_ONE_OPTIONAL -> ColumnKind.SYNTHETIC
                                    RelationType.MANY_TO_ONE -> ColumnKind.SYNTHETIC_SET
                                    RelationType.UNNOWN -> error("Не известный тип")
                                }


                                """${ColumnName::class.simpleName}("${fromEntity.designClassShortName}_${fromEntity.entityFieldName}") to ${ColumnEntityData::class.simpleName}(
                                |    ${EntityName::class.java.canonicalName}( "${ent.designClassShortName}"),
                                |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${
                                    CollectName.entityClassName(
                                        ent
                                    )
                                }::${fromEntity.entityFieldName},
                                |${ColumnName::class.simpleName}("${fromEntity.entityFieldName}"),
                                |${isOptional},
                                |"${fromEntity.comment}",
                                |${columnKind.name}
                                |)""".trimMargin()

                            }


                        val syntheticCols = metaForeignKeys
                            .filter { fk -> fk.fromEntity.flowEntityType != FlowEntityType.AGGREGATE }
                            .filter { fk -> fk.toEntity == ent }
                            .sortedBy { e -> e.fromEntity.entityFieldName }
                            .map {fk ->
                                val fromEntity = fk.fromEntity

                                """${ColumnName::class.simpleName}("${fromEntity.designClassShortName}_${fromEntity.entityFieldName}") to ${ColumnEntityData::class.simpleName}(
                                |    ${EntityName::class.java.canonicalName}( "${ent.designClassShortName}"),
                                |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${CollectName.entityClassName(ent)}::${fromEntity.entityFieldName},
                                |${ColumnName::class.simpleName}("${fromEntity.entityFieldName}"),
                                |false,
                                |"${fromEntity.comment}",
                                |${ColumnKind.SYNTHETIC.name}
                                |)""".trimMargin()
                            }



                        val map = ent.fields
                            .sortedBy { ec -> ec.position }
                            .map { f ->
                                """${ColumnName::class.simpleName}("${ent.designClassShortName}_${f.name.value}") to ${ColumnEntityData::class.simpleName}(
                                |    ${EntityName::class.java.canonicalName}( "${ent.designClassShortName}"),
                                |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${
                                    CollectName.entityClassName(
                                        ent
                                    )
                                }::${f.name.value},
                                |${ColumnName::class.simpleName}("${f.name.value}"),
                                |${f.isNullable},
                                |"${f.comment}",
                                |${ColumnKind.SIMPLE.name}
                                |)""".trimMargin()
                            }
                        map.plus(map1)
                    }
                    .joinToString(",\n")


                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
import ${ColumnEntityData::class.java.canonicalName}
import ${ColumnName::class.java.canonicalName}
import ${ColumnKind::class.java.canonicalName}
import ${ColumnKind::class.java.canonicalName}.*
import kotlin.reflect.KProperty1


val columnEntityDataMap = mapOf(
$simpleColumn,


)

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val columnEntityEnumGeneratorNameClass = "DataDictionaryColumnEntityMap"
    }
}

