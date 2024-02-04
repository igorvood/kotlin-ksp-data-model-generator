package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.WildcardTypeName
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.boolean
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.kSerializer
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnName
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class ColumnEntityDataGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage = rootPackage,
    moduleName = InterfaceGenerator.GeneratedClasses.ColumnEntityData.name,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder =
        classBuilder
//            .addTypeVariable(CommonClassNames.typeVariableT)
            .addKdoc("Мета данные по реквизиту сущности")
            .addProperty(
                PropertySpec.builder("entity", entityEnum)
                    .addKdoc("имя сущности")
                    .build()
            )
            .addProperty(
                PropertySpec.builder("simpleColumnName", simpleColumnName)
                    .addKdoc("имя колонки")
                    .build()
            )
            .addProperty(
                PropertySpec.builder("isOptional", boolean)
                    .addKdoc("признак опциональности колонки")
                    .build()
            )
            .addProperty(
                PropertySpec.builder("comment", string)
                    .addKdoc("коментарий колонки")
                    .build()
            )


}