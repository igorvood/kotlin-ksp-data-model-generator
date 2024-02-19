package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSNode


inline fun KSPLogger.kspError(message: String, symbol: KSNode? = null): Nothing {
    this.error(message, symbol)
    throw java.lang.IllegalStateException(message)
}

//fun logging(message: String, symbol: KSNode? = null)
//fun info(message: String, symbol: KSNode? = null)
//fun warn(message: String, symbol: KSNode? = null)
//fun error(message: String, symbol: KSNode? = null)
