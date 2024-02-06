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
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaCollector.collectMetaInformation
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.newG.*

class NewDataModelConfigProcessor(
    environment: SymbolProcessorEnvironment,
) : BaseSymbolProcessor(environment) {

    private val codeGenerator = environment.codeGenerator


    private lateinit var metaInformation: MetaInformation
    private var rootPackage: PackageName? = null

    override fun processRound(resolver: Resolver): List<KSAnnotated> {
        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()

        metaInformation = collectMetaInformation(symbols, kspLogger)

        val setMetaEnt = metaInformation.entities.values.toSet()

        rootPackage = PackageName(commonPackage(setMetaEnt))
        CommonClassNames.setRootPackage(rootPackage!!)
        return symbols
    }

    override fun finish() {
        val rootPackageCommon = rootPackage!!
        val listOf = listOf(
            SerializableEntityGenerator(rootPackageCommon),
            IEntityOriginGenerator(rootPackageCommon),
            IEntityDetailGenerator(rootPackageCommon),
            IContextOfGenerator(rootPackageCommon),
            ColumnEntityDataGenerator(rootPackageCommon),
            SimpleColumnEntityDataGenerator(rootPackageCommon),
            SyntheticColumnEntityDataGenerator(rootPackageCommon),
            SealedSyntheticColumnEntityDataGenerator(rootPackageCommon),
            IColExtractFunctionGenerator(rootPackageCommon),
            ISyntheticColExtractFunctionGenerator(rootPackageCommon),
            SimpleColExtractFunctionGenerator(rootPackageCommon),
            SyntheticGenerator(rootPackageCommon),
            SyntheticSetGenerator(rootPackageCommon),
            IEntityDataGenerator(rootPackageCommon),
            EntityDataGenerator(rootPackageCommon),
            SealedEntityDataGenerator(rootPackageCommon),
            FkPairGenerator(rootPackageCommon),
            FKMetaDataGenerator(rootPackageCommon),
            UKEntityDataGenerator(rootPackageCommon),
            IndexesMetaDtoGenerator(rootPackageCommon),
        )
        runBlocking {
            listOf
                .asFlow()
                .map { q -> q.files().asFlow() }
                .flatMapConcat { it }
                .collect { fs ->
                    kspLogger.logging("generate ${fs.name} ")
                    fs.writeTo(codeGenerator = codeGenerator, aggregating = true)
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

            val toList = setMetaEnt.toList().map { it.designClassPackageName }
            val value = toList[0]
            return commonPackageRecurcive(value, toList.drop(1))
        }
    }
}