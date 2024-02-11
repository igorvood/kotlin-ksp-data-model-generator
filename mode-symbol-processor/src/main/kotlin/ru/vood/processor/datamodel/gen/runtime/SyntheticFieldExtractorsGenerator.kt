package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.ModelEntityDetail
import ru.vood.dmgen.dto.RelationType
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.model.generator.ksp.common.util.import
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
    logger: KSPLogger,
) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        return collectEntityFile(metaInfo.metaForeignKeys, metaInfo.aggregateInnerDep)
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<GeneratedFile> = setOf(),
    ): Set<GeneratedFile> {

        val metaEntity = aggregateInnerDep.metaEntity

        val chldrenEntities = aggregateInnerDep.children.map { it.metaEntity }
        val syntheticFieldInfos1 = syntheticFieldInfos(chldrenEntities, metaForeignKeys, metaEntity)

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

        val fkFunCodeOptional = extractSyntheticByrelationType(syntheticFieldInfos, RelationType.ONE_TO_ONE_OPTIONAL)
        val fkFunCodeMandatory = extractSyntheticByrelationType(syntheticFieldInfos, RelationType.ONE_TO_ONE_MANDATORY)
        val fkFunCodeSet = extractSyntheticByrelationType(syntheticFieldInfos, RelationType.MANY_TO_ONE)


        val originClassName = entityClassName(metaEntity)
        val fullClassName = syntheticClassName(metaEntity)

        val simpleColumns = "override val origin: $originClassName"
        val s = """${iEntityDetail.simpleName}<$originClassName>"""
        val code = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> """${headCreate(metaEntity, syntheticFieldImport)}
data class $fullClassName (

$simpleColumns,

$fk

): $s         
{
     override fun syntheticFieldOptional(entityName:  ${InterfaceGenerator.GeneratedClasses.EntityEnum}): ${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}>? = 
     when (entityName) {
                $fkFunCodeOptional
                else -> error("In Entity ${'$'}{designEntityName} Not found optional synthetic field for entity ${'$'}{entityName}")
            }

     override fun syntheticFieldMandatory(entityName:  ${InterfaceGenerator.GeneratedClasses.EntityEnum}): ${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}> = 
     when (entityName) {
                $fkFunCodeMandatory
                else -> error("In Entity ${'$'}{designEntityName} Not found mandatory synthetic field for entity ${'$'}{entityName}")
            }

     override fun syntheticFieldSet(entityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}): Set<${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}>> = 
     when (entityName) {
                $fkFunCodeSet
                else -> error("In Entity ${'$'}{designEntityName} Not found mandatory synthetic field for entity ${'$'}{entityName}")
            }


    override val designEntityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}
        get() = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.${metaEntity.designClassShortName}

}
                    
                """.trimIndent()
            FlowEntityType.ONE_OF -> """${headCreate(metaEntity, syntheticFieldImport)}
data class $fullClassName(
override val origin: $originClassName
) 
: $s
{

  override fun syntheticFieldOptional(entityName:  ${InterfaceGenerator.GeneratedClasses.EntityEnum}): ${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}>? {
        TODO("Not yet implemented")
    }   

      override fun syntheticFieldMandatory(entityName:  ${InterfaceGenerator.GeneratedClasses.EntityEnum}): ${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}> {
        TODO("Not yet implemented")
    }   

    override fun syntheticFieldSet(entityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}): Set<${iEntityDetail.simpleName}<out ${iEntityOrigin.simpleName}>> {
        TODO("Not yet implemented")
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

    private fun extractSyntheticByrelationType(
        syntheticFieldInfos: List<SyntheticFieldInfo>,
        relationTypeFilter: RelationType,
    ) = syntheticFieldInfos
        .filter {
            it.relationType == relationTypeFilter
        }
        .map { syntheticFieldInfo ->
            val genField = genWhenConditionNew(syntheticFieldInfo.metaEntity, syntheticFieldInfo.relationType)
            Optional.of(genField)
        }
        .joinToString("\n") { it.get() }

    private fun headCreate(
        metaEntity: MetaEntity,
        syntheticFieldImport: String,
    ) = """package ${metaEntity.designClassPackageName}
                        
    ${
        metaEntity.comment?.let {
            """/**
    *$it
    */
    """.trimIndent()
        } ?: ""
    }          
    ${iEntityDetail.import()}     
    import ${Generated::class.java.canonicalName}
    import ${ModelEntityDetail::class.java.canonicalName}
    ${iEntityOrigin.import()}
    import ${InterfaceGenerator.GeneratedClasses.EntityEnum.getPac(rootPackage)}
    
    ${syntheticFieldImport}
    
    @${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
    @${ModelEntityDetail::class.java.simpleName}
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

    private fun genWhenConditionNew(toEntity: MetaEntity, relationType: RelationType) =
        when (relationType) {
            RelationType.ONE_TO_ONE_OPTIONAL ->
                """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> ${toEntity.entityFieldName}"""
            RelationType.ONE_TO_ONE_MANDATORY ->
                """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> ${toEntity.entityFieldName}"""
            RelationType.MANY_TO_ONE -> """${InterfaceGenerator.GeneratedClasses.EntityEnum}.${toEntity.designClassShortName} -> ${toEntity.entityFieldName}"""
        }


    override val subPackage: PackageName
        get() = entitySyntheticDataClassesGeneratorPackageName

    companion object {
        val entitySyntheticDataClassesGeneratorPackageName = PackageName("runtime.dataclassesSynthetic")
    }
}