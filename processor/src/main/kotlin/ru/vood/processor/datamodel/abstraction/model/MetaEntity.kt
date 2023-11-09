package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.intf.ColumnName
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto
import ru.vood.processor.datamodel.abstraction.model.dto.UkName

@OptIn(KspExperimental::class)
data class MetaEntity(val ksAnnotated: KSClassDeclaration, val logger: KSPLogger) {

    val shortName: String = ksAnnotated.simpleName.asString()

    val packageName: String = ksAnnotated.packageName.asString()

    val modelClassName = ModelClassName("$packageName.$shortName")


    val flowEntityType: FlowEntityType = ksAnnotated.getAnnotationsByType(FlowEntity::class).first().entityType

    val entityFieldName = shortName[0].lowercaseChar() + shortName.substring(1)


    val comment: String? = ksAnnotated.getAnnotationsByType(Comment::class).firstOrNull()?.comment

    val foreignKeysAnnotations = ksAnnotated.getAnnotationsByType(ForeignKey::class).toList()

    val uniqueKeysAnnotations = ksAnnotated.getAnnotationsByType(Uk::class).toList()

    val pkColumns by lazy {

        val pkCols = fields.filter { it.inPk }.map { it.name }.toSet()
        val notNullPkCols = fields.filter { it.inPk && !it.isNullable }.map { it.name }.toSet()

        val minus = pkCols.minus(notNullPkCols.toSet())
        if (minus.isNotEmpty()){
            error("Entity ${modelClassName.value} contains nullable columns in PK ${minus}")
        }

        UkDto(UkName(shortName+"_PK"), pkCols) to fields.filter { it.inPk }
    }

    val uniqueKeysFields: Map<UkDto, List<MetaEntityColumn>> by lazy {
        val allUk = uniqueKeysAnnotations
            .map { anno ->
                UkDto(UkName(anno.name), anno.cols.map { ColumnName(it) }.toSet()) to anno.cols
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
                        error("for entity $shortName Uk annotation colum ${pair.first} not contains field class ")
                    } else pair.first to metaEntityColumn
                }
                uk.first to map
            }.map { uk ->
                uk.first to uk.second.map { q -> q.second }
            }
            .plus(pkColumns)
        val dublicateUk = allUk.map { it.first.name.value }
            .groupBy {it}
            .filter { it.value.size>1 }
            .map { it.key }
            .distinct()

        if (dublicateUk.isNotEmpty()){
            error("for entity ${shortName}  dublicate UK Name ${dublicateUk} ")
        }

        allUk.toMap()
    }

    val fields: List<MetaEntityColumn> by lazy {
//        ksAnnotated.getAllFunctions().forEach {
//            logger.info("getAllFunctions -> "+it.simpleName.asString())
//        }
//
//        ksAnnotated.getAllProperties().forEach {
//            logger.info("getAllProperties -> "+it.simpleName.asString())
//        }

        val map = ksAnnotated.getAllProperties().withIndex().map { MetaEntityColumn(it.index, it.value) }.toList()

        map.forEach {
            logger.info("field $it", it.element)
        }

//        element.enclosedElements.withIndex()
//            .filter { e -> e.value.kind.isField }
//            .map { element -> elementToIGeneratedField(element.index, element.value) }
        map
    }




    override fun toString(): String {
        return """MetaEntity(flowEntityType=$flowEntityType,
            |shortName=$shortName,
            |packageName=$packageName,
            |entityFieldName=$entityFieldName,
            |comment=$comment,
            |foreignKeysAnnotations=$foreignKeysAnnotations,
            |uniqueKeysAnnotations=$uniqueKeysAnnotations,
            |modelClassName=$modelClassName,
            |fields=$fields
            |)""".trimMargin()
    }
}
