package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.JsonInString
import ru.vood.dmgen.annotation.UkName


interface SerializableEntity {
    val designEntityName: EntityName
}

interface IEntityOrigin : SerializableEntity

interface IEntitySynthetic<T : IEntityOrigin> : IEntityOrigin {

    val origin: T
    fun syntheticField(entityName: EntityName): Set<IEntitySynthetic<out IEntityOrigin>>

}

interface IContextOf<T : IEntityOrigin> : SerializableEntity {

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

    val ktSyntheticEntitySerializer: KSerializer<out IEntitySynthetic<out T>>

}

interface IAggregate : IEntityOrigin