package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.*


/**Мета данные по реквизиту сущности*/
open class ColumnEntityData<T>(
    /**имя сущности*/
    val entity: EntityName,
    /**имя колонки*/
    val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    val isOptional: Boolean,
    /**коментарий колонки*/
    val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: IColExtractFunction<T, *>,
    /**имя сущности, если реквизит является иной сущностью, по сути это форен*/
    private val outEntity: EntityName?,
    /**простой тип колонки*/
    private val simpleColumnType: SimpleColumnType?,

    ) {

    val colType: IColType by lazy {


        if (outEntity != null) {
            return@lazy EntityType(outEntity)
        }

        if (simpleColumnType != null) {
            return@lazy SympleType(simpleColumnType)
        }

        error("asdasdasd")
//        TODO()
    }
}

class SyntheticColumnEntityData<T>(
    entity: EntityName,
    /**имя колонки*/
    simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    isOptional: Boolean,
    /**коментарий колонки*/
    comment: String,
    /**ф-ция экстрактор значения колонки*/
    iColExtractFunction: IColExtractFunction<T, *>,
    outEntity: EntityName
) : ColumnEntityData<T>(entity, simpleColumnName, isOptional, comment, iColExtractFunction, outEntity, null){
    val colTypeSynthetic = colType as EntityType
}

sealed interface IColExtractFunction<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}


@JvmInline
value class Simple<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : IColExtractFunction<T, OUT>

@JvmInline
value class Synthetic<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : IColExtractFunction<SINTH_IN, Set<IEntitySynthetic<OUT>>>

@JvmInline
value class SyntheticSet<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : IColExtractFunction<SINTH_IN, Set<IEntitySynthetic<OUT>>>