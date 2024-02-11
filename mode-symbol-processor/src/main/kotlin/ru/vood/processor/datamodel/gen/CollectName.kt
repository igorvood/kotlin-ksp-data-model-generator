package ru.vood.processor.datamodel.gen

import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.dto.UkName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {
    @Deprecated("Asd")
    fun ukClassName(ukName: UkName): String =
//        """${metaEntity.designClassShortName}_Context_${ukName.value}"""
        """${ukName.value}Context"""

    fun ukClassName(metaEntity: ClassName, ukName: UkName)= ClassName(metaEntity.packageName, "${ukName.value}Context")


    @Deprecated("Asd")
    fun entityClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Entity"""

    fun entityClassName(metaEntity: ClassName): ClassName =
        ClassName(metaEntity.packageName, metaEntity.simpleName + "Entity")


    @Deprecated("Asd")
    fun syntheticClassName(metaEntity: MetaEntity): String =
        """${metaEntity.designClassShortName}Detail"""


    fun syntheticClassName(metaEntity: ClassName) = ClassName(metaEntity.packageName, metaEntity.simpleName + "Detail")

}