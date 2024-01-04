package ru.vood.dmgen.annotation

import ru.vood.dmgen.intf.FullColumnName

data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
