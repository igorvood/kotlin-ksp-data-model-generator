package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.FileSpec
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractEntityGenerator(
) {


    abstract fun files(): List<FileSpec>
}