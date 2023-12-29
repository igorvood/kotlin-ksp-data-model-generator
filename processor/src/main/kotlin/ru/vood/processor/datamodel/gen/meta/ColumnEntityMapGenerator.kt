package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.*
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import java.time.LocalDateTime
import javax.annotation.processing.Generated

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

                        val entityClass = entityClassName(ent)
                        val syntheticClassName = syntheticClassName(ent)

                        val syntheticF = syntheticFieldInfos
                            .sortedBy { it.metaEntity.entityFieldName }
                            .map { syntheticFieldInfo ->
                                val fromEntity = syntheticFieldInfo.metaEntity
                                val isOptional =
                                    syntheticFieldInfo.isOptional && syntheticFieldInfo.relationType == RelationType.ONE_TO_ONE_OPTIONAL

                                val columnKindType = when (syntheticFieldInfo.relationType) {
                                    RelationType.ONE_TO_ONE_OPTIONAL ->
                                        "${Synthetic::class.simpleName}<$entityClass, $syntheticClassName, ${syntheticFieldInfo.metaEntity.designClassPackageName}.${
                                            entityClassName(
                                                syntheticFieldInfo.metaEntity
                                            )
                                        }>{it.${fromEntity.entityFieldName}?.let{q->setOf(q)}?:setOf()}"
                                    RelationType.ONE_TO_ONE_MANDATORY ->
                                        "${Synthetic::class.simpleName}<$entityClass, $syntheticClassName, ${syntheticFieldInfo.metaEntity.designClassPackageName}.${
                                            entityClassName(
                                                syntheticFieldInfo.metaEntity
                                            )
                                        } >{setOf(it.${fromEntity.entityFieldName})}"
                                    RelationType.MANY_TO_ONE ->
                                        "${SyntheticSet::class.simpleName}<$entityClass, $syntheticClassName, ${syntheticFieldInfo.metaEntity.designClassPackageName}.${
                                            entityClassName(
                                                syntheticFieldInfo.metaEntity
                                            )
                                        } >{it.${fromEntity.entityFieldName}}"
                                    RelationType.UNNOWN -> error("Не известный тип")
                                }


                                val fullColumnName = FullColumnName(
                                    EntityName(fromEntity.designClassShortName),
                                    SimpleColumnName(fromEntity.entityFieldName)
                                )


                                """${FullColumnName::class.simpleName}("${fullColumnName.value}") to ${SyntheticColumnEntityData::class.simpleName}(
                                |${SyntheticColumnEntityData<*>::entity.name}= ${EntityName::class.java.simpleName}( "${ent.designClassShortName}"),
                                |${SyntheticColumnEntityData<*>::outEntity.name} = ${EntityName::class.java.simpleName}( "${fromEntity.designClassShortName}"),
                                |${SyntheticColumnEntityData<*>::simpleColumnName.name} = ${SimpleColumnName::class.simpleName}("${fromEntity.entityFieldName}"),
                                |${SyntheticColumnEntityData<*>::isOptional.name}= ${isOptional},
                                |${SyntheticColumnEntityData<*>::comment.name} ="${fromEntity.comment}",
                                |${SyntheticColumnEntityData<*>::iColExtractFunction.name} = $columnKindType,
                                |)""".trimMargin()

                            }


                        val simpleF = ent.fields
                            .sortedBy { ec -> ec.position }
                            .map { col ->
                                """${FullColumnName::class.simpleName}("${ent.designClassShortName}_${col.name.value}") to ${SimpleColumnEntityData::class.simpleName}(
                                |${SimpleColumnEntityData<*>::entity.name} = ${EntityName::class.java.simpleName}( "${ent.designClassShortName}"),
                                |${SimpleColumnEntityData<*>::simpleColumnName.name} = ${SimpleColumnName::class.simpleName}("${col.name.value}"),
                                |${SimpleColumnEntityData<*>::isOptional.name} = ${col.isNullable},
                                |${SimpleColumnEntityData<*>::comment.name} = "${col.comment}",
                                |${SimpleColumnEntityData<*>::iColExtractFunction.name} = ${SimpleColExtractFunction::class.simpleName}<$entityClass, ${col.type}${col.question}> {it.${col.name.value}},
                                |${SimpleColumnEntityData<*>::simpleColumnType.name} = ${SimpleColumnType::class.simpleName}("${col.type}")
                                |)""".trimMargin()
                            }
                        simpleF.plus(syntheticF)
                    }
                    .joinToString(",\n")


                val trimIndent =
                    """package ${packageName.value}
                        
import ${SimpleColumnType::class.java.canonicalName}

import ${SimpleColumnName::class.java.canonicalName}
import ${FullColumnName::class.java.canonicalName}
import ${SyntheticColumnEntityData::class.java.canonicalName}
import ${SimpleColumnEntityData::class.java.canonicalName}

import ${EntityName::class.java.canonicalName}

import ${Generated::class.java.canonicalName}
import ${IColExtractFunction::class.java.canonicalName}
import ${SimpleColExtractFunction::class.java.canonicalName}
import ${Synthetic::class.java.canonicalName}
import ${SyntheticSet::class.java.canonicalName}
import kotlin.reflect.KProperty1
${metaInfo.allEntityPackagesImport}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
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

