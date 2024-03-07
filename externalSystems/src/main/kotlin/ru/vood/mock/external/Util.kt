package ru.vood.mock.external

import ru.vood.dmgen.dto.SimpleColumnName

fun SimpleColumnName.hashCode(outHash: Int) = outHash + this.value.hashCode()