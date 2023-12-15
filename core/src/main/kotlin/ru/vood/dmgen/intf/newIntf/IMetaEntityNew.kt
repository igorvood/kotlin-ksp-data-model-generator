package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.IEntitySynthetic
import kotlin.reflect.KClass



/**Мета данные по сущности ключу*/
data class EntityData<T : IEntityOrigin>(
     /**интрефейс описывающий структуру сущности */
     val designClass: KClass<out Any>,
     /**класс описывающий сущность*/
     val runtimeClass: KClass<out T>,
     /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
     val runtimeSyntheticClass: KClass<out T>,
     /**сериализатор оригинальной сущности*/
     val serializer: KSerializer<out IEntityOrigin>,
     /**сериализатор синтетической сущности*/
     val serializerSynthetic: KSerializer<out IEntitySynthetic<out T>>,
     /**Имя сущности*/
     val entityName: EntityName,
     /**коментарий сущности*/
     val comment: String,
     /**тип сущности*/
     val entityType: FlowEntityType
)