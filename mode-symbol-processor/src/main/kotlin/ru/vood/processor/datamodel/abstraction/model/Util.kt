package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSNode


fun KSPLogger.kspError(message: String, symbol: KSNode? = null): Nothing {
    this.error(message, symbol)
    throw java.lang.IllegalStateException(message)
}

