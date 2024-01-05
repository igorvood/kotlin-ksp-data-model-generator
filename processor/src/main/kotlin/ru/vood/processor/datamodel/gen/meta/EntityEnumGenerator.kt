package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.EntityName1
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
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
                            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> """${InterfaceGenerator.GeneratedClasses.EntityData}(
                            |designClass =  ${metaEntity.designClassFullClassName.value}::class, 
                            |runtimeClass = ${CollectName.entityClassName(metaEntity)}::class,
                            |runtimeSyntheticClass = ${CollectName.syntheticClassName(metaEntity)}::class,
                            |serializer =${CollectName.entityClassName(metaEntity)}.serializer(),
                            |serializerSynthetic =${CollectName.syntheticClassName(metaEntity)}.serializer(),
                            |entityName =${metaEntity.designClassShortName}, 
                            |comment ="${metaEntity.comment}",
                            |entityType =${metaEntity.flowEntityType}
                            |)"""
                            FlowEntityType.ONE_OF -> {
                                val sealedChildrenEntities = metaInfo.metaForeignKeys
                                    .filter { fk -> fk.toEntity.designClassFullClassName == metaEntity.designClassFullClassName }
                                    .map { fk -> EntityName1(fk.fromEntity.designClassShortName) }
                                    .distinct()
                                    .map { sealedChildrenEntity -> """${sealedChildrenEntity.value}""" }
                                    .joinToString(", ")


                                """${InterfaceGenerator.GeneratedClasses.SealedEntityData}(
                            |designClass =  ${metaEntity.designClassFullClassName.value}::class, 
                            |runtimeClass = ${CollectName.entityClassName(metaEntity)}::class,
                            |runtimeSyntheticClass = ${
                                    CollectName.syntheticClassName(
                                        metaEntity
                                    )
                                }::class,
                            |serializer =${CollectName.entityClassName(metaEntity)}.serializer(),
                            |serializerSynthetic =${CollectName.syntheticClassName(metaEntity)}.serializer(),
                            |entityName = ${metaEntity.designClassShortName}, 
                            |comment ="${metaEntity.comment}",
                            |entityType =${metaEntity.flowEntityType},
                            |children = setOf(${sealedChildrenEntities})
                            |)"""
                            }
                        }

                        """${metaEntity.designClassShortName} to $entity""".trimMargin()
                        metaEntity.designClassShortName
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}

import ${FlowEntityType::class.java.canonicalName}.*
import ${Generated::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}

${metaInfo.allEntityPackagesImport}

//@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
//enum class EntityEnum{
/*$entities;
*/
//companion object{
 //   val entityMap = EnumMap(values().associateWith { ee ->
//        entityDataMap.getValue(ee)
//    })

//}

//}
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

