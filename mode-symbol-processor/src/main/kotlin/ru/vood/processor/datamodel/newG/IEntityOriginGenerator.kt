package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.serializableEntity
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class IEntityOriginGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage,
    InterfaceGenerator.GeneratedClasses.IEntityOrigin.name
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder =
        classBuilder.addKdoc("Оригинал сущности, только поля принадлежащие ей")
            .addSuperinterface(serializableEntity)

}