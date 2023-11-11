package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IAggregate
import ru.vood.dmgen.intf.IEntity
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import java.util.*

class EntityDataClassesGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger
) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        return collectEntityFile(metaInfo.metaForeignKeys, metaInfo.aggregateInnerDep())
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<GeneratedFile> = setOf()
    ): Set<GeneratedFile> {

        val metaEntity = aggregateInnerDep.metaEntity

        val chldrenEntities = aggregateInnerDep.children.map { it.metaEntity }
        val fk = syntheticFieldInfos(chldrenEntities, metaForeignKeys, metaEntity, logger)
            .map { syntheticFieldInfo ->
                val s = if (syntheticFieldInfo.isOptional) "?" else ""
                val genField = genField(syntheticFieldInfo.metaEntity, s, syntheticFieldInfo.relationType)
                Optional.of(genField)

            }
            .joinToString(",\n") { it.get() }

        val simpleColumns = metaEntity.fields
            .sortedBy { it.position }
            .map { col ->
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

        val fullClassName = entityClassName(metaEntity)
        val s = when (metaEntity.flowEntityType) {
            FlowEntityType.AGGREGATE -> """${IAggregate::class.java.canonicalName}<$fullClassName>, ${metaEntity.designClassFullClassName.value}"""
            FlowEntityType.INNER_OPTIONAL, FlowEntityType.INNER_MANDATORY -> """${IEntity::class.java.canonicalName}<$fullClassName>, ${metaEntity.designClassFullClassName.value}"""
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
import ${EntityName::class.java.canonicalName}                  
                  
@kotlinx.serialization.Serializable
//@optics([OpticsTarget.LENS])
data class $fullClassName (
$simpleColumns,
$fk

): $s         
{
    override fun ktSerializer() = serializer()
    
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("${metaEntity.designClassShortName}")
    
    }
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
            RelationType.ONE_TO_ONE_OPTIONAL -> "val ${toEntity.entityFieldName} : ${packageName.value}.${
                entityClassName(
                    toEntity
                )
            }$question"
            RelationType.MANY_TO_ONE -> "val ${toEntity.entityFieldName} : Set<${packageName.value}.${
                entityClassName(
                    toEntity
                )
            }>"
            RelationType.UNNOWN -> error("Не известный тип")
        }


    override val subPackage: PackageName
        get() = entityDataClassesGeneratorPackageName

    companion object {
        val entityDataClassesGeneratorPackageName = PackageName("runtime.dataclasses")
    }
}