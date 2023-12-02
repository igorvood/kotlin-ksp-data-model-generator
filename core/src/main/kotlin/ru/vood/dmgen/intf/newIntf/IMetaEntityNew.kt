package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IEntityOrigin
import kotlin.reflect.KClass

interface IMetaEntityNew<T : IEntityOrigin<out T>> {
    val designClass: KClass<out Any>
    val runtimeClass: KClass<out T>
    val entityName: EntityName
    val comment: String
    val serializer: KSerializer<out IEntityOrigin<out T>>
    val entityType: FlowEntityType

}

data class EntityData<T : IEntityOrigin<out T>>(
    override val designClass: KClass<out Any>,
    override val runtimeClass: KClass<out T>,
    override val serializer: KSerializer<out IEntityOrigin<out T>>,
    override val entityName: EntityName,
    override val comment: String,
    override val entityType: FlowEntityType
) : IMetaEntityNew<T>