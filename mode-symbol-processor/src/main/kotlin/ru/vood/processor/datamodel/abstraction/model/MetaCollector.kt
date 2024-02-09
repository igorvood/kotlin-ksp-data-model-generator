package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSAnnotated
import java.util.concurrent.atomic.AtomicReference

object MetaCollector {


    private lateinit var annotatedDataClasses: List<KSAnnotated>
    private lateinit var logger: KSPLogger

    private val metaInform: AtomicReference<MetaInformation?> = AtomicReference(null)

    fun collectMetaInformation(
        annotatedDataClasses: List<KSAnnotated>,
        logger: KSPLogger,
        nullableProbSetDefaultNull: Boolean
    ): MetaInformation {
        return if (metaInform.get() != null) {
            metaInform.get()!!
        } else {
            this.annotatedDataClasses = annotatedDataClasses
            this.logger = logger

            metaInform.set(metaInformation(annotatedDataClasses, logger, nullableProbSetDefaultNull))
            metaInform.get()!!
        }

    }

}