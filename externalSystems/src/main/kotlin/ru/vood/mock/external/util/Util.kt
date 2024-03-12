package ru.vood.mock.external

import kotlin.math.abs

fun <T> T.hashCode(outHash: Int) = outHash + this.hashCode()


fun <T> T.hashCodeLimited(outHash: Int, limitSize: Int) = abs(this.hashCode(outHash)) % limitSize



