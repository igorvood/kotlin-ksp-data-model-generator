package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.*


/**Мета данные по реквизиту сущности*/
data class ColumnEntityData<T>(
    /**имя сущности*/
    val entity: EntityName,
    /**имя колонки*/
    val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    val isOptional: Boolean,
    /**коментарий колонки*/
    val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColKind: IColKind<T, *>,


    /**имя сущности, если реквизит является иной сущностью, по сути это форен*/
    val outEntity: EntityName?,
    /**простой тип колонки*/
    val simpleColumnType: SimpleColumnType?,

    @Deprecated("use iColKind")
    /**тип колонки*/
    val columnKind: ColumnKind,



    )

@JvmInline
value class SimpleColumnType(val value: String)

enum class ColumnKind {
    SIMPLE, SYNTHETIC, SYNTHETIC_SET,
}

sealed interface IColKind<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}


@JvmInline
value class Simple<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : IColKind<T, OUT>

@JvmInline
value class Synthetic<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : IColKind<SINTH_IN, Set<IEntitySynthetic<OUT>>>

@JvmInline
value class SyntheticSet<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : IColKind<SINTH_IN, Set<IEntitySynthetic<OUT>>>