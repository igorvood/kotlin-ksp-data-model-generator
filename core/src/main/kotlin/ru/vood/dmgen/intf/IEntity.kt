package ru.vood.dmgen.intf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.UkName


interface Serializer<T>{

    fun ktSerializer() : KSerializer<*>
}

interface IEntity<T: IEntity<T>>: Serializer<T>{

    val designEntityName: EntityName
}

interface IContextOf<ENT : IEntity<out ENT>> : Serializer<IContextOf<ENT>> {

    val metaEntity: IMetaEntity

    val ukName: UkName
}
interface IAggregate<T: IAggregate<T>>: IEntity<T>