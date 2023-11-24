package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntitySynthetic
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.IConstructorSyntheticEntity
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
import ru.vood.processor.datamodel.gen.runtime.SyntheticFieldExtractorsGenerator.Companion.entitySyntheticDataClassesGeneratorPackageName
import java.time.LocalDateTime
import java.util.*
import javax.annotation.processing.Generated

class EntityConstructorMapGenerator(
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

                    .map {

                        val chldrenEntities = metaInfo.aggregateInnerDep().children.map { it.metaEntity }
                        val fkFunCode = syntheticFieldInfos(chldrenEntities, metaInfo.metaForeignKeys, it, logger)
                            .map { syntheticFieldInfo ->
                                val s = if (syntheticFieldInfo.isOptional) "?" else ""
                                val genField =
                                    genMapExtract(syntheticFieldInfo.metaEntity, s, syntheticFieldInfo.relationType)
                                Optional.of(genField)

                            }
                            .joinToString("\n") { it.get() }


                        val entityClassName = CollectName.entityClassName(it)
                        val syntheticClassName = CollectName.syntheticClassName(it)

                        """${EntityName::class.simpleName}("${it.designClassShortName}") to object: ${IConstructorSyntheticEntity::class.simpleName}<${entityClassName}>{
                            override fun construct(origin: ${entityClassName}, childrenMap: Map<${EntityName::class.simpleName}, Any>): ${IEntitySynthetic::class.simpleName}<${entityClassName}> {
                            $syntheticClassName(origin, $fkFunCode)
                            TODO("Not yet implemented")
                            }
                            }
                        """.trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
import kotlin.reflect.KClass
import kotlinx.serialization.KSerializer
import ${rootPackage.value}.${entityOriginDataClassesGeneratorPackageName.value}.*
import ${rootPackage.value}.${entitySyntheticDataClassesGeneratorPackageName.value}.*
import ${FlowEntityType::class.java.canonicalName}.*
import ${FlowEntityType::class.java.canonicalName}
import ${EntityData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${IEntitySynthetic::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import ${IConstructorSyntheticEntity::class.java.canonicalName}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
val entityConstructorDataMap = mapOf(
$entities

)




"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    private fun genMapExtract(metaEntity: MetaEntity, question: String, relationType: RelationType): String {

//        childrenMap[EntityName("asdasda")] as DealParamOneToOneSynthetic,
//        childrenMap[EntityName("asdasda")] as DealParamOneToOneOptionalSynthetic,
//        childrenMap[EntityName("asdasda")] as Set<DealParamSetSynthetic>

        val s = when (relationType) {
            RelationType.ONE_TO_ONE_OPTIONAL -> {

                """ ${CollectName.syntheticClassName(metaEntity)}"""

            }
            RelationType.MANY_TO_ONE -> """ Set<${CollectName.syntheticClassName(metaEntity)}>"""
            RelationType.UNNOWN -> error("Не известный тип")
        }

        return """childrenMap[EntityName("${CollectName.syntheticClassName(metaEntity)}")] as $s"""

    }

    companion object {
        val nameClassEntityEnumGenerator = "DataDictionaryEntityConstructorMap"
    }

}

