package ru.vood.dmgen.intf.dto

//@JvmInline
//@kotlinx.serialization.Serializable
data class EncodeTo<out T>(
    val data: T
)