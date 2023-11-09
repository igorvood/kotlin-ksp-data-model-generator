package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.IAggregate
import ru.vood.dmgen.intf.IEntity
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import java.util.*

class EntityDataClassesGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger
) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        return collectEntityFile(metaInfo.metaForeignKeys, metaInfo.aggregateInnerDep())
    }

    private fun collectEntityFile(metaForeignKeys: Set<MetaForeignKey>, aggregateInnerDep: Dependency, collector:Set<GeneratedFile> = setOf() ): Set<GeneratedFile> {

        val metaEntity = aggregateInnerDep.metaEntity

        val fk = aggregateInnerDep.children
            .map { child ->
                when (val fet = child.metaEntity.flowEntityType) {
                    FlowEntityType.AGGREGATE -> Optional.empty<String>()
                    FlowEntityType.INNER_MANDATORY, FlowEntityType.INNER_OPTIONAL -> {
                        val currentFks =
                            metaForeignKeys.filter { fk -> fk.toEntity == metaEntity && fk.fromEntity == child.metaEntity }
                        val metaForeignKey =
                            if (currentFks.size == 1) currentFks[0] else error("Found several fk from entity ${child.metaEntity.modelClassName.value} to   ${metaEntity.modelClassName.value}  ")


                        val s = if (fet.isOptional) "?" else ""
                        val genField = genField(child.metaEntity, s, metaForeignKey.relationType)
                        Optional.of(genField)
                    }

                }
            }
            .filter{!it.isEmpty}
            .map { it.get() }
            .joinToString(",\n")


//        val fk: String = foreignKeyProcessor(metaEntity, foreignKeyMap)

        val dataClass = metaEntity.shortName

        val columns = metaEntity.fields.sortedBy { it.position }

        val joinToString = columns.map { col ->
            val kotlinMetaClass = col.type

            val nullableSymbol = if (col.isNullable) "?" else ""
            """${
                col.comment?.let {
                    """/**
*$it
*/
""".trimIndent()
                } ?: ""
            }     
override val ${col.name.value}: $kotlinMetaClass$nullableSymbol""".trimIndent()
        }
            .joinToString(",\n")

        val fullClassName = """${dataClass}Entity"""
        val s = when (metaEntity.flowEntityType) {
            FlowEntityType.AGGREGATE -> """${IAggregate::class.java.canonicalName}<$fullClassName>, ${metaEntity.modelClassName.value}"""
            FlowEntityType.INNER_OPTIONAL, FlowEntityType.INNER_MANDATORY -> """${IEntity::class.java.canonicalName}<$fullClassName>, ${metaEntity.modelClassName.value}"""
        }

        val code = """package ${packageName.value}
                    
${
            metaEntity.comment?.let {
                """/**
*$it
*/
""".trimIndent()
            } ?: ""
        }                    
@kotlinx.serialization.Serializable
//@optics([OpticsTarget.LENS])
data class $fullClassName (
$joinToString,
$fk

): $s         
{
    override fun ktSerializer() = serializer()
    
//    companion object
}
                    
                """.trimIndent()

        logger.info("Create $fullClassName")
        val map = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()

        val plus = collector.plus(GeneratedFile(FileName(fullClassName), GeneratedCode(code), packageName)).plus(map)


        return plus
    }

    enum class Relation {
        MANDATORY,
        OPTIONAL
    }
    private fun genField(toEntity: MetaEntity, question: String, relationType: RelationType) =
        when (relationType) {
            RelationType.ONE_TO_ONE_OPTIONAL -> "val ${toEntity.entityFieldName} : ${packageName.value}.${toEntity.shortName}Entity$question"
            RelationType.MANY_TO_ONE -> "val ${toEntity.entityFieldName} : Set<${packageName.value}.${toEntity.shortName}Entity>"
            RelationType.UNNOWN -> error("Не известный тип")
        }

    override val subPackage: PackageName
        get() = entityDataClassesGeneratorPackageName

    companion object {
        val entityDataClassesGeneratorPackageName = PackageName("runtime.dataclasses")
    }
}