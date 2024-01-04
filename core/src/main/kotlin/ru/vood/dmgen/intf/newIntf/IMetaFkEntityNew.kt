package ru.vood.dmgen.intf.newIntf


///**Мета данные по внегнему ключу*/
//data class FKMetaData<T : IEntityOrigin>(
//    /**Сущность из которой идет внешний ключ*/
//    val fromEntity: EntityName,
//    /**Сущность к которой идет внешний ключ*/
//    val toEntity: EntityName,
//    /**Имя уикалоного индекса из toEntity на которой нацелен внешний ключ*/
//    val uk: UkName,
//    /**Тип связи
//     * TODO по идеи величина вычисляемая, сейчас задается разработчиком*/
//    val relationType: RelationType,
//    /**Коллекция колонок входящих во внешний ключ */
//    val fkCols: Set<FkPairNew>,
//    /**Ф-ция вытаскивающая из fromEntity, экземпляр уникального ключа toEntity -> uk.
//     * хорошо подходит для поиска  */
//    val сontextExtractor: (T) -> IContextOf<out IEntityOrigin>
//)
//
//
//data class FkPairNew(
//    val from: FullColumnName,
//    val to: FullColumnName
//)
