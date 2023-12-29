package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.*


/**Мета данные по реквизиту сущности*/
sealed interface ColumnEntityData<T>{
    /**имя сущности*/
    val entity: EntityName
    /**имя колонки*/
    val simpleColumnName: SimpleColumnName
    /**признак опциональности колонки*/
    val isOptional: Boolean
    /**коментарий колонки*/
    val comment: String
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: IColExtractFunction<T, *>
}

data class SimpleColumnEntityData<T: IEntityOrigin>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    override val iColExtractFunction: SimpleColExtractFunction<T, *>,
    val simpleColumnType: SimpleColumnType
): ColumnEntityData<T>


data class SyntheticColumnEntityData<T>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    override val iColExtractFunction: ISyntheticColExtractFunction<T, *>,
    val outEntity: EntityName
) : ColumnEntityData<T>

data class SealedSyntheticColumnEntityData<T>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    override val iColExtractFunction: ISyntheticColExtractFunction<T, *>,
    val outEntity: Set<EntityName>
) : ColumnEntityData<T>

sealed interface IColExtractFunction<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

sealed interface ISyntheticColExtractFunction<in T, out OUT>:  IColExtractFunction<T, OUT>

@JvmInline
value class SimpleColExtractFunction<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : IColExtractFunction<T, OUT>

@JvmInline
value class Synthetic<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : ISyntheticColExtractFunction<SINTH_IN, Set<IEntitySynthetic<OUT>>>

@JvmInline
value class SyntheticSet<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : ISyntheticColExtractFunction<SINTH_IN, Set<IEntitySynthetic<OUT>>>