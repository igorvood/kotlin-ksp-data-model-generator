package ru.vood.dmgen.intf

import kotlin.reflect.KProperty1

@Deprecated("удалить")
interface IMetaColumnEntity {
    val entity: IMetaEntity
    val kProperty1: KProperty1<*, *>
    val columnName: ColumnName
    val comment: String
}

@JvmInline
value class ColumnName(val value: String)

@JvmInline
value class FullColumnName(val value: String)