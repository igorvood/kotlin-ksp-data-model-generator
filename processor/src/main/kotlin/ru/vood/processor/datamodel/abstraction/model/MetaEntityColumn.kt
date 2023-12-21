package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.Nullability
import ru.vood.dmgen.annotation.Comment
import ru.vood.dmgen.annotation.Pk
import ru.vood.dmgen.intf.SimpleColumnName

class MetaEntityColumn(
    val position: Int,
    val element: KSPropertyDeclaration
) {
    val name = SimpleColumnName(element.simpleName.asString())

    val isNullable: Boolean = element.type.resolve().nullability == Nullability.NULLABLE

    val question = if (isNullable) {
        "?"
    } else {
        ""
    }

    val type = with(element.type.resolve().declaration) { packageName.asString() + "." + simpleName.asString() }

    @OptIn(KspExperimental::class)
    val comment: String? = element.getAnnotationsByType(Comment::class).firstOrNull()?.comment

    @OptIn(KspExperimental::class)
    val inPk: Boolean = element.getAnnotationsByType(Pk::class).toList().isNotEmpty()

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