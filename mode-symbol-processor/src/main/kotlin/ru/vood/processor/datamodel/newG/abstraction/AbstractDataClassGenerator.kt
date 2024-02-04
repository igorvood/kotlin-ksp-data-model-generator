package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageIntfGenerator
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractDataClassGenerator(
    rootPackage: PackageName,
    moduleName: String,
) : AbstractGenerator(
    rootPackage = rootPackage,
    subPackage = subPackageIntfGenerator,
    moduleName = moduleName,

    ) {

    override fun files(): List<FileSpec> {
        val classBuilder = TypeSpec.classBuilder(moduleName)
            .generated(this::class)
            .addModifiers(KModifier.DATA)

        return listOf(fileSpec.addType(fillInterfaceBuilder(classBuilder).build()).build())
    }

    abstract fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder

    protected fun columnEntityDataGeneratorPropSpecConstructorImplemented(
        classBuilder: TypeSpec.Builder,
        constructor: FunSpec.Builder,
        propSpec: List<PropertySpec>
    ) {
        propSpec
            .forEach { ps ->
                constructor.addParameter(
                    ParameterSpec.builder(ps.name, ps.type)
                        .build()
                )
                classBuilder.addProperty(ps)
            }
    }
}
