package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.SimpleColumnName

@Serializable
data class FkPairJson(
    val from: Pair<EntityName, SimpleColumnName>,
    val to: Pair<EntityName, SimpleColumnName>
)
