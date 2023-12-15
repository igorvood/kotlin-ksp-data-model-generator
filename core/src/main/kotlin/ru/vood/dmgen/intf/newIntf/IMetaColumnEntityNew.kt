package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.*


/**Мета данные по реквизиту сущности*/
data class ColumnEntityData<T>(
    /**имя сущности*/
     val entity: EntityName,
    /**имя сущности, если реквизит является иной сущностью, по сути это форен*/
     val outEntity: EntityName?,
//    override val kProperty1: KProperty1<out T, *>,
    /**имя колонки*/
     val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
     val isOptional: Boolean,
    /**коментарий колонки*/
     val comment: String,
    @Deprecated("use iColKind")
    /**тип колонки*/
     val columnKind: ColumnKind,
    /**тип колонки*/
     val iColKind: IColKind<T, *>

)


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