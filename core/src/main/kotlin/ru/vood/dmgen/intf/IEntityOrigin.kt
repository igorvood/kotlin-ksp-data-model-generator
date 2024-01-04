package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.UkName


interface SerializableEntity<E: Enum<E>> {
    //    val designEntityName: EntityName
    val designEntityName: E
}

interface IEntityOrigin<E: Enum<E>> : SerializableEntity<E>

interface IEntityDetail<T : IEntityOrigin<E>, E: Enum<E>> : IEntityOrigin<E> {

    val origin: T
    fun syntheticField(entityName: EntityName): Set<IEntityDetail<out IEntityOrigin<out E>, out E>>

}

interface IContextOf<T : IEntityOrigin<E>, E: Enum<E>> : SerializableEntity<E> {

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

    val ktSyntheticEntitySerializer: KSerializer<out IEntityDetail<out T, out E>>

}

