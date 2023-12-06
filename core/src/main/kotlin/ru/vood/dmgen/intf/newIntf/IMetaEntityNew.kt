package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.IEntitySynthetic
import kotlin.reflect.KClass



data class EntityData<T : IEntityOrigin<out T>>(
     val designClass: KClass<out Any>,
     val runtimeClass: KClass<out T>,
     val runtimeSyntheticClass: KClass<out T>,
     val serializer: KSerializer<out IEntityOrigin<out T>>,
     val serializerSynthetic: KSerializer<out IEntitySynthetic<out T>>,
     val entityName: EntityName,
     val comment: String,
     val entityType: FlowEntityType
)