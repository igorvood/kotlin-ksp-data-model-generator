package ru.vood.processor.datamodel.newG.meta

import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.model.generator.ksp.common.util.KotlinPoetUtils.controlFlow
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.newG.abstraction.AbstractSingleFileGenerator

class EntityMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
    PackageName("metaEnumP"),//CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    entityEnum
) {

    override fun files(): List<FileSpec> {

        val classBuilder = TypeSpec.enumBuilder(entityEnum)
            .generated(this::class)
            .addAnnotation(CommonClassNames.metaEntities)

        metaInformation.entities.values
            .sortedBy { it.designPoetClassName.simpleName }
            .forEach {
                classBuilder.addEnumConstant(it.designPoetClassName.simpleName)
            }


        val companionObjectBuilder = TypeSpec.companionObjectBuilder()
        val entityMetaByStrFunSpec = FunSpec.builder("entityMetaByStr")
            .returns(entityEnum)
            .addParameter(ParameterSpec("value", string))
            .addCode(
                CodeBlock.builder()
                    .controlFlow("return when(value)") {
                        metaInformation.entities.values
                            .forEach {me ->
                                addStatement(
                                    "%S -> %T.%L",
                                    me.designPoetClassName.simpleName,
                                    entityEnum,
                                    me.designPoetClassName.simpleName
                                )
                            }
//                        addStatement("""else -> error(""${'"'}In Entity ${'$'}{designEntityName} $errText ${'$'}{entityName}""${'"'})""")
                        addStatement("""else -> error(""${'"'}In ${'$'}{EntityEnum::class.java.simpleName} not found enum with name ${'$'}value""${'"'})""")

                    }
                    .build()
            )


            .build()
        companionObjectBuilder
            .addFunction(entityMetaByStrFunSpec)


        classBuilder.addType(companionObjectBuilder.build())
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())


    }
}