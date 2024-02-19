package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.fkNameEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.relationType
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityOrigin
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractIntfSingleFileGenerator

class IEntityDetailSingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = iEntityDetail
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val builder = CodeBlock.builder()
        builder.add(
            """  return when(%T.getFk(entityName, origin.designEntityName).relationType){
            %T.MANY_TO_ONE -> syntheticFieldSet(entityName)
            %T.ONE_TO_ONE_MANDATORY -> setOf( syntheticFieldMandatory(entityName))
            %T.ONE_TO_ONE_OPTIONAL -> syntheticFieldOptional(entityName)?.let { setOf(it) }?: setOf()
        }""", fkNameEnum, relationType, relationType, relationType
        )
        val syntheticFieldFunSpec = FunSpec.builder("syntheticField")
            .addParameter(ParameterSpec("entityName", CommonClassNames.entityEnum))
            .returns(SET.plusParameter(returnType))
            .addCode(builder.build())
            .build()
        return classBuilder.addKdoc("Оригинал сущности, только поля принадлежащие ей")
            .addSuperinterface(iEntityOrigin)
            .addTypeVariable(typeVariableIEntityOrigin)
            .addProperty(originPropertySpec)
            .addFunction(syntheticFieldOptionalFunSpec)
            .addFunction(syntheticFieldMandatoryFunSpec)
            .addFunction(syntheticFieldSetFunSpec)
            .addFunction(syntheticFieldFunSpec)
    }

    companion object {
        val originPropertySpec = PropertySpec.builder("origin", typeVariableIEntityOrigin)
            .addKdoc("Детальная сущность, с иными сущностями имеющими на текущую внешний ключ")
            .build()

        val returnType = iEntityDetail.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))

        val syntheticFieldOptionalFunSpec = FunSpec.builder("syntheticFieldOptional")
            .addKdoc("Для опциональных сущностей. По имени сущности имеющей fk на текущую возвращает ее экземляр.")
            .addParameter(ParameterSpec("entityName", CommonClassNames.entityEnum))
            .returns(returnType.copy(nullable = true))
            .addModifiers(KModifier.ABSTRACT)
//                    .addCode("""TODO("method need implementation")""")
            .build()
        val syntheticFieldMandatoryFunSpec = FunSpec.builder("syntheticFieldMandatory")
            .addKdoc("Для обязательных сущностей. По имени сущности имеющей fk на текущую возвращает ее экземляр.")
            .addParameter(ParameterSpec("entityName", CommonClassNames.entityEnum))
            .returns(returnType)
            .addModifiers(KModifier.ABSTRACT)
//                    .addCode("""TODO("method need implementation")""")
            .build()
        val syntheticFieldSetFunSpec = FunSpec.builder("syntheticFieldSet")
            .addKdoc("Для сущностей имеющих связь, много к одному к текущей. По имени сущности имеющей fk на текущую возвращает ее экземляр.")
            .addParameter(ParameterSpec("entityName", CommonClassNames.entityEnum))
            .returns(SET.plusParameter(returnType))
            .addModifiers(KModifier.ABSTRACT)
//                    .addCode("""TODO("method need implementation")""")
            .build()


    }

}