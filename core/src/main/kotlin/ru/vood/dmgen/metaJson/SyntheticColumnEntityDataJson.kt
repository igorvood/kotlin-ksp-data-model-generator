package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.SimpleColumnName


/**Мета данные по реквизиту сущности*/
@Serializable
sealed interface IColumnEntityDataJson {
    /**имя сущности*/
    val entity: EntityName

    /**имя колонки*/
    val simpleColumnName: SimpleColumnName

    /**признак опциональности колонки*/
    val isOptional: Boolean

    /**коментарий колонки*/
    val comment: String
}

/**Мета данные по реквизиту сущности*/
@Serializable
data class SyntheticColumnEntityDataJson(
    /**имя сущности*/
    override val entity: EntityName,

    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,

    /**признак опциональности колонки*/
    override val isOptional: Boolean,

    /**коментарий колонки*/
    override val comment: String
    /**ф-ция экстрактор значения колонки*/

): IColumnEntityDataJson