package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
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

                    .map {

                        """${EntityName::class.simpleName}("${it.designClassShortName}") to ${EntityData::class.simpleName}(
                            |${it.designClassFullClassName.value}::class, 
                            |${
                            CollectName.entityClassName(
                                it
                            )
                        }::class,
                            |${
                            CollectName.entityClassName(
                                it
                            )
                        }.serializer(),
                            |${EntityName::class.simpleName}("${it.designClassShortName}"), 
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
import ${Generated::class.java.canonicalName}
import ${rootPackage.value}.${entityOriginDataClassesGeneratorPackageName.value}.*

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

