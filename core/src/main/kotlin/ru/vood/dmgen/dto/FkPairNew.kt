package ru.vood.dmgen.dto

import ru.vood.dmgen.dto.FullColumnName

data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
