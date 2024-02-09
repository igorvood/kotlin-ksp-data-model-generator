package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames.enumMap
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.indexesMetaDto
import ru.vood.model.generator.ksp.common.CommonClassNames.uKEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor

class IndexesMetaDtoGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = indexesMetaDto,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        propertyInConstructor(
            classBuilder,
            constructor,
            fkPairGeneratorPropertySpecCons
        )

        return classBuilder
            .primaryConstructor(constructor.build())
            .addKdoc("Мета данные по внешнему ключу")
            .addProperty(
                PropertySpec.builder(
                    "ukAndPkMap",
                    enumMap
                        .plusParameter(uniqueKeyEnum)
                        .plusParameter(uKEntityData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin)))
                )
                    .addKdoc("мета по уникальным индексам включая первичный ключ")
                    .initializer("${enumMap.simpleName}(${ukOnlySet.name}.plus(${pkEntityData.name}).associateBy { it.ukName })")
                    .build()
            )

    }


    companion object {
        private val pkEntityData = PropertySpec.builder(
            name = "pkEntityData",
            type = uKEntityData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))
        )
            .addKdoc("Мета по первичному ключу")
            .build()

        private val ukOnlySet = PropertySpec.builder(
            name = "ukOnlySet",
            type = SET.plusParameter(uKEntityData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin)))
        )
            .addKdoc("мета по уникальным индексам, исключая первичный ключ")
            .build()


        val fkPairGeneratorPropertySpec = listOf(pkEntityData, ukOnlySet)

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