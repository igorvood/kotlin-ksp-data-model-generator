package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.*
import ru.vood.dmgen.metaJson.value.InterfaceEntityClassName
import ru.vood.dmgen.metaJson.value.RuntimeEntityClassName
import ru.vood.dmgen.metaJson.value.RuntimeSyntheticEntityClassName
import ru.vood.dmgen.metaJson.value.UKRuntimeEntityClassName


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


/**Мета данные по сущности*/
@Serializable
sealed interface IEntityDataJson {
    /**интрефейс описывающий структуру сущности */
    val designClass: InterfaceEntityClassName

    /**класс описывающий сущность*/
    val runtimeClass: RuntimeEntityClassName

    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    val runtimeSyntheticClass: RuntimeSyntheticEntityClassName

    /**Имя сущности*/
    val entityName: EntityName

    /**коментарий сущности*/
    val comment: String

    /**тип сущности*/
    val entityType: FlowEntityType
}


/**Мета данные по сущности*/
@Serializable
data class EntityDataJson(
    /**интрефейс описывающий структуру сущности */
    override val designClass: InterfaceEntityClassName,
    /**класс описывающий сущность*/
    override val runtimeClass: RuntimeEntityClassName,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: RuntimeSyntheticEntityClassName,
    /**Имя сущности*/
    override val entityName: EntityName,
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: FlowEntityType
) : IEntityDataJson

@Serializable
data class SealedEntityDataJson(
    /**интрефейс описывающий структуру сущности */
    override val designClass: InterfaceEntityClassName,
    /**класс описывающий сущность*/
    override val runtimeClass: RuntimeEntityClassName,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: RuntimeSyntheticEntityClassName,
    /**Имя сущности*/
    override val entityName: EntityName,
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: FlowEntityType,
    /**перечень наследников*/
    val children: Set<EntityName>
) : IEntityDataJson


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

/**Мета данные по уникальному ключу*/
@Serializable
data class UKEntityDataJson(
    /**Имя уникального ключа*/
    val ukName: UkName,
    /**Колонки входящие в ключ*/
    val columns: List<SimpleColumnName>,
    /**Класс уникального ключа*/
    val ukClass: UKRuntimeEntityClassName,
    /**Имя сушности, к которой относится уникальный ключ*/
    val entity: EntityName,
    /**Тип уникального ключа PK, UK*/
    val typeUk: TypeUk
)

@Serializable
data class FkPairJson(
    val from: Pair<EntityName, SimpleColumnName>,
    val to: Pair<EntityName, SimpleColumnName>
)



