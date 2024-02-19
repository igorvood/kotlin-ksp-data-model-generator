package ru.vood.processor.datamodel.generator.abstraction

import com.squareup.kotlinpoet.FileSpec

abstract class AbstractGenerator {


    abstract fun files(): List<FileSpec>
}