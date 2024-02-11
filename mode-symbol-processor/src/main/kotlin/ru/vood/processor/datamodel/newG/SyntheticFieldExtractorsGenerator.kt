package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.FileSpec
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.newG.abstraction.AbstractEntityGenerator

class SyntheticFieldExtractorsGenerator(
    private val metaInfo: MetaInformation,
    private val kspLogger: KSPLogger,
    ) : AbstractEntityGenerator() {
    override fun files(): List<FileSpec> {
        return  collectEntityFile(metaInfo.metaForeignKeys, metaInfo.aggregateInnerDep(kspLogger))
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<FileSpec> = setOf(),
    ): List<FileSpec> {
        val metaEntity = aggregateInnerDep.metaEntity
        // Имя создаваемого класса
        val classNameStr = CollectName.syntheticClassName(metaEntity.designPoetClassName) //+ "Temp"

        //Создам Файл для класса
        val fileSpec = FileSpec.builder(
            packageName = metaEntity.designPoetClassName.packageName,
            fileName = classNameStr.simpleName+ "Temp"
        )


        // для всех потомков текущего класса рекурсивно вызвать формирование сущностей
        val childrenFiles = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec
//            .addType(classBuilder.build())
            .build()
        )
            .plus(childrenFiles)

    }
}