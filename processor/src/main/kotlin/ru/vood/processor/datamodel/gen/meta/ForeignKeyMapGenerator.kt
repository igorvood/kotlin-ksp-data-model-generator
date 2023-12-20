package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.FkPair
import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.newIntf.FKMetaData
import ru.vood.dmgen.intf.newIntf.FkPairNew
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.gen.meta.ColumnEntityEnumGenerator.Companion.columnEntityEnumGeneratorNameClass
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator.Companion.contextDataClassesGeneratorPackageName
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
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
//                        "${ent.shortName}_${f.name.value}"
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
                        |${EntityName::class.simpleName}("${metaForeign.fromEntity.designClassShortName}"),
                        |${EntityName::class.simpleName}("${metaForeign.toEntity.designClassShortName}"),
                        |${UkName::class.simpleName}("${metaForeign.uk.name.value}"),
                        |${RelationType::class.java.canonicalName}.${metaForeign.relationType.name},
                        |setOf($fkCols),
                        |{data: ${entityClassName(metaForeign.fromEntity)} ->
                        |//Json.encodeToString(${
                            ukClassName(
                                metaForeign.uk.name
                            )
                        }.serializer(),${ukClassName(metaForeign.uk.name)}(${contextCols}))
                        |${ukClassName(metaForeign.uk.name)}(${contextCols})
                        |}
                        |)""".trimMargin()
                    }
                    .sorted()
                    .joinToString(",\n")

//                data class FKEntityData<T : IEntity<T>>(
//                    override val fromEntity: IMetaUkEntityNew<T>,
//                    override val toEntity: IMetaUkEntityNew<T>,
//                    override val uk: IMetaUkEntityNew<T>,
//                    override val relationType: RelationType,
//                    override val fkCols: Set<FkPair>
////    override val contextOfClass: KClass<IContextOf<T>>
//                ) : IMetaFkEntityNew<T> {


                val trimIndent =
                    """package ${packageName.value}
                        
import kotlinx.serialization.json.Json                        
//import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
//import ${packageName.value}.${UniqueKeyEnumGenerator.uniqueKeyEnumGeneratorNameClass}.*
import ${FkPair::class.java.canonicalName}
import ${FkName::class.java.canonicalName}
import ${FKMetaData::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${FkPairNew::class.java.canonicalName}
import ${SimpleColumnName::class.java.canonicalName}
import ${UkName::class.java.canonicalName}
//import ${packageName.value}.${columnEntityEnumGeneratorNameClass}.*
//import ${rootPackage.value}.${entityOriginDataClassesGeneratorPackageName.value}.*
//import ${rootPackage.value}.${contextDataClassesGeneratorPackageName.value}.*
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
