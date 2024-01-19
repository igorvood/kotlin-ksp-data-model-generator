package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.ModelEntityContext
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class ContextDataClassesGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val generatedClassData = metaInfo.entities.values.toSet()

        val map = generatedClassData
            .flatMap { metaEntity ->
                metaEntity.uniqueKeysFields
                    .map { ukData -> metaEntity to ukData }
            }
            .map { contextData ->
                val metaEntity = contextData.first
                val dataClass = metaEntity.designClassShortName
                val entityName = CollectName.entityClassName(metaEntity)
                val syntheticEntityName = CollectName.syntheticClassName(metaEntity)
                val ukName = contextData.second.key.name
                val columns = contextData.second.value.sortedBy { it.name.value }

                val joinToString = columns.map { col ->
                    val kotlinMetaClass = col.type

                    "val ${col.name.value}: $kotlinMetaClass"
                }
                    .joinToString(",\n")

                val fullClassName = ukClassName(ukName)
                val code = """package ${metaEntity.designClassPackageName}
                    
import ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum.getPac(rootPackage)}
import ${Generated::class.java.canonicalName}
import ${ModelEntityContext::class.java.canonicalName}
import ${InterfaceGenerator.GeneratedClasses.IContextOf.getPac(rootPackage)}
import ${InterfaceGenerator.GeneratedClasses.EntityEnum.getPac(rootPackage)}
                    
@kotlinx.serialization.Serializable
@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
@${ModelEntityContext::class.java.simpleName}
data class $fullClassName (
$joinToString
): ${InterfaceGenerator.GeneratedClasses.IContextOf}<$entityName>
{
override val designEntityName: ${InterfaceGenerator.GeneratedClasses.EntityEnum}
        get() = ${InterfaceGenerator.GeneratedClasses.EntityEnum}.$dataClass
        
override val ukName: ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum}
    get() = ${InterfaceGenerator.GeneratedClasses.UniqueKeyEnum}.${ukName.value}
    
override val ktEntitySerializer
    get() = ${entityName}.serializer()


override val ktSyntheticEntitySerializer
    get() = ${syntheticEntityName}.serializer()

                
        
}          
                    
                """.trimIndent()

                logger.info("Create $fullClassName")
                GeneratedFile(
                    FileName(fullClassName),
                    GeneratedCode(code),
                    PackageName(metaEntity.designClassPackageName)
                )


            }.toSet()


        return map
    }

    override val subPackage: PackageName
        get() = contextDataClassesGeneratorPackageName

    companion object {
        val contextDataClassesGeneratorPackageName = PackageName("runtime.dataclasses.context")
    }
}