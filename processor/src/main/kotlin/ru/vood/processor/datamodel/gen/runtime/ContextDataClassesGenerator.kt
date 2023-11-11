package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.gen.meta.EntityEnumGenerator

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
                val dataClass = metaEntity.shortName
                val entityName = """${dataClass}Entity"""
                val ukName = contextData.second.key.name
                val columns = contextData.second.value.sortedBy { it.name.value }

                val joinToString = columns.map { col ->
                    val kotlinMetaClass = col.type

                    "val ${col.name.value}: $kotlinMetaClass"
                }
                    .joinToString(",\n")

                val fullClassName = ukClassName(metaEntity, ukName)
                val code = """package ${packageName.value}
                    
import ${UkName::class.java.canonicalName}
                    
@kotlinx.serialization.Serializable
data class $fullClassName (
$joinToString
): ${IContextOf::class.java.canonicalName}<${rootPackage.value}.${EntityDataClassesGenerator.entityDataClassesGeneratorPackageName.value}.$entityName>//,
//${IEntity::class.java.canonicalName}<$fullClassName>
{
override val metaEntity: ${IMetaEntity::class.java.canonicalName}
        get() = metaEntityConst
        
override fun ktSerializer() = serializer()
        
override val ukName: UkName
    get() = ukNameConst

companion object{
    val ukNameConst = UkName("${fullClassName}")
    val metaEntityConst = ${rootPackage.value}.${AbstractDataDictionaryGenerator.subPackageAbstractDataDictionaryGenerator.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.$dataClass
}
                
        
}          
                    
                """.trimIndent()

                logger.info("Create $fullClassName")
                GeneratedFile(FileName(fullClassName), GeneratedCode(code), packageName)


            }.toSet()


        return map
    }

    override val subPackage: PackageName
        get() = contextDataClassesGeneratorPackageName

    companion object {
        val contextDataClassesGeneratorPackageName = PackageName("runtime.dataclasses.context")
    }
}