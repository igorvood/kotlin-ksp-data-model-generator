package ru.vood.processor.datamodel.gen.meta.dto

import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.ColumnEntityData
import ru.vood.dmgen.intf.newIntf.IMetaColumnData

data class MetaColumnsData(
    override val colMap: Map<FullColumnName, ColumnEntityData<out IEntityOrigin>>
) : IMetaColumnData