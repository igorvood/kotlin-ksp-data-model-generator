package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.UkName

//
//interface SerializableEntity {
//    val designEntityName: EntityName
//}
//
//interface IEntityOrigin : SerializableEntity
//
//interface IEntityDetail<T : IEntityOrigin> : IEntityOrigin {
//
//    val origin: T
//    fun syntheticField(entityName: EntityName): Set<IEntityDetail<out IEntityOrigin>>
//
//}
//
//interface IContextOf<T : IEntityOrigin> : SerializableEntity {
//
//    val ukName: UkName
//
//    val ktEntitySerializer: KSerializer<T>
//
//    val ktSyntheticEntitySerializer: KSerializer<out IEntityDetail<out T>>
//
//}
//
