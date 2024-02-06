package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityData
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.IEntityDataGenerator.Companion.iEntityDataGeneratorPropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator

class SealedEntityDataGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = InterfaceGenerator.GeneratedClasses.SealedEntityData.name,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        columnEntityDataGeneratorPropSpecConstructorImplemented(
            classBuilder,
            constructor,
            entityDataGeneratorPropertySpec
        )

        return classBuilder.addKdoc("Мета данные по сущности")
            .addSuperinterface(iEntityData)
            .primaryConstructor(constructor.build())

    }


    companion object {
        private val entityDataGeneratorPropertySpec = iEntityDataGeneratorPropertySpec
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }
            .plus(
                PropertySpec.builder("children", SET.plusParameter( CommonClassNames.entityEnum))
                    .initializer("%N", "children")
                    .addKdoc("перечень наследников")
                    .build()
            )


        /**перечень наследников*/
//        val children: Set< EntityEnum>

    }

}