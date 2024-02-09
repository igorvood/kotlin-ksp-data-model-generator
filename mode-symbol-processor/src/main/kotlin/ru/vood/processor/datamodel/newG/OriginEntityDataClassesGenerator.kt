package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.newG.SerializableEntityGenerator.Companion.designEntityNamePropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractEntityGenerator

class OriginEntityDataClassesGenerator(
    private val metaInformation: MetaInformation,
    private val kspLogger: KSPLogger,

    ) : AbstractEntityGenerator() {

    override fun files(): List<FileSpec> {
        return collectEntityFile(metaInformation.metaForeignKeys, metaInformation.aggregateInnerDep(kspLogger))
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<FileSpec> = setOf(),
    ): List<FileSpec> {
        val metaEntity = aggregateInnerDep.metaEntity
        val classNameStr = CollectName.entityClassName(metaEntity) + "Temp"
        val fileSpec = FileSpec.builder(
            packageName = metaEntity.designClassPackageName,
            fileName = classNameStr
        )

        val classBuilder = TypeSpec.classBuilder(classNameStr)
            .generated(this::class)
            .addKdoc(metaEntity.comment ?: "Empty comment")
            .addSuperinterface(metaEntity.designPoetClassName)
            .addSuperinterface(iEntityOrigin)
            .addModifiers(KModifier.DATA)

        val propSpec = metaEntity.fields
            .sortedBy { it.position }
            .map { col ->
                PropertySpec.builder(col.name.value, col.typePoetClassName)
                    .initializer("%N", col.name.value)
                    .addKdoc(col.comment ?: "Empty comment")
                    .addModifiers(KModifier.OVERRIDE)
                    .build()
            }
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        propSpec
            .forEach { ps ->
                constructor.addParameter(
                    ParameterSpec.builder(ps.name, ps.type)
                        .addKdoc(ps.kdoc)
                        .build()
                )
                classBuilder.addProperty(ps)
            }


        val getter = PropertySpec.builder(designEntityNamePropertySpec.name, designEntityNamePropertySpec.type)
            .addKdoc(designEntityNamePropertySpec.kdoc)
            .addModifiers(KModifier.OVERRIDE)
            .getter(
                FunSpec.getterBuilder()
                    .addCode("return %T.%L", designEntityNamePropertySpec.type, metaEntity.designPoetClassName.simpleName)
                    .build()
            )
            .build()


        val designEntityNameFunSpec = FunSpec.getterBuilder()
//            .addParameter(ParameterSpec(designEntityNamePropertySpec.name, designEntityNamePropertySpec.type))
//            .addTypeVariable(TypeVariableName(designEntityNamePropertySpec.name))
            .addKdoc(designEntityNamePropertySpec.kdoc)
            .addModifiers(KModifier.OVERRIDE)
//            .addStatement("%T.ObjectValue(_sourceValue.origin(), mapOf())", ConfigClassNames.configValue)
//            .returns(designEntityNamePropertySpec.type)
            .build()

        classBuilder
            .primaryConstructor(constructor.build())
            .addProperty(getter)


        val map = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()


        return listOf(fileSpec.addType(classBuilder.build()).build()).plus(map)
    }
}