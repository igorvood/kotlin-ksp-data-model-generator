package ru.vood.processor.datamodel.gen.meta.dto

import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.FKMetaData
import ru.vood.dmgen.intf.newIntf.IMetaForeignData

data class MetaForeignKeysData(
    override val fkMap: Map<FkName, FKMetaData<out IEntityOrigin>>
) : IMetaForeignData
