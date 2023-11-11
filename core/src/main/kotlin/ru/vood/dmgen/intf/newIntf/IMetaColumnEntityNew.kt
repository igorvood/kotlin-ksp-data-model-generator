package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import kotlin.reflect.KProperty1

interface IMetaColumnEntityNew<T : IEntity<out T>> {
    val entity: EntityName
    val kProperty1: KProperty1<out T, *>
    val simpleColumnName: SimpleColumnName
    val isOptional: Boolean
    val comment: String
    val columnKind: ColumnKind
}

data class ColumnEntityData<T : IEntity<out T>>(
    override val entity: EntityName,
    override val kProperty1: KProperty1<out T, *>,
    override val simpleColumnName: SimpleColumnName,
    override val isOptional: Boolean,
    override val comment: String,
    override val columnKind: ColumnKind,
) : IMetaColumnEntityNew<T>


enum class ColumnKind{
    SIMPLE,
    SYNTHETIC,
    SYNTHETIC_SET,
 }