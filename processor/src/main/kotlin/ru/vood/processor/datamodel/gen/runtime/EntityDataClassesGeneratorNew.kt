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
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import java.util.*

class EntityDataClassesGeneratorNew(
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

        val childEntitiesSet = aggregateInnerDep.children.asSequence().map { it.metaEntity }.toSet()
        val fkColumn = childEntitiesSet
            .map { metaEntityFrom ->
                when (val fet = metaEntityFrom.flowEntityType) {
                    FlowEntityType.AGGREGATE -> Optional.empty<SyntheticFieldInfo>()
                    FlowEntityType.INNER_MANDATORY, FlowEntityType.INNER_OPTIONAL -> {
                        val currentFks =
                            metaForeignKeys.filter { fk -> fk.toEntity == metaEntityFrom && fk.fromEntity == metaEntityFrom }
                        val metaForeignKey =
                            if (currentFks.size == 1) currentFks[0] else error("Found several fk from entity ${metaEntityFrom.designClassFullClassName.value} to ${metaEntityFrom.designClassFullClassName.value}  ")
                        val isOptional = if (fet.isOptional) "?" else ""


                        Optional.empty<SyntheticFieldInfo>()

//                        val genField = genField(metaEntity, isOptional, metaForeignKey.relationType)
//                        Optional.of(genField)
                    }
                }
            }
            .filter { !it.isEmpty }
            .map { it.get() }
            .map { syntheticFieldInfo ->
                "genField(syntheticFieldInfo.metaEntity, syntheticFieldInfo.isOptional, syntheticFieldInfo.relationType)"
            }
            .joinToString(",\n")


//        val fk: String = foreignKeyProcessor(metaEntity, foreignKeyMap)

        val dataClass = metaEntity.designClassShortName

        val columns = metaEntity.fields.sortedBy { it.position }
        val simpleColumn = columns.map { col ->
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
$simpleColumn,
$fkColumn

): $s         
{
    override fun ktSerializer() = serializer()
    
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("${dataClass}")
    
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
            RelationType.ONE_TO_ONE_OPTIONAL -> "val ${toEntity.entityFieldName} : ${packageName.value}.${entityClassName(toEntity)}$question"
            RelationType.MANY_TO_ONE -> "val ${toEntity.entityFieldName} : Set<${packageName.value}.${entityClassName(toEntity)}>"
            RelationType.UNNOWN -> error("Не известный тип")
        }


    override val subPackage: PackageName
        get() = entityDataClassesGeneratorPackageName

    companion object {
        val entityDataClassesGeneratorPackageName = PackageName("runtime.dataclasses")
    }
}