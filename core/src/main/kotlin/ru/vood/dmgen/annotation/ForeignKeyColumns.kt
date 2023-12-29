package ru.vood.dmgen.annotation

@Target()
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class ForeignKeyColumns(
    val currentColName: String,
    val outColName: String,
)
