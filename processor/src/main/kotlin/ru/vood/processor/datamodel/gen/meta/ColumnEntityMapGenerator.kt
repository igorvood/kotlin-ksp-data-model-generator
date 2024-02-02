package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.MetaColumns
import ru.vood.dmgen.dto.*
import ru.vood.dmgen.metaJson.IColumnEntityDataJson
import ru.vood.dmgen.metaJson.SimpleColumnEntityDataJson
import ru.vood.dmgen.metaJson.SyntheticColumnEntityDataJson
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import javax.annotation.processing.Generated

class ColumnEntityMapGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger,
) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger),
    ISideEffect<IColumnEntityDataJson> {

    override val nameClass: String
        get() = columnEntityEnumGeneratorNameClass

    private val entityDataJsonList = CopyOnWriteArrayList<IColumnEntityDataJson>()
    override fun entityDataJsonList() = entityDataJsonList.toList()

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val metaEntitySet = metaInfo.entities.values.toSet()
        val metaForeignKeys = metaInfo.metaForeignKeys
        return when (metaEntitySet.isEmpty()) {
            true -> setOf()
            false -> {
                val simpleColumn = metaEntitySet
                    .sortedBy { it.designClassShortName }
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
                            .filterIsInstance<SyntheticFieldInfo>()
                            .map { synth ->
//                                when (val synth = syntheticFieldInfo) {
//                                    is SyntheticFieldInfo -> {
                                val fromEntity = synth.metaEntity
                                val isOptional =
                                    /*syntheticFieldInfo.isOptional &&*/
                                    synth.relationType == RelationType.ONE_TO_ONE_OPTIONAL
                                val sealedText = """setOf(it.${fromEntity.entityFieldName})"""
                                val columnKindType = when (synth.relationType) {
                                    RelationType.ONE_TO_ONE_OPTIONAL -> {
                                        val funBody =
                                            if (synth.isOneOf) sealedText else """it.${fromEntity.entityFieldName}?.let{q->setOf(q)}?:setOf()"""
                                        "${InterfaceGenerator.GeneratedClasses.Synthetic}<$entityClass, $syntheticClassName, ${synth.metaEntity.designClassPackageName}.${
                                            entityClassName(
                                                synth.metaEntity
                                            )
                                        }>{$funBody}"
                                    }
                                    RelationType.ONE_TO_ONE_MANDATORY -> {
                                        val funBody =
                                            if (synth.isOneOf) sealedText else """setOf(it.${fromEntity.entityFieldName})"""
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
                                entityDataJsonList.add(
                                    SyntheticColumnEntityDataJson(
                                        entity = EntityName(value = ent.designClassShortName),
                                        simpleColumnName = SimpleColumnName(fromEntity.entityFieldName),
                                        isOptional = isOptional,
                                        comment = fromEntity.comment ?: "пусто",
                                        outEntity = EntityName(value = fromEntity.designClassShortName)
                                    )
                                )

                                "${fullColumnName.value}" to """${fullColumnEnumName}.${fullColumnName.value} to ${InterfaceGenerator.GeneratedClasses.SyntheticColumnEntityData}(
                                |entity= ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${ent.designClassShortName},
                                |outEntity = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${fromEntity.designClassShortName},
                                |simpleColumnName = ${SimpleColumnName::class.simpleName}("${fromEntity.entityFieldName}"),
                                |isOptional= ${isOptional},
                                |comment ="${fromEntity.comment}",
                                |iColExtractFunction = $columnKindType,
                                |)""".trimMargin()

                            } //map


                        val simpleF = ent.fields
                            .sortedBy { ec -> ec.position }
                            .map { col ->
                                entityDataJsonList.add(
                                    SimpleColumnEntityDataJson(
                                        entity = EntityName(value = ent.designClassShortName),
                                        simpleColumnName = SimpleColumnName(col.name.value),
                                        isOptional = col.isNullable,
                                        comment = col.comment ?: "пусто",
                                        simpleColumnType = SimpleColumnType(value = col.type)
                                    )
                                )

                                "${ent.designClassShortName}_${col.name.value}" to """${fullColumnEnumName}.${ent.designClassShortName}_${col.name.value} to ${InterfaceGenerator.GeneratedClasses.SimpleColumnEntityData}(
                                |entity = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${ent.designClassShortName},
                                |simpleColumnName = ${SimpleColumnName::class.simpleName}("${col.name.value}"),
                                |isOptional = ${col.isNullable},
                                |comment = "${col.comment}",
                                |iColExtractFunction = ${InterfaceGenerator.GeneratedClasses.SimpleColExtractFunction}<$entityClass, ${col.type}${col.question}> {it.${col.name.value}},
                                |simpleColumnType = ${SimpleColumnType::class.simpleName}("${col.type}")
                                |)""".trimMargin()
                            }
                        val plus = simpleF.plus(syntheticF)
                        plus
                    }


                val trimIndent =
                    """package ${packageName.value}
                        
import ${SimpleColumnType::class.java.canonicalName}

import ${SimpleColumnName::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.SyntheticColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SimpleColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SealedSyntheticColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.EntityEnum.getPac(rootPackage)}

import ${InterfaceGenerator.GeneratedClasses.ColumnEntityData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.IEntityOrigin.getPac(rootPackage)}

import ${Generated::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}
import ${MetaColumns::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.IColExtractFunction.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SimpleColExtractFunction.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.Synthetic.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.SyntheticSet.getPac(rootPackage)}
import kotlin.reflect.KProperty1
${metaInfo.allEntityPackagesImport}

@${Generated::class.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@${MetaColumns::class.simpleName}
enum class ${fullColumnEnumName}{
${simpleColumn.joinToString(",\n") { it.first }};

fun columnData() = columnEntityDataMap[this]!!

companion object{
private val columnEntityDataMap = EnumMap(mapOf(
${simpleColumn.joinToString(",\n") { it.second }}
)
)
}

}

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val columnEntityEnumGeneratorNameClass = "DataDictionaryColumnEntityMap"
        val fullColumnEnumName = "FullColumnNameEnum"
    }
}

