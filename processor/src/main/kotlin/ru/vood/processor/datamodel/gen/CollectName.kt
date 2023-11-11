package ru.vood.processor.datamodel.gen

import ru.vood.dmgen.annotation.UkName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {
    fun ukClassName(metaEntity: MetaEntity, ukName: UkName): String =
        """${metaEntity.shortName}_Context_${ukName.value}"""
}