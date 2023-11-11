package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.intf.IMetaColumnEntity
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.dmgen.intf.IMetaUkEntity
import ru.vood.dmgen.intf.newIntf.TypeUk
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.meta.EntityEnumGenerator.Companion.nameClassEntityEnumGenerator
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator.Companion.contextDataClassesGeneratorPackageName

class UniqueKeyEnumGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = uniqueKeyEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData
                    .flatMap { metaEnt ->
                        metaEnt.uniqueKeysFields.keys
                            .map { ukDto ->
                                val ukCols =
                                    ukDto.cols.map { columnName -> "${metaEnt.shortName}_${columnName.value}" }
                                        .sorted()
                                        .joinToString(",")
                                """${ukDto.name.value}(
                                    |setOf($ukCols),
                                    |${packageName.value}.${nameClassEntityEnumGenerator}.${metaEnt.shortName},
                                    |${rootPackage.value}.${contextDataClassesGeneratorPackageName.value}.${CollectName.ukClassName(metaEnt, ukDto.name)}::class,
                                    |${ukDto.typeUk.name},
                                    |)""".trimMargin()

                            }
                    }

                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${ColumnEntityEnumGenerator.columnEntityEnumGeneratorNameClass}.*
import ${TypeUk::class.java.canonicalName}.*
import ${TypeUk::class.java.canonicalName}

import kotlin.reflect.KClass

enum class $nameClass(
    override val columns: Set<${IMetaColumnEntity::class.java.canonicalName}>,
    override val entity : ${IMetaEntity::class.java.canonicalName},
    override val contextOfClass: KClass<*>, 
    override val typeUk: TypeUk
): ${IMetaUkEntity::class.java.canonicalName}{
$entities
}
"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val uniqueKeyEnumGeneratorNameClass = "DataDictionaryUniqueKeyEnum"
    }

}

