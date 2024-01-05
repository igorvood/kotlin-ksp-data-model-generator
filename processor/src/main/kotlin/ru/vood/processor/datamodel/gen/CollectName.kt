package ru.vood.processor.datamodel.gen

import ru.vood.dmgen.dto.UkName1
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {
    fun ukClassName(ukName: UkName1): String =
//        """${metaEntity.designClassShortName}_Context_${ukName.value}"""
        """${ukName.value}Context"""


    fun entityClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Entity"""

    fun syntheticClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Detail"""

}