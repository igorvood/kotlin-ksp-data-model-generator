package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.gen.meta.ColumnEntityMapGenerator.Companion.fullColumnEnumName
import ru.vood.processor.datamodel.gen.meta.UniqueKeyMapGenerator.Companion.uniqueKeyEnumName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import java.time.LocalDateTime
import java.util.*
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

                            """${InterfaceGenerator.GeneratedClasses.FkPair}(${fullColumnEnumName}.${metaForeign.fromEntity.designClassShortName}_${fkPa.from.name.value}, ${fullColumnEnumName}.${metaForeign.toEntity.designClassShortName}_${fkPa.to.name.value})"""
                        }.joinToString(",\n")

                        val contextCols = metaForeign.fkCols.map { fkPa ->

                            """data.${fkPa.from.name.value}"""
                        }.joinToString(",")

                        metaForeign.name.value to """${fkEnumName}.${metaForeign.name.value} to ${InterfaceGenerator.GeneratedClasses.FKMetaData}<${
                            entityClassName(
                                metaForeign.fromEntity
                            )
                        }>(
                        |fromEntity = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaForeign.fromEntity.designClassShortName},
                        |toEntity = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaForeign.toEntity.designClassShortName},
                        |uk = ${uniqueKeyEnumName}.${metaForeign.uk.name.value},
                        |relationType = ${RelationType::class.java.canonicalName}.${metaForeign.relationType.name},
                        |fkCols = setOf($fkCols),
                        |сontextExtractor = {data: ${entityClassName(metaForeign.fromEntity)} -> ${
                            ukClassName(
                                metaForeign.uk.name
                            )
                        }(${contextCols}) }
                        |)""".trimMargin()
                    }
                    .sortedBy { it.first }
//                    .joinToString(",\n")


                val trimIndent =
                    """package ${packageName.value}
                        
import ${InterfaceGenerator.GeneratedClasses.FKMetaData.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.FkPair.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum.getPac(rootPackage)}
import ${Generated::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}

${metaInfo.allEntityPackagesImport}



@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
enum class ${fkEnumName}{
${entitiesMap.joinToString(",\n") { it.first }};

companion object{
val foreignKeyMap = EnumMap(mapOf(
${entitiesMap.joinToString(",\n") { it.second }}
)
)
}

}

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName(nameClass), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val foreignKeyEnumGeneratorNameClass = "DataDictionaryForeignKeyMap"
        val fkEnumName = "FkNameEnum"
    }
}
