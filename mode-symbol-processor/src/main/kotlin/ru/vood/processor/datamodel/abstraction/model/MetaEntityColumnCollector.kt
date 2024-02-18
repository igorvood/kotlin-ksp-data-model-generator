package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.Nullability
import ru.vood.dmgen.annotation.Comment
import ru.vood.dmgen.annotation.Pk
import ru.vood.dmgen.dto.SimpleColumnName

class MetaEntityColumnCollector(
    val position: Int,
    val element: KSPropertyDeclaration,
    val logger: KSPLogger,
) {
    val name = SimpleColumnName(element.simpleName.asString())

    val isNullable: Boolean = element.type.resolve().nullability == Nullability.NULLABLE

    val type = with(element.type.resolve().declaration) { packageName.asString() + "." + simpleName.asString() }

    val typePoetClassName = with(element.type.resolve().declaration) {
        com.squareup.kotlinpoet.ClassName(
            packageName.asString(),
            simpleName.asString()
        )
    }.copy(nullable = isNullable)

    @OptIn(KspExperimental::class)
//    val comment: String? = element.getAnnotationsByType(Comment::class).firstOrNull()?.comment
    val comment: String by lazy {
        element.getAnnotationsByType(Comment::class).firstOrNull()?.comment
            ?: logger.kspError("Annotation ${Comment::class.simpleName} mandatory for field $name", element)
    }

    @OptIn(KspExperimental::class)
    val inPk: Boolean = element.getAnnotationsByType(Pk::class).toList().isNotEmpty()

    val metaEntityColumn = MetaEntityColumn(
        name,
        inPk,
        isNullable,
        type,
        typePoetClassName,
        position,
        comment
    )

    override fun toString(): String {
        return """MetaEntityColumn(
            |name=$name,
            |position=$position,
            |isNullable=$isNullable,
            |type=$type
            |comment=$comment
            |inPk=$inPk
            |)""".trimMargin()
    }
}

