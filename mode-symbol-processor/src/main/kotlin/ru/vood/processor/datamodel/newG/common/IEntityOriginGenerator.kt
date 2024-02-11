package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.serializableEntity
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class IEntityOriginGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage = rootPackage,
    moduleName = iEntityOrigin
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder =
        classBuilder.addKdoc("Оригинал сущности, только поля принадлежащие ей")
            .addSuperinterface(serializableEntity)

}