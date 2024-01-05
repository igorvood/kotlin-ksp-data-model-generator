package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
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
        val syntheticFieldInfos1 = syntheticFieldInfos(chldrenEntities, metaForeignKeys, metaEntity, logger)

        val syntheticFieldInfos = syntheticFieldInfos1.filterIsInstance<SyntheticFieldInfo>()

        val syntheticFieldImport = syntheticFieldInfos
            .map { "import ${it.metaEntity.designClassPackageName}.${syntheticClassName(it.metaEntity)}" }
            .joinToString(separator = "\n")

        val fk = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> syntheticFieldInfos
                .map { syntheticFieldInfo ->
                    genField(syntheticFieldInfo)
                }
                .joinToString(",\n") { it }
            FlowEntityType.ONE_OF -> "override val origin: ${entityClassName(metaEntity)}"
        }

        val fkFunCode = syntheticFieldInfos
            .map { syntheticFieldInfo ->
                val genField = genWhenCondition(syntheticFieldInfo.metaEntity, syntheticFieldInfo.relationType)
                Optional.of(genField)
            }
            .joinToString("\n") { it.get() }


        val originClassName = entityClassName(metaEntity)
        val fullClassName = syntheticClassName(metaEntity)

        val simpleColumns = "override val origin: $originClassName"
        val s = """${InterfaceGenerator.GeneratedClasses.IEntityDetail}<$originClassName>"""
        val code = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> """${headCreate(metaEntity, syntheticFieldImport)}
data class $fullClassName (

$simpleColumns,

$fk

): $s         
{
    override fun syntheticField(entityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}): Set<${InterfaceGenerator.GeneratedClasses.IEntityDetail}<out ${InterfaceGenerator.GeneratedClasses.IEntityOrigin}>> {
       return when (entityName) {
                $fkFunCode
                else -> error("In Entity ${'$'}{designEntityName} Not found synthetic field for entity ${'$'}{entityName}")
            }
    }

    override val designEntityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}
        get() = designEntityNameConst

    companion object{
        val designEntityNameConst = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaEntity.designClassShortName}
    }
}
                    
                """.trimIndent()
            FlowEntityType.ONE_OF -> """${headCreate(metaEntity, syntheticFieldImport)}
data class $fullClassName(
override val origin: $originClassName
) 
: $s
{

 override fun syntheticField(entityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}): Set<${InterfaceGenerator.GeneratedClasses.IEntityDetail}<out ${InterfaceGenerator.GeneratedClasses.IEntityOrigin}>> {
          return  when (entityName) {
                else -> error("In Entity ${'$'}{designEntityName} Not found synthetic field for entity ${'$'}{entityName}")
            }
    }
    
override val designEntityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}
    get() = designEntityNameConst
 companion object{
        val designEntityNameConst = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaEntity.designClassShortName}
    }
}  
""".trimIndent()
        }



        logger.info("Create $fullClassName")
        val map = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()

        val plus = collector.plus(
            GeneratedFile(
                FileName(fullClassName),
                GeneratedCode(code),
                PackageName(metaEntity.designClassPackageName)
            )
        ).plus(map)


        return plus
    }

    private fun headCreate(
        metaEntity: MetaEntity,
        syntheticFieldImport: String
    ) = """package ${metaEntity.designClassPackageName}
                        
    ${
        metaEntity.comment?.let {
            """/**
    *$it
    */
    """.trimIndent()
        } ?: ""
    }          
    import ${InterfaceGenerator.GeneratedClasses.IEntityDetail.getPac(rootPackage)}     
    import ${Generated::class.java.canonicalName}
    import ${InterfaceGenerator.GeneratedClasses.IEntityOrigin.getPac(rootPackage)}
    import ${InterfaceGenerator.GeneratedClasses.EntityEnum.getPac(rootPackage)}
    
    ${syntheticFieldImport}
    
    @Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
    @kotlinx.serialization.Serializable"""

    private fun genField(syntheticFieldInfo: SyntheticFieldInfo): String {
        val toEntity = syntheticFieldInfo.metaEntity
        val syntheticClassName = syntheticClassName(
            toEntity
        )
        return when (syntheticFieldInfo.relationType) {
            RelationType.ONE_TO_ONE_OPTIONAL -> "val ${toEntity.entityFieldName} : $syntheticClassName?"
            RelationType.ONE_TO_ONE_MANDATORY -> "val ${toEntity.entityFieldName} : $syntheticClassName"
            RelationType.MANY_TO_ONE -> "val ${toEntity.entityFieldName} : Set<$syntheticClassName>"

        }
    }

    private fun genWhenCondition(toEntity: MetaEntity, relationType: RelationType) =
        when (relationType) {
            RelationType.ONE_TO_ONE_OPTIONAL ->
                """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> ${toEntity.entityFieldName}?.let { setOf(it) } ?: setOf()"""
            RelationType.ONE_TO_ONE_MANDATORY ->
                """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> setOf(${toEntity.entityFieldName})"""

            RelationType.MANY_TO_ONE -> """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> ${toEntity.entityFieldName}"""
        }


    override val subPackage: PackageName
        get() = entitySyntheticDataClassesGeneratorPackageName

    companion object {
        val entitySyntheticDataClassesGeneratorPackageName = PackageName("runtime.dataclassesSynthetic")
    }
}