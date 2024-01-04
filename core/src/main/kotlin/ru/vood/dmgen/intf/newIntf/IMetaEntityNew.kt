package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.IEntityDetail
import kotlin.reflect.KClass

/**Мета данные по сущности*/
sealed interface IEntityData<T : IEntityOrigin> {
     /**интрефейс описывающий структуру сущности */
     val designClass: KClass<out Any>

     /**класс описывающий сущность*/
     val runtimeClass: KClass<out T>

     /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
     val runtimeSyntheticClass: KClass<out T>

     /**сериализатор оригинальной сущности*/
     val serializer: KSerializer<out IEntityOrigin>

     /**сериализатор синтетической сущности*/
     val serializerSynthetic: KSerializer<out IEntityDetail<out T>>

     /**Имя сущности*/
     val entityName: EntityName

     /**коментарий сущности*/
     val comment: String

     /**тип сущности*/
     val entityType: FlowEntityType
}

/**Мета данные по сущности*/
data class EntityData<T : IEntityOrigin>(
    /**интрефейс описывающий структуру сущности */
     override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
     override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
     override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
     override val serializer: KSerializer<out IEntityOrigin>,
    /**сериализатор синтетической сущности*/
     override val serializerSynthetic: KSerializer<out IEntityDetail<out T>>,
    /**Имя сущности*/
     override val entityName: EntityName,
    /**коментарий сущности*/
     override val comment: String,
    /**тип сущности*/
     override val entityType: FlowEntityType
): IEntityData<T>

data class SealedEntityData<T : IEntityOrigin>(
    /**интрефейс описывающий структуру сущности */
     override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
     override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
     override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
     override val serializer: KSerializer<out IEntityOrigin>,
    /**сериализатор синтетической сущности*/
     override val serializerSynthetic: KSerializer<out IEntityDetail<out T>>,
    /**Имя сущности*/
     override val entityName: EntityName,
    /**коментарий сущности*/
     override val comment: String,
    /**тип сущности*/
     override val entityType: FlowEntityType,
    /**перечень наследников*/
     val children: Set<EntityName>
): IEntityData<T>