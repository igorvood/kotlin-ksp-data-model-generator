package ru.vood.dmgen.dto

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.FlowEntityType
import kotlin.reflect.KClass

//data class EntityDataJson(
//    /**интрефейс описывающий структуру сущности */
//    designClass: KClass<out Any>,
//    /**класс описывающий сущность*/
//    override val runtimeClass: KClass<out IEntityOrigin>,
//    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
//    override val runtimeSyntheticClass: KClass<out IEntityOrigin>,
//    /**сериализатор оригинальной сущности*/
//    override val serializer: KSerializer<out IEntityOrigin>,
//    /**сериализатор синтетической сущности*/
//    override val serializerSynthetic: KSerializer<out IEntityDetail<out IEntityOrigin>>,
//    /**Имя сущности*/
//    override val entityName:  EntityEnum,
//    /**коментарий сущности*/
//    override val comment: String,
//    /**тип сущности*/
//    override val entityType: FlowEntityType
//)