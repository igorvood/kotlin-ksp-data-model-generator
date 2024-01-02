package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.IEntityOrigin

interface IMetaForeignData {
    val fkMap: Map<FkName, FKMetaData<out IEntityOrigin>>
}



