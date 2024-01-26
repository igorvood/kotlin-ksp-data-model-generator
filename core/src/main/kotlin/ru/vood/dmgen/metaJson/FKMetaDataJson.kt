package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.dto.UkName

/**Мета данные по внегнему ключу*/
@Serializable
data class FKMetaDataJson(
    /**Сущность из которой идет внешний ключ*/
    val fromEntity: EntityName,
    /**Сущность к которой идет внешний ключ*/
    val toEntity: EntityName,
    /**Имя уикалоного индекса из toEntity на которой нацелен внешний ключ*/
    val uk: UkName,
    /**Тип связи
     * TODO по идеи величина вычисляемая, сейчас задается разработчиком*/
    val relationType: RelationType,
    /**Коллекция колонок входящих во внешний ключ */
    val fkCols: Set<FkPairJson>,
)
