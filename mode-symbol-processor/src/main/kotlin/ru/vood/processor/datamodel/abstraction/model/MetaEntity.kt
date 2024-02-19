package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import kotlinx.serialization.Serializable
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto
import ru.vood.processor.datamodel.abstraction.model.serializer.ClassNameSerializer


@Serializable
data class MetaEntity(
    @Serializable(ClassNameSerializer::class)
    val designPoetClassName: ClassName,
    val flowEntityType: FlowEntityType,
    val comment: String,
    val foreignKeysAnnotations: List<ForeignKeyAnnotationDto>,
    val pkColumns: Pair<UkDto, List<MetaEntityColumn>>,
    val uniqueKeysFields: Map<UkDto, List<MetaEntityColumn>>,
    val fields: List<MetaEntityColumn>,

    @kotlinx.serialization.Transient
    val ksAnnotated: KSClassDeclaration? = null,
) {

    @kotlinx.serialization.Transient
    val designClassShortName: String = designPoetClassName.simpleName

    @kotlinx.serialization.Transient
    val designClassPackageName: String = designPoetClassName.packageName

    @kotlinx.serialization.Transient
    val designClassFullClassName = ModelClassName(designPoetClassName.canonicalName)

    @kotlinx.serialization.Transient
    val entityFieldName =
        designPoetClassName.simpleName[0].lowercaseChar() + designPoetClassName.simpleName.substring(1)


}
