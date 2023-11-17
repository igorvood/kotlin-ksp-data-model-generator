package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.JsonInString
import ru.vood.dmgen.annotation.UkName


interface Serializer<T> {

    fun ktSerializer(): KSerializer<out Serializer<out T>>

    fun toJson(json: Json): JsonInString =
        JsonInString(json.encodeToString(ktSerializer() as KSerializer<Serializer<out T>>, this))

    fun castedKSerializer(): KSerializer<Serializer<T>> = ktSerializer() as KSerializer<Serializer<T>>

    fun <SERIALISED_TYPE> serialiseIt(s: (Serializer<T>) -> SERIALISED_TYPE): SERIALISED_TYPE {
        return s(this)
    }

}

interface IEntity<T : IEntity<T>> : Serializer<T> {

    val designEntityName: EntityName
}

interface IContextOf<T : IEntity<T>> : Serializer<T> {

    val metaEntity: EntityName

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

}

interface IAggregate<T : IAggregate<T>> : IEntity<T>