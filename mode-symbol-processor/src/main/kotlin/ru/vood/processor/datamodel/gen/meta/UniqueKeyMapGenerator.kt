package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.MetaUKs
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import java.time.LocalDateTime
import java.util.*
import javax.annotation.processing.Generated

class UniqueKeyMapGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger,

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

                                "${ukDto.name.value}" to """${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum}.${ukDto.name.value} to ${InterfaceGenerator.GeneratedClasses.UKEntityData}(
                                    |ukName = ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum}.${ukDto.name.value},
                                    |columns = listOf($ukCols),
                                    |serializer = ${ukClassName}.serializer(),
                                    |ukClass = ${ukClassName}::class,
                                    |entity = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaEnt.designClassShortName},
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

                    .sortedBy { it.first }
//                    .joinToString(",\n")

                val trimIndent =
                    """package ${packageName.value}
                        
import ${InterfaceGenerator.GeneratedClasses.UKEntityData.getPac(rootPackage)}
import ${TypeUk::class.java.canonicalName}.*
import ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum.getPac(rootPackage)}
import ${SimpleColumnName::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import ${MetaUKs::class.java.canonicalName}
${metaInfo.allEntityPackagesImport}


@${Generated::class.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@${MetaUKs::class.simpleName}
enum class ${uniqueKeyEnumName}{
${entities.joinToString(",\n") { it.first }};

companion object{
val uniqueKeyMap = EnumMap(mapOf(
${entities.joinToString(",\n") { it.second }}
)
)
}

}

"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }

    companion object {
        val uniqueKeyEnumGeneratorNameClass = "DataDictionaryUniqueKeyMap"
        val uniqueKeyEnumName = "UniqueKeyEnum"
    }

}

