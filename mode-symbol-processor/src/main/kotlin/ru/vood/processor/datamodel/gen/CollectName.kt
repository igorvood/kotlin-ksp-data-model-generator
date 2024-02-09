package ru.vood.processor.datamodel.gen

import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.dto.UkName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {
    fun ukClassName(ukName: UkName): String =
//        """${metaEntity.designClassShortName}_Context_${ukName.value}"""
        """${ukName.value}Context"""


    fun entityClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Entity"""

    fun entityClassName(metaEntity: ClassName): ClassName = ClassName(metaEntity.packageName, metaEntity.simpleName+"Entity")


    fun syntheticClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Detail"""

}