package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.annotation.*
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto


 class MetaEntity(
    val designPoetClassName: ClassName,
    val flowEntityType: FlowEntityType,
    val comment: String,
    val foreignKeysAnnotations: List<ForeignKey>,
    val uniqueKeysAnnotations: List<Uk>,
    val pkColumns: Pair<UkDto, List<MetaEntityColumn>>,
    val uniqueKeysFields: Map<UkDto, List<MetaEntityColumn>>,
    val fields: List<MetaEntityColumn>,

    val ksAnnotated: KSClassDeclaration
) {

    val designClassShortName: String = designPoetClassName.simpleName

    val designClassPackageName: String = designPoetClassName.packageName

    val designClassFullClassName = ModelClassName(designPoetClassName.canonicalName)

    val entityFieldName =
        designPoetClassName.simpleName[0].lowercaseChar() + designPoetClassName.simpleName.substring(1)



}
