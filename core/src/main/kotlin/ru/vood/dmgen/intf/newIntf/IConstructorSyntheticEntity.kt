package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.IEntitySynthetic

interface IConstructorSyntheticEntity<T : IEntityOrigin<T>> {


    fun construct(origin: T, ass: Map<EntityName, Any>): IEntitySynthetic<T>


}


