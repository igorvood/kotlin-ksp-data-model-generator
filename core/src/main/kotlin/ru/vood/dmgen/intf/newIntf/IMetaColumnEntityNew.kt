package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.*

interface IMetaColumnEntityNew<T : IEntityOrigin<out T>> {
    val entity: EntityName
//    val kProperty1: KProperty1<out T, *>
    val simpleColumnName: SimpleColumnName
    val isOptional: Boolean
    val comment: String
    @Deprecated("use iColKind")
    val columnKind: ColumnKind
    val iColKind: IColKind<T, *>
}

data class ColumnEntityData<T : IEntityOrigin<out T>>(
    override val entity: EntityName,
//    override val kProperty1: KProperty1<out T, *>,
    override val simpleColumnName: SimpleColumnName,
    override val isOptional: Boolean,
    override val comment: String,
    @Deprecated("use iColKind")
    override val columnKind: ColumnKind,
    override val iColKind: IColKind<T, *>

) : IMetaColumnEntityNew<T>


enum class ColumnKind {
    SIMPLE, SYNTHETIC, SYNTHETIC_SET,
}

sealed interface IColKind<T : Serializer<out T>, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

@JvmInline
value class Simple<T : Serializer<out T>, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : IColKind<T, OUT>

@JvmInline
value class Synthetic<T : Serializer<out T>, OUT : Serializer<out OUT>>(
    override val extractFieldValue: (entity: T) -> Set<OUT>
) : IColKind<T, Set<OUT>>

@JvmInline
value class SyntheticSet<T : IEntityOrigin<out T>, OUT : IEntityOrigin< OUT>>(
    override val extractFieldValue: (entity: T) -> Set<OUT>
) : IColKind<T, Set<OUT>>