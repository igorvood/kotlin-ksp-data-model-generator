package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

fun propertyInConstructor(
    classBuilder: TypeSpec.Builder,
    constructor: FunSpec.Builder,
    propSpec: List<PropertySpec>,
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