package ru.vood.processor.datamodel.generator.config

import kotlinx.serialization.json.Json

val jsonSerializer = Json {
    prettyPrint = true
    allowStructuredMapKeys = true
}