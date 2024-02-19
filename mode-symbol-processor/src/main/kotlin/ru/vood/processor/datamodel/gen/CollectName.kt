package ru.vood.processor.datamodel.gen

import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.dto.UkName

object CollectName {

    fun ukClassName(metaEntity: ClassName, ukName: UkName) = ClassName(metaEntity.packageName, "${ukName.value}Context")

    fun entityClassName(metaEntity: ClassName): ClassName =
        ClassName(metaEntity.packageName, metaEntity.simpleName + "Entity")

    fun syntheticClassName(metaEntity: ClassName) = ClassName(metaEntity.packageName, metaEntity.simpleName + "Detail")

}