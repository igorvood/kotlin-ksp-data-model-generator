package ru.vood.processor.datamodel.gen

import java.io.OutputStream

internal fun OutputStream.appendText(str: String) {
    this.write(str.toByteArray())
}