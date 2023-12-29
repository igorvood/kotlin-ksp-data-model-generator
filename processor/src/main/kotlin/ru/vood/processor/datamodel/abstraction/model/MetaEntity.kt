package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.isLocal
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.newIntf.TypeUk
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto


@OptIn(KspExperimental::class)
data class MetaEntity(val ksAnnotated: KSClassDeclaration, val logger: KSPLogger) {


    val sealedChildren = ksAnnotated.getSealedSubclasses().map { ModelClassName(it.simpleName.asString()) }.toSet()

    val isSealedObject = sealedChildren.isNotEmpty()

    val designClassShortName: String = ksAnnotated.simpleName.asString()

    val designClassPackageName: String = ksAnnotated.packageName.asString()

    val designClassFullClassName = ModelClassName("$designClassPackageName.$designClassShortName")


    val flowEntityType: FlowEntityType = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityType

    val flowEntityName = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityName

    val entityFieldName = designClassShortName[0].lowercaseChar() + designClassShortName.substring(1)

    val comment: String? = ksAnnotated.getAnnotationsByType(Comment::class).firstOrNull()?.comment

    val foreignKeysAnnotations = ksAnnotated.getAnnotationsByType(ForeignKey::class).toList()

    val uniqueKeysAnnotations = ksAnnotated.getAnnotationsByType(Uk::class).toList()

    val pkColumns by lazy {
        val pkCols = fields.filter { it.inPk }.map { it.name }.toSet()
        val notNullPkCols = fields.filter { it.inPk && !it.isNullable }.map { it.name }.toSet()

        val minus = pkCols.minus(notNullPkCols.toSet())
        if (minus.isNotEmpty()) {
            error("Entity ${designClassFullClassName.value} contains nullable columns in PK ${minus}")
        }

        UkDto(UkName(designClassShortName + "_PK"), pkCols, TypeUk.PK) to fields.filter { it.inPk }
    }

    val uniqueKeysFields: Map<UkDto, List<MetaEntityColumn>> by lazy {
        val allUk = uniqueKeysAnnotations
            .map { anno ->
                UkDto(UkName(anno.name), anno.cols.map { SimpleColumnName(it) }.toSet(), TypeUk.UK) to anno.cols
                    .map { annoColName ->
                        annoColName to fields.filter { f -> f.name.value == annoColName }
                            .map { metaCol -> metaCol }
                            .firstOrNull()
                    }
            }.map { uk ->
                val ukCols = uk.second
                val map = ukCols.map { pair: Pair<String, MetaEntityColumn?> ->
                    val metaEntityColumn = pair.second
                    if (metaEntityColumn == null) {
                        error("for entity $designClassShortName Uk annotation colum ${pair.first} not contains field class ")
                    } else pair.first to metaEntityColumn
                }
                uk.first to map
            }.map { uk ->
                uk.first to uk.second.map { q -> q.second }
            }
            .plus(pkColumns)
        val dublicateUk = allUk.map { it.first.name.value }
            .groupBy { it }
            .filter { it.value.size > 1 }
            .map { it.key }
            .distinct()

        if (dublicateUk.isNotEmpty()) {
            error("for entity ${designClassShortName}  dublicate UK Name ${dublicateUk} ")
        }

        allUk.toMap()
    }

    val fields: List<MetaEntityColumn> by lazy {
        val map = ksAnnotated.getAllProperties().withIndex().map { MetaEntityColumn(it.index, it.value) }.toList()
        map.forEach {
            logger.warn("field -> ${it.name.value}", it.element)
        }
        map
    }


    override fun toString(): String {
        return """MetaEntity(flowEntityType=$flowEntityType,
            |shortName=$designClassShortName,
            |packageName=$designClassPackageName,
            |entityFieldName=$entityFieldName,
            |comment=$comment,
            |foreignKeysAnnotations=$foreignKeysAnnotations,
            |uniqueKeysAnnotations=$uniqueKeysAnnotations,
            |modelClassName=$designClassFullClassName,
            
            |)""".trimMargin()
//        |fields=$fields
    }
}
