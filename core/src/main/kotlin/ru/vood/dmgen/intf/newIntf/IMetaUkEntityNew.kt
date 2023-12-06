package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.SimpleColumnName
import kotlin.reflect.KClass


data class UKEntityData<T : IEntityOrigin>(
    val columns: List<SimpleColumnName>,
    val serializer: KSerializer<out IContextOf<out T>>,
    val ukClass: KClass<out IContextOf<out T>>,
    val entity: EntityName,
    val extractContext: (T) -> IContextOf<T>,
    val typeUk: TypeUk
//    override val contextOfClass: KClass<IContextOf<T>>
)

enum class TypeUk {
    PK, UK
}