package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.dmgen.dto.UkName
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.newG.OriginEntityDataClassesGenerator.Companion.designEntityNamePropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractGenerator
import ru.vood.processor.datamodel.newG.common.IContextOfSingleFileGenerator.Companion.ktEntitySerializerPropertySpec
import ru.vood.processor.datamodel.newG.common.IContextOfSingleFileGenerator.Companion.ktSyntheticEntitySerializerPropertySpec
import ru.vood.processor.datamodel.newG.common.IContextOfSingleFileGenerator.Companion.ukNamePropertySpec

class ContextDataClassesGenerator(
    private val metaInformation: MetaInformation,
    private val kspLogger: KSPLogger,

    ) : AbstractGenerator() {
    override fun files(): List<FileSpec> {
        val generatedClassData = metaInformation.entities.values.toSet()

        val map = generatedClassData
            .flatMap { metaEntity ->
                metaEntity.uniqueKeysFields
                    .map { ukData -> metaEntity to ukData }
            }
            .map { contextData ->
                val metaEntity = contextData.first
                val ukName = contextData.second.key.name
                // Имя создаваемого класса
                val ukClassName = CollectName.ukClassName(metaEntity.designPoetClassName, ukName) //+ "Temp"

                //Создам Файл для класса

                val fileSpec = FileSpec.builder(
                    packageName = metaEntity.designPoetClassName.packageName,
                    fileName = ukClassName.simpleName
                )
                val entityClassName = entityClassName(metaEntity.designPoetClassName)
                val syntheticClassName = syntheticClassName(metaEntity.designPoetClassName)
                val classBuilder = TypeSpec.classBuilder(ukClassName)
                    .generated(this::class)
                    .addAnnotation(CommonClassNames.serializable)
                    .addAnnotation(CommonClassNames.modelEntityContext)
                    .addKdoc(metaEntity.comment ?: "Empty comment")
                    .addSuperinterface(CommonClassNames.iContextOf.plusParameter(entityClassName))
                    .addModifiers(KModifier.DATA)
                //надо добавить все свойства в конструктор
                val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
                contextData.second.value.sortedBy { it.name.value }
                    .map { mc ->
                        PropertySpec.builder(mc.name.value, mc.typePoetClassName.copy(nullable = mc.isNullable))
                            .initializer("%N", mc.name.value)
                            .addKdoc(mc.comment)
                            .mutable(false)
                            .build()
                    }
                    .forEach { ps ->
                        val parameterSpec = ParameterSpec.builder(ps.name, ps.type)
                            .addKdoc(ps.kdoc)
                        // надо добавить параметры в конструктор
                        constructor.addParameter(parameterSpec.build())
                        // и также надо добавить эти же св-ва в класс
                        classBuilder.addProperty(ps)
                    }
                // добавить в класс конструктор и геттер
                classBuilder
                    .primaryConstructor(constructor.build())
                    .addProperty(propertySpecEnum(ukNamePropertySpec, ukName))
                    .addProperty(designEntityNamePropertySpec(metaEntity))
                    .addProperty(
                        propertySpecSerializer(
                            PropertySpec.builder(
                                ktEntitySerializerPropertySpec.name,
                                CommonClassNames.kSerializer.plusParameter(entityClassName)
                            )
                                .addKdoc(ktEntitySerializerPropertySpec.kdoc)
                                .build(),
                            entityClassName
                        )
                    )
                    .addProperty(
                        propertySpecSerializer(
                            PropertySpec.builder(
                                ktSyntheticEntitySerializerPropertySpec.name,
                                CommonClassNames.kSerializer.plusParameter(
                                    syntheticClassName

                                )
                            )
                                .addKdoc(ktSyntheticEntitySerializerPropertySpec.kdoc)
                                .build(),
                            syntheticClassName(metaEntity.designPoetClassName)
                        )
                    )

                fileSpec.addType(classBuilder.build()).build()

            }




        return map
    }

    companion object {
        private fun propertySpecEnum(
            propertySpec: PropertySpec,
            ukName: UkName,
        ) =
            PropertySpec.builder(propertySpec.name, propertySpec.type)
                .addKdoc(propertySpec.kdoc)
                .addModifiers(KModifier.OVERRIDE)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode(
                            "return %T.%L",
                            propertySpec.type,
                            ukName.value
                        )
                        .build()
                )
                .build()

        private fun propertySpecSerializer(
            propertySpec: PropertySpec,
            poetClassName: ClassName,
        ) =
            PropertySpec.builder(propertySpec.name, propertySpec.type)
                .addKdoc(propertySpec.kdoc)
                .addModifiers(KModifier.OVERRIDE)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode(
                            "return %T.serializer()",
                            poetClassName
                        )
                        .build()
                )
                .build()

    }
}