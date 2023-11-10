package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer



interface Serializer<T>{

    fun ktSerializer() : KSerializer<*>
}

interface IEntity<T: IEntity<T>>: Serializer<T>{

    val designEntityName: EntityName
}
interface IAggregate<T: IAggregate<T>>: IEntity<T>