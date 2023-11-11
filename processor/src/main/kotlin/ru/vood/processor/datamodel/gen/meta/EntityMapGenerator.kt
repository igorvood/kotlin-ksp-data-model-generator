package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator.Companion.entityDataClassesGeneratorPackageName

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

                    .map {

                        """${EntityName::class.simpleName}("${it.shortName}") to ${EntityData::class.simpleName}(
                            |${it.modelClassName.value}::class, 
                            |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${CollectName.entityClassName(it)}::class,
                            |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${CollectName.entityClassName(it)}.serializer(),
                            |${EntityName::class.simpleName}("${it.shortName}"), 
                            |"${it.comment}",
                            |${it.flowEntityType}
                            |)""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
import kotlin.reflect.KClass
import kotlinx.serialization.KSerializer
import ${FlowEntityType::class.java.canonicalName}.*
import ${FlowEntityType::class.java.canonicalName}
import ${EntityData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}

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

