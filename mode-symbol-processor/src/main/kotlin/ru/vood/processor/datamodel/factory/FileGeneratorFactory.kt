package ru.vood.processor.datamodel.factory

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.generator.ContextDataClassesGenerator
import ru.vood.processor.datamodel.generator.OriginEntityDataClassesGenerator
import ru.vood.processor.datamodel.generator.SyntheticEntityGenerator
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator
import ru.vood.processor.datamodel.generator.common.*
import ru.vood.processor.datamodel.generator.fileMeta.MetaInformationJsonGenerator
import ru.vood.processor.datamodel.generator.fileMeta.PumlGenerator
import ru.vood.processor.datamodel.generator.meta.ColumnEntityMapGenerator
import ru.vood.processor.datamodel.generator.meta.EntityMapGenerator
import ru.vood.processor.datamodel.generator.meta.ForeignKeyMapGenerator
import ru.vood.processor.datamodel.generator.meta.UniqueKeyMapGenerator


class FileGeneratorFactory : IFileGeneratorFactory {
    override fun generators(
     metaInformation: MetaInformation,
     kspLogger: KSPLogger,
     environment: SymbolProcessorEnvironment,
    ): List<AbstractGenerator> {
        val rootPackageCommon = metaInformation.rootPackage
        return listOf(
            SerializableEntitySingleFileGenerator(rootPackageCommon),
            IEntityOriginSingleFileGenerator(rootPackageCommon),
            IEntityDetailSingleFileGenerator(rootPackageCommon),
            IContextOfSingleFileGenerator(rootPackageCommon),
            ColumnEntityDataSingleFileGenerator(rootPackageCommon),
            SimpleColumnEntityDataSingleFileGenerator(rootPackageCommon),
            SyntheticColumnEntityDataSingleFileGenerator(rootPackageCommon),
            SealedSyntheticColumnEntityDataSingleFileGenerator(rootPackageCommon),
            IColExtractFunctionSingleFileGenerator(rootPackageCommon),
            ISyntheticColExtractFunctionSingleFileGenerator(rootPackageCommon),
            SimpleColExtractFunctionSingleFileGenerator(rootPackageCommon),
            SyntheticSingleFileGenerator(rootPackageCommon),
            SyntheticSetSingleFileGenerator(rootPackageCommon),
            IEntityDataSingleFileGenerator(rootPackageCommon),
            EntityDataSingleFileGenerator(rootPackageCommon),
            SealedEntityDataSingleFileGenerator(rootPackageCommon),
            FkPairSingleFileGenerator(rootPackageCommon),
            FKMetaDataSingleFileGenerator(rootPackageCommon),
            UKEntityDataSingleFileGenerator(rootPackageCommon),
            IndexesMetaDtoSingleFileGenerator(rootPackageCommon),
            OriginEntityDataClassesGenerator(metaInformation, kspLogger),
            SyntheticEntityGenerator(metaInformation),
            ContextDataClassesGenerator(metaInformation),
            EntityMapGenerator(rootPackageCommon, metaInformation),
            ColumnEntityMapGenerator(rootPackageCommon, metaInformation),
            PumlGenerator(environment.codeGenerator, metaInformation),
            MetaInformationJsonGenerator(environment.codeGenerator, metaInformation),
            ForeignKeyMapGenerator(rootPackageCommon, metaInformation),
            UniqueKeyMapGenerator(rootPackageCommon, metaInformation),
        )
    }

}
