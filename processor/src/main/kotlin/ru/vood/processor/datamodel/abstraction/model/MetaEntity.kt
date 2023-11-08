package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.symbol.KSClassDeclaration
import ru.vood.dmgen.annotation.*
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName

@OptIn(KspExperimental::class)
data class MetaEntity(val ksAnnotated: KSClassDeclaration) {

    val shortName: String = ksAnnotated.simpleName.asString()

    val packageName: String = ksAnnotated.packageName.asString()


    val flowEntityType: FlowEntityType = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityType

    val entityFieldName = shortName[0].lowercaseChar() + shortName.substring(1)


    val comment: String? = ksAnnotated.getAnnotationsByType(Comment::class).firstOrNull()?.comment

    val foreignKeysAnnotations = ksAnnotated.getAnnotationsByType(ForeignKey::class).toList()

    val uniqueKeysAnnotations = ksAnnotated.getAnnotationsByType(Uk::class).toList()



    val modelClassName = ModelClassName("$packageName.$shortName")


    override fun toString(): String {
        return """MetaEntity(flowEntityType=$flowEntityType,
            |shortName=$shortName,
            |packageName=$packageName,
            |entityFieldName=$entityFieldName,
            |comment=$comment,
            |foreignKeysAnnotations=$foreignKeysAnnotations,
            |uniqueKeysAnnotations=$uniqueKeysAnnotations,
            |modelClassName=$modelClassName,
            |)""".trimMargin()
    }
}
