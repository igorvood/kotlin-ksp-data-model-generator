package ru.vood.processor.datamodel.gen

import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.dto.UkName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

object CollectName {

    fun ukClassName(metaEntity: ClassName, ukName: UkName) = ClassName(metaEntity.packageName, "${ukName.value}Context")

    fun entityClassName(metaEntity: ClassName): ClassName =
        ClassName(metaEntity.packageName, metaEntity.simpleName + "Entity")

    fun syntheticClassName(metaEntity: ClassName) = ClassName(metaEntity.packageName, metaEntity.simpleName + "Detail")

}