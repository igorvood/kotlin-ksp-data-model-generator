package ru.vood.processor.datamodel.gen

import ru.vood.dmgen.annotation.UkName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {
    fun ukClassName(metaEntity: MetaEntity, ukName: UkName): String =
//        """${metaEntity.designClassShortName}_Context_${ukName.value}"""
    """${ukName.value}Context"""


    fun entityClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Entity"""

}