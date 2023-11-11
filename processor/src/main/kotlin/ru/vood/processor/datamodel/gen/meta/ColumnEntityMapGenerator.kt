package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.intf.ColumnName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.newIntf.ColumnEntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator.Companion.entityDataClassesGeneratorPackageName

class ColumnEntityMapGenerator(
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
                                """${ColumnName::class.simpleName}("${ent.designClassShortName}_${f.name.value}") to ${ColumnEntityData::class.simpleName}(
                                |    ${EntityName::class.java.canonicalName}( "${ent.designClassShortName}"),
                                |${rootPackage.value}.${entityDataClassesGeneratorPackageName.value}.${CollectName.entityClassName(ent)}::${f.name.value},
                                |${ColumnName::class.simpleName}("${f.name.value}"),
                                |"${f.comment}"
                                |)""".trimMargin()


//                            """${ent.shortName}_${f.name.value}(
//                                |${ent.shortName},
//                                |${ent.kotlinMetaClass.canonicalName}::${f.name.value},
//                                |${ColumnName::class.java.canonicalName}("${ent.shortName}"),
//                                |"${f.comment}"
//                                |)""".trimMargin()
                            }
                    }
                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
import ${ColumnEntityData::class.java.canonicalName}
import ${ColumnName::class.java.canonicalName}
import kotlin.reflect.KProperty1


val columnEntityDataMap = mapOf(
$entities

)

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val columnEntityEnumGeneratorNameClass = "DataDictionaryColumnEntityMap"
    }
}

