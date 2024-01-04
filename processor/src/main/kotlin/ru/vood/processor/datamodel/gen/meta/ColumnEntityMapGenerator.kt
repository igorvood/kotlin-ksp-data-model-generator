package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.SimpleColumnType
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.SealedSyntheticFieldInfo
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
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
//                            .sortedBy { it.metaEntity.entityFieldName }
//                            .filter {syntheticFieldInfo ->  syntheticFieldInfo.metaEntity.designClassShortName !in listOf<String>("DealTwoData", "DealOneData") }
                            .map { syntheticFieldInfo ->
                                when (val synth = syntheticFieldInfo) {
                                    is SyntheticFieldInfo -> {
                                        val fromEntity = synth.metaEntity
                                        val isOptional =
                                            /*syntheticFieldInfo.isOptional &&*/
                                            syntheticFieldInfo.relationType == RelationType.ONE_TO_ONE_OPTIONAL
                                        val sealedText = """setOf(it.${fromEntity.entityFieldName})"""
                                        val columnKindType = when (syntheticFieldInfo.relationType) {
                                            RelationType.ONE_TO_ONE_OPTIONAL -> {
                                                val funBody =
                                                    if (syntheticFieldInfo.isOneOf) sealedText else """it.${fromEntity.entityFieldName}?.let{q->setOf(q)}?:setOf()"""
                                                "${InterfaceGenerator.GeneratedClasses.Synthetic}<$entityClass, $syntheticClassName, ${synth.metaEntity.designClassPackageName}.${
                                                    entityClassName(
                                                        synth.metaEntity
                                                    )
                                                }>{$funBody}"
                                            }
                                            RelationType.ONE_TO_ONE_MANDATORY -> {
                                                val funBody =
                                                    if (syntheticFieldInfo.isOneOf) sealedText else """setOf(it.${fromEntity.entityFieldName})"""
                                                "${InterfaceGenerator.GeneratedClasses.Synthetic}<$entityClass, $syntheticClassName, ${synth.metaEntity.designClassPackageName}.${
                                                    entityClassName(
                                                        synth.metaEntity
                                                    )
                                                }>{$funBody}"
                                            }
                                            RelationType.MANY_TO_ONE ->
                                                "${InterfaceGenerator.GeneratedClasses.SyntheticSet}<$entityClass, $syntheticClassName, ${synth.metaEntity.designClassPackageName}.${
                                                    entityClassName(
                                                        synth.metaEntity
                                                    )
                                                } >{it.${fromEntity.entityFieldName}}"
                                        }


                                        val fullColumnName = FullColumnName(
                                            EntityName(fromEntity.designClassShortName),
                                            SimpleColumnName(fromEntity.entityFieldName)
                                        )


                                        """${FullColumnName::class.simpleName}("${fullColumnName.value}") to ${InterfaceGenerator.GeneratedClasses.SyntheticColumnEntityData}(
                                |entity= ${EntityName::class.java.simpleName}( "${ent.designClassShortName}"),
                                |outEntity = ${EntityName::class.java.simpleName}( "${fromEntity.designClassShortName}"),
                                |simpleColumnName = ${SimpleColumnName::class.simpleName}("${fromEntity.entityFieldName}"),
                                |isOptional= ${isOptional},
                                |comment ="${fromEntity.comment}",
                                |iColExtractFunction = $columnKindType,
                                |)""".trimMargin()
                                    }
                                    is SealedSyntheticFieldInfo -> {

                                        syntheticFieldInfo
                                        val fullColumnName = FullColumnName(
                                            EntityName(ent.designClassShortName),
                                            SimpleColumnName(ent.entityFieldName)
                                        )

                                        val joinToString =
                                            synth.metaEntities.map { it -> """${EntityName::class.java.simpleName}("${it.designClassShortName}")""" }
                                                .joinToString(",")

                                        """${FullColumnName::class.simpleName}("${fullColumnName.value}") to ${InterfaceGenerator.GeneratedClasses.SealedSyntheticColumnEntityData}(
                                          |entity= ${EntityName::class.java.simpleName}( "${ent.designClassShortName}"),
                                          |simpleColumnName= ${SimpleColumnName::class.java.simpleName}( "${ent.entityFieldName}"),
                                          |isOptional= false,
                                          |comment= "${ent.comment}",
                                          |outEntities= setOf(${joinToString}),
                                          |)""".trimMargin()


                                    }
                                }


                            }


                        val simpleF = ent.fields
                            .sortedBy { ec -> ec.position }
                            .map { col ->
                                """${FullColumnName::class.simpleName}("${ent.designClassShortName}_${col.name.value}") to ${InterfaceGenerator.GeneratedClasses.SimpleColumnEntityData}(
                                |entity = ${EntityName::class.java.simpleName}( "${ent.designClassShortName}"),
                                |simpleColumnName = ${SimpleColumnName::class.simpleName}("${col.name.value}"),
                                |isOptional = ${col.isNullable},
                                |comment = "${col.comment}",
                                |iColExtractFunction = ${InterfaceGenerator.GeneratedClasses.SimpleColExtractFunction}<$entityClass, ${col.type}${col.question}> {it.${col.name.value}},
                                |simpleColumnType = ${SimpleColumnType::class.simpleName}("${col.type}")
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
import ${InterfaceGenerator.GeneratedClasses.SyntheticColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SimpleColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SealedSyntheticColumnEntityData.getPac(rootPackage)}

import ${EntityName::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.ColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.IEntityOrigin.getPac(rootPackage)}

import ${Generated::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.IColExtractFunction.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SimpleColExtractFunction.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.Synthetic.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SyntheticSet.getPac(rootPackage)}
import kotlin.reflect.KProperty1
${metaInfo.allEntityPackagesImport}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
val columnEntityDataMap : Map<FullColumnName, ColumnEntityData<out IEntityOrigin>> = mapOf(
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

