package ru.vood.processor.datamodel.gen

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator.Companion.entityDataClassesGeneratorPackageName

class EntityEnumGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger
) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = nameClassEntityEnumGenerator

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val values = metaInfo.entities.values.toSet()
        return when (values.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = values
                    .map {me ->
                        """${me.shortName}(${me.modelClassName.value}::class, 
                        |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${me.shortName}Entity::class,
                        |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${me.shortName}Entity.serializer(),
                        |${EntityName::class.java.canonicalName}("${me.shortName}"), 
                        |"${me.comment}",
                        |${me.flowEntityType}
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


enum class $nameClass(
override val designClass: KClass<out Any>,
override val runtimeClass: KClass<out ${IEntity::class.java.canonicalName}<*>>,
override val serializer: KSerializer<out ${IEntity::class.java.canonicalName}<*>>,
override val entityName: ${EntityName::class.java.canonicalName},
override val comment: String,
override val entityType: FlowEntityType

): ${IMetaEntity::class.java.canonicalName} {
$entities;

@Suppress("UNCHECKED_CAST")
inline fun <reified T> entitySerializer(): KSerializer<T> = this.serializer as KSerializer<T> 
}
"""

                logger.info("Create file class $nameClass $packageName")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val nameClassEntityEnumGenerator = "DataDictionaryEntityEnum"
    }

}

