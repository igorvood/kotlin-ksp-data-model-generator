package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.JsonInString
import ru.vood.dmgen.annotation.UkName


interface SerializableEntity<T> {
    val designEntityName: EntityName
    fun ktSerializer(): KSerializer<out SerializableEntity<out T>>

    fun toJson(json: Json): JsonInString =
        JsonInString(json.encodeToString(ktSerializer() as KSerializer<SerializableEntity<out T>>, this))

    fun castedKSerializer(): KSerializer<SerializableEntity<T>> = ktSerializer() as KSerializer<SerializableEntity<T>>

    fun <SERIALISED_TYPE> serialiseIt(s: (SerializableEntity<T>) -> SERIALISED_TYPE): SERIALISED_TYPE {
        return s(this)
    }

}

interface IEntityOrigin<T : IEntityOrigin<T>> : SerializableEntity<T> {


}

//interface IEntityOrigin<T : IEntityOrigin<T>> : IEntity<T>

interface IEntitySynthetic<T : IEntityOrigin<T>> : IEntityOrigin<T> {

    val origin: T

    fun syntheticField(entityName: EntityName): Set<IEntitySynthetic<out IEntityOrigin<*>>>

//    fun <OUT> syntheticDtoEncodeTo(
//        serializer: (
////            IEntitySynthetic<in T >
//        ) -> EncodeTo<OUT>): EncodeTo<OUT>

}

interface IContextOf<T : IEntityOrigin<T>> : SerializableEntity<T> {

//    val metaEntity: EntityName

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

    val ktSyntheticEntitySerializer: KSerializer<out IEntitySynthetic<out T>>

}

interface IAggregate<T : IAggregate<T>> : IEntityOrigin<T>