package ru.vood.processor.datamodel.gen.runtime

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IMetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.gen.meta.EntityEnumGenerator
import java.time.LocalDate
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
import ${EntityName::class.java.canonicalName}
import ${Generated::class.java.canonicalName}
import kotlinx.serialization.KSerializer
import ${rootPackage.value}.${EntityDataClassesGenerator.entityDataClassesGeneratorPackageName.value}.$entityName
                    
@kotlinx.serialization.Serializable
@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class $fullClassName (
$joinToString
): ${IContextOf::class.java.canonicalName}<$entityName>//,
//${IEntity::class.java.canonicalName}<$fullClassName>
{
override val metaEntity: ${EntityName::class.simpleName}
        get() = metaEntityConst
        
override fun ktSerializer() = serializer()
        
override val ukName: UkName
    get() = ukNameConst
    
override val ktEntitySerializer//: KSerializer<*>
    get() = ${entityName}.serializer()

companion object{
    val ukNameConst = UkName("${ukName.value}")
    val metaEntityConst = EntityName("$dataClass")// ${rootPackage.value}.${AbstractDataDictionaryGenerator.subPackageAbstractDataDictionaryGenerator.value}.${EntityEnumGenerator.nameClassEntityEnumGenerator}.$dataClass
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