package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin


/**Мета данные по внегнему ключу*/
data class FKMetaData<T : IEntityOrigin>(
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
    val fkCols: Set<FkPairNew>,
    /**Ф-ция вытаскивающая из fromEntity, экземпляр уникального ключа toEntity -> uk.
     * хорошо подходит для поиска  */
    val extractJsonContext: (T) -> IContextOf<out IEntityOrigin>
)


data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
