package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class OriginEntityDataClassesGenerator(
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
        logger.info("Create $fullClassName")
        val map = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()

        val sealedForeign = metaForeignKeys.filter { fk ->
            fk.fromEntity.designClassFullClassName == metaEntity.designClassFullClassName &&
                    when (fk.toEntity.flowEntityType) {
                        FlowEntityType.INNER -> false
                        FlowEntityType.AGGREGATE -> false
                        FlowEntityType.ONE_OF -> true
                    }
        }

        val implemets = when (sealedForeign.size) {
            0 -> """${InterfaceGenerator.GeneratedClasses.IEntityOrigin}, ${metaEntity.designClassFullClassName.value}"""
            1 -> """${InterfaceGenerator.GeneratedClasses.IEntityOrigin}, ${metaEntity.designClassFullClassName.value}, ${
                entityClassName(
                    sealedForeign[0].toEntity
                )
            }"""
            else -> error("for $fullClassName found several foreign on sealed interface")
        }

        val code = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> """${head(metaEntity)}
data class $fullClassName (
$simpleColumns

): $implemets         
{
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("${metaEntity.designClassShortName}")
    
    }
}
                    
                """.trimIndent()
            FlowEntityType.ONE_OF -> """${head(metaEntity)}
sealed interface $fullClassName:  $implemets  
{
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("${metaEntity.designClassShortName}")
    
    }
}
            """.trimIndent()
        }


        val plus = collector.plus(
            GeneratedFile(
                FileName(fullClassName),
                GeneratedCode(code),
                PackageName(metaEntity.designClassPackageName)
            )
        ).plus(map)


        return plus
    }

    private fun head(metaEntity: MetaEntity) =
        """package ${metaEntity.designClassPackageName}
                        
${
            metaEntity.comment?.let {
                """/**
    *$it
    */
    """.trimIndent()
            } ?: ""
        }          
import ${EntityName::class.java.canonicalName}     
import ${Generated::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.IEntityOrigin.getPac(rootPackage)}
    
    
@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@kotlinx.serialization.Serializable"""

    override val subPackage: PackageName
        get() = entityOriginDataClassesGeneratorPackageName

    companion object {
        val entityOriginDataClassesGeneratorPackageName = PackageName("runtime.dataclassesOrigin")
    }
}