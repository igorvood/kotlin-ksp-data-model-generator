package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.fkPair
import ru.vood.model.generator.ksp.common.CommonClassNames.fullColumnNameEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator

class FkPairGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = fkPair,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        columnEntityDataGeneratorPropSpecConstructorImplemented(
            classBuilder,
            constructor,
            fkPairGeneratorPropertySpecCons
        )

        return classBuilder
            .primaryConstructor(constructor.build())

    }


    companion object {
        private val from = PropertySpec.builder(
            name = "from",
            type = fullColumnNameEnum
        ).build()

        private val to = PropertySpec.builder(
            name = "to",
            type = fullColumnNameEnum
        )

//            .addKdoc("сериализатор синтетической сущности")
            .build()

        val fkPairGeneratorPropertySpec = listOf(from, to)

        private val fkPairGeneratorPropertySpecCons = fkPairGeneratorPropertySpec
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
//                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }


    }

}