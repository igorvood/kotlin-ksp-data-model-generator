package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.IMetaColumnEntity
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class ColumnEntityEnumGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = columnEntityEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entities = generatedClassData
                    .flatMap { ent ->
                        ent.fields
                            .map { f ->
                                """${ent.designClassShortName}_${f.name.value}(
                                |${ent.designClassShortName},
                                |${ent.designClassFullClassName.value}::${f.name.value},
                                |${SimpleColumnName::class.simpleName}("${f.name.value}"),
                                |"${f.comment}"
                                |)""".trimMargin()
                            }
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*                        
import kotlin.reflect.KProperty1
import ${SimpleColumnName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
enum class $nameClass(
    override val entity: ${IMetaEntity::class.java.canonicalName},
    override val kProperty1: KProperty1<*, *>,
    override val columnName: ${SimpleColumnName::class.simpleName},
    override val comment: String,
): ${IMetaColumnEntity::class.java.canonicalName} {
$entities
}
"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val columnEntityEnumGeneratorNameClass = "DataDictionaryColumnEntityEnum"
    }
}

