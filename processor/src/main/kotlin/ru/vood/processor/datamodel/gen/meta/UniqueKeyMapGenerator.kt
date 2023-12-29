package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.newIntf.FKMetaData
import ru.vood.dmgen.intf.newIntf.TypeUk
import ru.vood.dmgen.intf.newIntf.UKEntityData
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.ContextDataClassesGenerator.Companion.contextDataClassesGeneratorPackageName
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class UniqueKeyMapGenerator(
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
                                    ukDto.cols.map { columnName -> """${SimpleColumnName::class.simpleName}("${metaEnt.designClassShortName}_${columnName.value}")""" }
                                        .sorted()
                                        .joinToString(",")
                                val constructorParams = ukDto.cols.map { columnName -> """data.${columnName.value}""" }
                                    .sorted()
                                    .joinToString(",")

                                val ukClassName = CollectName.ukClassName(ukDto.name)

                                """${UkName::class.simpleName}("${ukDto.name.value}") to ${UKEntityData::class.simpleName}(
                                    |${UKEntityData<*>::ukName.name} = ${UkName::class.simpleName}("${ukDto.name.value}"),
                                    |${UKEntityData<*>::columns.name} = listOf($ukCols),
                                    |serializer = ${ukClassName}.serializer(),
                                    |${UKEntityData<*>::ukClass.name} = ${ukClassName}::class,
                                    |${UKEntityData<*>::entity.name} = ${EntityName::class.simpleName}("${metaEnt.designClassShortName}"),
                                    |${UKEntityData<*>::extractContext.name} = {data: ${CollectName.entityClassName(metaEnt)} -> ${
                                    CollectName.ukClassName(
                                        ukDto.name
                                    )
                                }($constructorParams) },
                                    |${UKEntityData<*>::typeUk.name} = ${ukDto.typeUk.name}
                                    |)""".trimMargin()
                            }
                    }

                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${UKEntityData::class.java.canonicalName}
import ${TypeUk::class.java.canonicalName}.*
import ${UkName::class.java.canonicalName}
import ${SimpleColumnName::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
${metaInfo.allEntityPackagesImport}


@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
val uniqueKeyMap = mapOf(
$entities

)


"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val uniqueKeyEnumGeneratorNameClass = "DataDictionaryUniqueKeyMap"
    }

}

