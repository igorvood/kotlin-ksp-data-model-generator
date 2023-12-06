package ru.vood.processor.datamodel.gen.meta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.dmgen.intf.IMetaFkEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import java.time.LocalDateTime
import javax.annotation.processing.Generated

@Deprecated("удалить")
class DependencyGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractDataDictionaryGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override val nameClass: String
        get() = "Dependency"

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()
        return when (generatedClassData.isEmpty()) {
            true -> setOf()
            false -> {
                val trimIndent =
                    """package ${packageName.value}
                        
import ${packageName.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.*
import ${packageName.value}.${ForeignKeyEnumGenerator.foreignKeyEnumGeneratorNameClass}.*
import ${Generated::class.java.canonicalName}
import ${FlowEntityType::class.java.canonicalName}.*

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
object Dependency {

    val entityDependency : Map<${IMetaEntity::class.java.canonicalName}, Set<MetaDependency>> = collectDependency(${EntityEnumGenerator.nameClassEntityEnumGenerator}.values().toList(), ${ForeignKeyEnumGenerator.foreignKeyEnumGeneratorNameClass}.values().toList())

    val entityDependencyAggregateOnly = entityDependency
        .filter { qw -> qw.key.entityType == AGGREGATE }
        .map { it.key to it.value.filter { q -> q.toEntity.entityType == AGGREGATE }.toSet() }
        .toMap()


    private fun collectDependency(
        entities: List<${IMetaEntity::class.java.canonicalName}>,
        foreignKey: List<${IMetaFkEntity::class.java.canonicalName}>
    ): Map<${IMetaEntity::class.java.canonicalName}, Set<MetaDependency>> {

        tailrec fun recursiveCollectDependency(
            values: List<${IMetaFkEntity::class.java.canonicalName}>,
            collector: Map<${IMetaEntity::class.java.canonicalName}, Set<MetaDependency>>
        ): Map<${IMetaEntity::class.java.canonicalName}, Set<MetaDependency>> {
            return when (values.isEmpty()) {
                true -> collector
                false -> {
                    val dataDictionaryForeignKeyEnum = values[0]
                    val let = collector[dataDictionaryForeignKeyEnum.fromEntity]?.plus(
                        MetaDependency(dataDictionaryForeignKeyEnum.toEntity)
                    )
                        ?: setOf(MetaDependency(dataDictionaryForeignKeyEnum.toEntity))

                    val plus = collector.plus(dataDictionaryForeignKeyEnum.fromEntity to let)

                    val values1 = values.drop(1)
                    recursiveCollectDependency(values1, plus)
                }
            }
        }
        return recursiveCollectDependency(foreignKey, entities.associateWith { setOf() })
    }
}

data class MetaDependency(val toEntity: ${IMetaEntity::class.java.canonicalName})
"""
                logger.info("Create $nameClass")
                setOf(GeneratedFile(FileName("$nameClass"), GeneratedCode(trimIndent), packageName))
            }
        }


    }
}

