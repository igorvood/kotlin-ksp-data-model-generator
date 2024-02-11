package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.FileSpec

abstract class AbstractEntityGenerator(
) {


    abstract fun files(): List<FileSpec>
}