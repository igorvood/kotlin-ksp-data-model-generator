package ru.vood.dmgen.annotation

import ru.vood.dmgen.dto.FullColumnName

data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
