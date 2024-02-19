package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto


@OptIn(KspExperimental::class)
class MetaEntityCollector(val ksAnnotated: KSClassDeclaration, val logger: KSPLogger) {

    val sealedChildren = ksAnnotated.getSealedSubclasses().map { ModelClassName(it.simpleName.asString()) }.toSet()

    @Deprecated("подлежит удалению пользуй designPoetClassName")
    val designClassShortName: String = ksAnnotated.simpleName.asString()

    @Deprecated("подлежит удалению пользуй designPoetClassName")
    val designClassPackageName: String = ksAnnotated.packageName.asString()

    val designPoetClassName = ClassName(ksAnnotated.packageName.asString(), ksAnnotated.simpleName.asString())

    val designClassFullClassName = ModelClassName("$designClassPackageName.$designClassShortName")


    val flowEntityType: FlowEntityType = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityType

//    val isSealedObject = FlowEntityType.ONE_OF == flowEntityType

    val flowEntityName = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityName

    val entityFieldName = designClassShortName[0].lowercaseChar() + designClassShortName.substring(1)

    val comment: String by lazy {
        ksAnnotated.getAnnotationsByType(Comment::class).firstOrNull()?.comment ?: logger.kspError(
            "Annotation ${Comment::class.simpleName} mandatory for entity $designPoetClassName",
            ksAnnotated
        )
    }

    val foreignKeysAnnotations = ksAnnotated.getAnnotationsByType(ForeignKey::class)
        .map {
            val split = it.kClass.split(".")
            val joinToString = (0..split.lastIndex - 1).map { split[it] }.joinToString(".")

            val className = ClassName(joinToString, split.last())
            ForeignKeyAnnotationDto(
                kClass = className,
                name = it.name,
                cols = it.cols.map { cf -> ForeignKeyColumnsDto(cf.currentColName, cf.outColName) },
                foreignKeyType = it.foreignKeyType
            )
        }
        .toList()

    val uniqueKeysAnnotations = ksAnnotated.getAnnotationsByType(Uk::class).toList()

    val pkColumns by lazy {
        val pkCols = fields.filter { it.inPk }.sortedBy { it.position }.map { it.name }
        val notNullPkCols = fields.filter { it.inPk && !it.isNullable }.map { it.name }.toSet()

        val minus = pkCols.minus(notNullPkCols.toSet())
        if (minus.isNotEmpty()) {
            logger.kspError(
                "Entity ${designClassFullClassName.value} contains nullable columns in PK ${minus}",
                ksAnnotated
            )
        }

        UkDto(UkName(designClassShortName + "_PK"), pkCols, TypeUk.PK) to fields.filter { it.inPk }
    }

    val uniqueKeysFields: Map<UkDto, List<MetaEntityColumn>> by lazy {
        val allUk = uniqueKeysAnnotations
            .map { anno ->
                UkDto(UkName(anno.name), anno.cols.map { SimpleColumnName(it) }, TypeUk.UK) to anno.cols
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
                        logger.kspError(
                            "for entity $designClassShortName Uk annotation colum ${pair.first} not contains field class ",
                            ksAnnotated
                        )

                    } else pair.first to metaEntityColumn
                }
                uk.first to map
            }.map { uk ->
                uk.first to uk.second.map { q -> q.second }
            }
        val allUkAndPk = if (pkColumns.second.isNotEmpty()) {
            allUk.plus(pkColumns)
        } else allUk

        val dublicateUk = allUkAndPk.map { it.first.name.value }
            .groupBy { it }
            .filter { it.value.size > 1 }
            .map { it.key }
            .distinct()

        if (dublicateUk.isNotEmpty()) {
            logger.kspError("for entity ${designClassShortName}  dublicate UK Name ${dublicateUk} ", ksAnnotated)
        }

        allUkAndPk.toMap()
    }

    val fields: List<MetaEntityColumn> by lazy {
        val map =
            ksAnnotated.getAllProperties().withIndex()
                .map { MetaEntityColumnCollector(it.index, it.value, logger).metaEntityColumn }.toList()
        map
    }


    val metaEntity = MetaEntity(
        designPoetClassName = designPoetClassName,
        flowEntityType = flowEntityType,
        comment = comment,
        foreignKeysAnnotations = foreignKeysAnnotations,
        pkColumns = pkColumns,
        uniqueKeysFields = uniqueKeysFields,
        fields = fields,
        ksAnnotated = ksAnnotated
    )

}
