package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.FileSpec
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.newG.abstraction.AbstractEntityGenerator

class ContextDataClassesGenerator (
    private val metaInformation: MetaInformation,
    private val kspLogger: KSPLogger,

    ) : AbstractEntityGenerator() {
    override fun files(): List<FileSpec> {
        val generatedClassData = metaInformation.entities.values.toSet()

        val map = generatedClassData
            .flatMap { metaEntity ->
                metaEntity.uniqueKeysFields
                    .map { ukData -> metaEntity to ukData }
            }


        TODO("Not yet implemented")
    }
}