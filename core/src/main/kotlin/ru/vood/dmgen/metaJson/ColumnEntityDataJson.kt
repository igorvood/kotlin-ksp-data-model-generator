package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.SimpleColumnName

/**Мета данные по реквизиту сущности*/
@Serializable
data class ColumnEntityDataJson(
    /**имя сущности*/
    val entity: EntityName,

    /**имя колонки*/
    val simpleColumnName: SimpleColumnName,

    /**признак опциональности колонки*/
    val isOptional: Boolean,

    /**коментарий колонки*/
    val comment: String
    /**ф-ция экстрактор значения колонки*/
)