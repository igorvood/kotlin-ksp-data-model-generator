package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IAggregate
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IEntitySynthetic
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator.Companion.entityOriginDataClassesGeneratorPackageName
import java.time.LocalDateTime
import java.util.*
import javax.annotation.processing.Generated

class SyntheticFieldExtractorsGenerator(
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



        val originClassName = entityClassName(metaEntity)
        val fullClassName = syntheticClassName(metaEntity)

        val simpleColumns = "override val origin: $originClassName"
        val s = """${IEntitySynthetic::class.java.simpleName}<$originClassName>"""


        val code = """package ${packageName.value}
                    
${
            metaEntity.comment?.let {
                """/**
*$it
*/
""".trimIndent()
            } ?: ""
        }          
import ${IEntitySynthetic::class.java.canonicalName}     
import ${EntityName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import ${rootPackage.value}.${entityOriginDataClassesGeneratorPackageName.value}.*

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@kotlinx.serialization.Serializable
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
            RelationType.ONE_TO_ONE_OPTIONAL -> "val ${toEntity.entityFieldName} : ${
                syntheticClassName(
                    toEntity
                )
            }$question"
            RelationType.MANY_TO_ONE -> "val ${toEntity.entityFieldName} : Set<${
                syntheticClassName(
                    toEntity
                )
            }>"
            RelationType.UNNOWN -> error("Не известный тип")
        }


    override val subPackage: PackageName
        get() = entitySyntheticDataClassesGeneratorPackageName

    companion object {
        val entitySyntheticDataClassesGeneratorPackageName = PackageName("runtime.dataclassesSynthetic")
    }
}