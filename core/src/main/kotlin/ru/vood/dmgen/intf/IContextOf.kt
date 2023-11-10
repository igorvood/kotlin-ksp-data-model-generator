package ru.vood.dmgen.intf

import ru.vood.dmgen.annotation.UkName

interface IContextOf<ENT : IEntity<out ENT>> : Serializer<IContextOf<ENT>> {

    val metaEntity: IMetaEntity

//    val ukName: UkName
}