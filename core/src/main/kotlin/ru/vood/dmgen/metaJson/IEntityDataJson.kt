package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.metaJson.value.InterfaceEntityClassName
import ru.vood.dmgen.metaJson.value.RuntimeEntityClassName
import ru.vood.dmgen.metaJson.value.RuntimeSyntheticEntityClassName


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
    override val entityType: FlowEntityType,
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
    val children: Set<EntityName>,
) : IEntityDataJson








