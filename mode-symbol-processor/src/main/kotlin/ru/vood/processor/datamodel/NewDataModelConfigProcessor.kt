package ru.vood.processor.datamodel

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.ksp.writeTo
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.model.generator.ksp.common.BaseSymbolProcessor
import ru.vood.processor.datamodel.abstraction.model.MetaCollector.collectMetaInformation
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.newG.ContextDataClassesGenerator
import ru.vood.processor.datamodel.newG.OriginEntityDataClassesGenerator
import ru.vood.processor.datamodel.newG.SyntheticEntityGenerator
import ru.vood.processor.datamodel.newG.common.*
import ru.vood.processor.datamodel.newG.fileMeta.PumlGenerator
import ru.vood.processor.datamodel.newG.meta.ColumnEntityMapGenerator
import ru.vood.processor.datamodel.newG.meta.EntityMapGenerator

class NewDataModelConfigProcessor(
    environment: SymbolProcessorEnvironment,
) : BaseSymbolProcessor(environment) {

    private val codeGenerator = environment.codeGenerator


    private lateinit var metaInformation: MetaInformation
//    private var rootPackage: PackageName? = null

    override fun processRound(resolver: Resolver): List<KSAnnotated> {

        kspLogger.warn("KSP options " + environment.options)

        val nullableProbSetDefaultNull =
            environment.options["nullableProbSetDefaultNull"]?.let { it.toBoolean() } ?: false


        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()

        metaInformation = collectMetaInformation(symbols, kspLogger, nullableProbSetDefaultNull)

//        val setMetaEnt = metaInformation.entities.values.toSet()

//        rootPackage = PackageName(commonPackage(setMetaEnt))
//        CommonClassNames.setRootPackage(rootPackage!!)
        return symbols
    }

    override fun finish() {
        val rootPackageCommon = metaInformation.rootPackage
        val listOf = listOf(
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
            SyntheticEntityGenerator(metaInformation, kspLogger),
            ContextDataClassesGenerator(metaInformation, kspLogger),
            EntityMapGenerator(rootPackageCommon, metaInformation),
            ColumnEntityMapGenerator(rootPackageCommon, metaInformation),
            PumlGenerator(environment.codeGenerator, metaInformation)
        )
        runBlocking {
            listOf
                .asFlow()
                .map { q -> q.files().asFlow() }
                .flatMapConcat { it }
                .collect { fs ->
                    kotlin.runCatching {
                        fs.writeTo(codeGenerator = codeGenerator, aggregating = true)
                        kspLogger.logging("generated ${fs.name} ")
                    }
                }

        }
        super.finish()
    }


    companion object {
        internal fun commonPackage(setMetaEnt: Set<MetaEntity>): String {
            tailrec fun commonPackageRecurcive(currentPackage: String, packacges: List<String>): String {
                return when (packacges.isEmpty()) {
                    true -> currentPackage
                    false -> {
                        val nextPack = packacges[0]

                        var collector = ""

                        for (q in nextPack.withIndex()) {
                            if (currentPackage.getOrElse(q.index) { '~' } == q.value) {
                                collector = collector.plus(q.value)
                            } else {
                                break
                            }
                        }

                        commonPackageRecurcive(collector, packacges.drop(1))
                    }
                }

            }

            val toList = setMetaEnt.toList().map { it.designPoetClassName.packageName }
            val value = toList[0]
            return commonPackageRecurcive(value, toList.drop(1))
        }
    }
}