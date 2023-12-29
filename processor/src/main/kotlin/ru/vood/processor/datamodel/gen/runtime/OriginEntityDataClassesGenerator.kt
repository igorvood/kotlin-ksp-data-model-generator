package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
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
        val implemets =
            """${IEntityOrigin::class.java.simpleName}, ${metaEntity.designClassFullClassName.value}"""


        val code = """package ${metaEntity.designClassPackageName}
                    
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
import ${IEntityOrigin::class.java.canonicalName}


@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@kotlinx.serialization.Serializable
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

    override val subPackage: PackageName
        get() = entityOriginDataClassesGeneratorPackageName

    companion object {
        val entityOriginDataClassesGeneratorPackageName = PackageName("runtime.dataclassesOrigin")
    }
}