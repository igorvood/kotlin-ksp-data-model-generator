package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
import ru.vood.processor.datamodel.gen.runtime.SyntheticFieldExtractorsGenerator.Companion.entitySyntheticDataClassesGeneratorPackageName
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class EntityMapGenerator(
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

                    .map {metaEntity                        ->

                        val notSealedEntity = """${EntityData::class.simpleName}(
                            |${metaEntity.designClassFullClassName.value}::class, 
                            |${CollectName.entityClassName(metaEntity)}::class,
                            |${CollectName.syntheticClassName(metaEntity)}::class,
                            |${CollectName.entityClassName(metaEntity)}.serializer(),
                            |${CollectName.syntheticClassName(metaEntity)}.serializer(),
                            |${EntityName::class.simpleName}("${metaEntity.designClassShortName}"), 
                            |"${metaEntity.comment}",
                            |${metaEntity.flowEntityType}
                            |//${metaEntity.sealedChildren} ${metaEntity.ksAnnotated.superTypes.map { ass-> ass.element.toString() }}
                            |)"""

                        val entity = if (metaEntity.isSealedObject) """""" else notSealedEntity

                        """${EntityName::class.simpleName}("${metaEntity.designClassShortName}") to $entity""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}

import ${FlowEntityType::class.java.canonicalName}.*
import ${EntityData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
${metaInfo.allEntityPackagesImport}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
val entityDataMap = mapOf(
$entities

)




"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val nameClassEntityEnumGenerator = "DataDictionaryEntityMap"
    }

}

