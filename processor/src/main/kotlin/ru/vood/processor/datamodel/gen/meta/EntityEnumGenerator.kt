package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.SealedEntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import java.time.LocalDateTime
import java.util.*
import javax.annotation.processing.Generated

class EntityEnumGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = nameClassEntityEnumGenerator

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()

        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData

                    .map { metaEntity ->

                        val entity = when (metaEntity.flowEntityType) {
                            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> """${EntityData::class.simpleName}(
                            |${EntityData<*>::designClass.name} =  ${metaEntity.designClassFullClassName.value}::class, 
                            |${EntityData<*>::runtimeClass.name} = ${CollectName.entityClassName(metaEntity)}::class,
                            |${EntityData<*>::runtimeSyntheticClass.name} = ${CollectName.syntheticClassName(metaEntity)}::class,
                            |serializer =${CollectName.entityClassName(metaEntity)}.serializer(),
                            |serializerSynthetic =${CollectName.syntheticClassName(metaEntity)}.serializer(),
                            |${EntityData<*>::entityName.name} =${EntityName::class.simpleName}("${metaEntity.designClassShortName}"), 
                            |${EntityData<*>::comment.name} ="${metaEntity.comment}",
                            |${EntityData<*>::entityType.name} =${metaEntity.flowEntityType}
                            |//${metaEntity.ksAnnotated.getAllProperties().toList().size}
                            |)"""
                            FlowEntityType.ONE_OF -> {
                                val sealedChildrenEntities = metaInfo.metaForeignKeys
                                    .filter { fk -> fk.toEntity.designClassFullClassName == metaEntity.designClassFullClassName }
                                    .map { fk -> EntityName(fk.fromEntity.designClassShortName) }
                                    .distinct()
                                    .map { sealedChildrenEntity -> """${EntityName::class.simpleName}("${sealedChildrenEntity.value}")""" }
                                    .joinToString(", ")


                                """${SealedEntityData::class.simpleName}(
                            |${SealedEntityData<*>::designClass.name} =  ${metaEntity.designClassFullClassName.value}::class, 
                            |${SealedEntityData<*>::runtimeClass.name} = ${CollectName.entityClassName(metaEntity)}::class,
                            |${SealedEntityData<*>::runtimeSyntheticClass.name} = ${
                                    CollectName.syntheticClassName(
                                        metaEntity
                                    )
                                }::class,
                            |serializer =${CollectName.entityClassName(metaEntity)}.serializer(),
                            |serializerSynthetic =${CollectName.syntheticClassName(metaEntity)}.serializer(),
                            |${SealedEntityData<*>::entityName.name} =${EntityName::class.simpleName}("${metaEntity.designClassShortName}"), 
                            |${SealedEntityData<*>::comment.name} ="${metaEntity.comment}",
                            |${SealedEntityData<*>::entityType.name} =${metaEntity.flowEntityType},
                            |${SealedEntityData<*>::children.name} = setOf(${sealedChildrenEntities})
                            |)"""
                            }
                        }

                        """${EntityName::class.simpleName}("${metaEntity.designClassShortName}") to $entity""".trimMargin()
                        metaEntity.designClassShortName
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}

import ${FlowEntityType::class.java.canonicalName}.*
import ${EntityData::class.java.canonicalName}
import ${SealedEntityData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}

${metaInfo.allEntityPackagesImport}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
enum class EntityEnum{
$entities;

companion object{
    val entityMap = EnumMap(values().associateWith { ee ->
        entityDataMap.getValue(EntityName(ee.name))
    })

}

}
"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val nameClassEntityEnumGenerator = "MetaEntityEnum"
    }

}

