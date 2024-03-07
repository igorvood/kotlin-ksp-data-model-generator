package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.ksp.writeTo
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.runBlocking
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.model.generator.ksp.common.BaseSymbolProcessor
import ru.vood.processor.datamodel.abstraction.model.MetaCollector.collectMetaInformation
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.factory.IFileGeneratorFactory
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator

class DataModelConfigProcessor(
    environment: SymbolProcessorEnvironment,
    private val fileGeneratorFactory: IFileGeneratorFactory,
) : BaseSymbolProcessor(environment) {

    private val codeGenerator = environment.codeGenerator


    lateinit var metaInformation: MetaInformation

    override fun processRound(resolver: Resolver): List<KSAnnotated> {

        kspLogger.warn("KSP options " + environment.options)

        val nullableProbSetDefaultNull =
            environment.options["nullableProbSetDefaultNull"]?.let { it.toBoolean() } ?: false


        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()

        metaInformation = collectMetaInformation(symbols, kspLogger, nullableProbSetDefaultNull)

        return symbols
    }

    override fun finish() {
        val listOf: List<AbstractGenerator> = fileGeneratorFactory.generators(metaInformation, kspLogger, environment)
//        val rootPackageCommon = metaInformation.rootPackage
//        val listOf: List<AbstractGenerator> = listOf(
//            SerializableEntitySingleFileGenerator(rootPackageCommon),
//            IEntityOriginSingleFileGenerator(rootPackageCommon),
//            IEntityDetailSingleFileGenerator(rootPackageCommon),
//            IContextOfSingleFileGenerator(rootPackageCommon),
//            ColumnEntityDataSingleFileGenerator(rootPackageCommon),
//            SimpleColumnEntityDataSingleFileGenerator(rootPackageCommon),
//            SyntheticColumnEntityDataSingleFileGenerator(rootPackageCommon),
//            SealedSyntheticColumnEntityDataSingleFileGenerator(rootPackageCommon),
//            IColExtractFunctionSingleFileGenerator(rootPackageCommon),
//            ISyntheticColExtractFunctionSingleFileGenerator(rootPackageCommon),
//            SimpleColExtractFunctionSingleFileGenerator(rootPackageCommon),
//            SyntheticSingleFileGenerator(rootPackageCommon),
//            SyntheticSetSingleFileGenerator(rootPackageCommon),
//            IEntityDataSingleFileGenerator(rootPackageCommon),
//            EntityDataSingleFileGenerator(rootPackageCommon),
//            SealedEntityDataSingleFileGenerator(rootPackageCommon),
//            FkPairSingleFileGenerator(rootPackageCommon),
//            FKMetaDataSingleFileGenerator(rootPackageCommon),
//            UKEntityDataSingleFileGenerator(rootPackageCommon),
//            IndexesMetaDtoSingleFileGenerator(rootPackageCommon),
//            OriginEntityDataClassesGenerator(metaInformation, kspLogger),
//            SyntheticEntityGenerator(metaInformation),
//            ContextDataClassesGenerator(metaInformation),
//            EntityMapGenerator(rootPackageCommon, metaInformation),
//            ColumnEntityMapGenerator(rootPackageCommon, metaInformation),
//            PumlGenerator(environment.codeGenerator, metaInformation),
//            MetaInformationJsonGenerator(environment.codeGenerator, metaInformation),
//            ForeignKeyMapGenerator(rootPackageCommon, metaInformation),
//            UniqueKeyMapGenerator(rootPackageCommon, metaInformation),
//        )
        runBlocking {
            listOf
                .asFlow()
                .flatMapConcat { q -> q.files().asFlow() }
                .collect { fs ->
                    kotlin.runCatching {
                        fs.writeTo(codeGenerator = codeGenerator, aggregating = true)
                        kspLogger.logging("generated ${fs.name} ")
                    }
                }

        }
        super.finish()
    }

}