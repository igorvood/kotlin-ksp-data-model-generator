package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.JsonInString
import ru.vood.dmgen.annotation.UkName


interface Serializer<T> {
    val designEntityName: EntityName
    fun ktSerializer(): KSerializer<out Serializer<out T>>

    fun toJson(json: Json): JsonInString =
        JsonInString(json.encodeToString(ktSerializer() as KSerializer<Serializer<out T>>, this))

    fun castedKSerializer(): KSerializer<Serializer<T>> = ktSerializer() as KSerializer<Serializer<T>>

    fun <SERIALISED_TYPE> serialiseIt(s: (Serializer<T>) -> SERIALISED_TYPE): SERIALISED_TYPE {
        return s(this)
    }

}

interface IEntityOrigin<T : IEntityOrigin<T>> : Serializer<T> {


}

//interface IEntityOrigin<T : IEntityOrigin<T>> : IEntity<T>

interface IEntitySynthetic<T : IEntityOrigin<out T>> : Serializer<T> {

    val origin: T

    fun syntheticField(entityName: EntityName): Set<IEntitySynthetic<out IEntityOrigin<*>>>

}

interface IContextOf<T : IEntityOrigin<T>> : Serializer<T> {

//    val metaEntity: EntityName

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

}

interface IAggregate<T : IAggregate<T>> : IEntityOrigin<T>