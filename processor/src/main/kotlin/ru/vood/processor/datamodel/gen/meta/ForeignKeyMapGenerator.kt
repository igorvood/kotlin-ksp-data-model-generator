package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.newIntf.FKMetaData
import ru.vood.dmgen.intf.newIntf.FkPairNew
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class ForeignKeyMapGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = foreignKeyEnumGeneratorNameClass

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.metaForeignKeys.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val entitiesMap = generatedClassData
                    .map { metaForeign ->
                        val fkCols = metaForeign.fkCols.map { fkPa ->

                            """${FkPairNew::class.simpleName}(${FullColumnName::class.simpleName}("${metaForeign.fromEntity.designClassShortName}_${fkPa.from.name.value}"), ${FullColumnName::class.simpleName}("${metaForeign.toEntity.designClassShortName}_${fkPa.to.name.value}"))"""
                        }.joinToString(",\n")

                        val contextCols = metaForeign.fkCols.map { fkPa ->

                            """data.${fkPa.from.name.value}"""
                        }.joinToString(",")

                        """${FkName::class.simpleName}("${metaForeign.name.value}") to ${FKMetaData::class.simpleName}<${
                            entityClassName(
                                metaForeign.fromEntity
                            )
                        }>(
                        |${FKMetaData<*>::fromEntity.name} = ${EntityName::class.simpleName}("${metaForeign.fromEntity.designClassShortName}"),
                        |${FKMetaData<*>::toEntity.name} = ${EntityName::class.simpleName}("${metaForeign.toEntity.designClassShortName}"),
                        |${FKMetaData<*>::uk.name} = ${UkName::class.simpleName}("${metaForeign.uk.name.value}"),
                        |${FKMetaData<*>::relationType.name} = ${RelationType::class.java.canonicalName}.${metaForeign.relationType.name},
                        |${FKMetaData<*>::fkCols.name} = setOf($fkCols),
                        |${FKMetaData<*>::сontextExtractor.name} = {data: ${entityClassName(metaForeign.fromEntity)} -> ${
                            ukClassName(
                                metaForeign.uk.name
                            )
                        }(${contextCols}) }
                        |)""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")


                val trimIndent =
                    """package ${packageName.value}
                        
import ${FkName::class.java.canonicalName}
import ${FKMetaData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${FkPairNew::class.java.canonicalName}
import ${UkName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import ${FullColumnName::class.java.canonicalName}
${metaInfo.allEntityPackagesImport}



@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
val foreignKeyMap = mapOf(
$entitiesMap
)

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName(nameClass), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val foreignKeyEnumGeneratorNameClass = "DataDictionaryForeignKeyMap"
    }
}
