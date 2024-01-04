package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.intf.SimpleColumnName

import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.dmgen.annotation.TypeUk
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
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

                                """${UkName::class.simpleName}("${ukDto.name.value}") to ${InterfaceGenerator.GeneratedClasses.UKEntityData}(
                                    |ukName = ${UkName::class.simpleName}("${ukDto.name.value}"),
                                    |columns = listOf($ukCols),
                                    |serializer = ${ukClassName}.serializer(),
                                    |ukClass = ${ukClassName}::class,
                                    |entity = ${EntityName::class.simpleName}("${metaEnt.designClassShortName}"),
                                    |extractContext = {data: ${
                                    CollectName.entityClassName(
                                        metaEnt
                                    )
                                } -> ${
                                    CollectName.ukClassName(
                                        ukDto.name
                                    )
                                }($constructorParams) },
                                    |typeUk = ${ukDto.typeUk.name}
                                    |)""".trimMargin()
                            }
                    }

                    .sorted()
                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${InterfaceGenerator.GeneratedClasses.UKEntityData.getPac(rootPackage)}
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

