package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.WildcardTypeName
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.iContextOf
import ru.vood.model.generator.ksp.common.CommonClassNames.kSerializer
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractIntfSingleFileGenerator

class IContextOfSingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = iContextOf
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {

        return classBuilder
            .addSuperinterface(CommonClassNames.serializableEntity)
            .addTypeVariable(CommonClassNames.typeVariableIEntityOrigin)
            .addKdoc("контекст сущности")
            .addProperty(ukNamePropertySpec)
            .addProperty(ktEntitySerializerPropertySpec)
            .addProperty(ktSyntheticEntitySerializerPropertySpec)
    }

    companion object {
        val ukNamePropertySpec = PropertySpec.builder("ukName", uniqueKeyEnum)
            .addKdoc("Мета информация по уникальному ключу")
            .build()
        val ktEntitySerializerPropertySpec =
            PropertySpec.builder("ktEntitySerializer", kSerializer.plusParameter(typeVariableT))
                .addKdoc("Сериализатор оригинальной сущности")
                .build()
        val ktSyntheticEntitySerializerPropertySpec = PropertySpec.builder(
            "ktSyntheticEntitySerializer", kSerializer.plusParameter(
                WildcardTypeName.producerOf(
                    CommonClassNames.iEntityDetail.plusParameter(
                        WildcardTypeName.producerOf(typeVariableT)
                    )
                )
            )
        )
            .addKdoc("Сериализатор детальной(аггрегированной) сущности")
            .build()
    }

}