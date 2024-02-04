package ru.vood.processor.json

import com.charleskorn.kaml.Yaml
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies.Companion.ALL_FILES
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.dmgen.metaJson.FKMetaDataJson
import ru.vood.dmgen.metaJson.IColumnEntityDataJson
import ru.vood.dmgen.metaJson.IEntityDataJson
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.metaInformation
import ru.vood.processor.datamodel.gen.AbstractGenerator
import ru.vood.processor.datamodel.gen.ISideEffect
import ru.vood.processor.datamodel.gen.appendText
import ru.vood.processor.datamodel.gen.meta.ColumnEntityMapGenerator
import ru.vood.processor.datamodel.gen.meta.EntityMapGenerator
import ru.vood.processor.datamodel.gen.meta.ForeignKeyMapGenerator
import java.io.OutputStream
import kotlin.properties.Delegates

class JsonSchemeConfigProcessor(val codeGenerator: CodeGenerator, val logger: KSPLogger) : SymbolProcessor {

    private var file by Delegates.notNull<OutputStream>()

    private val json = Json { prettyPrint = true }

//    private val hocon = Hocon { }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val (symbols: List<KSAnnotated>, metaInformation, rootPackage) = triple(resolver)

        val entityDataJsonList = metaDataJsons(EntityMapGenerator(codeGenerator, rootPackage, logger), metaInformation)
        val columnEntityDataJsonList =
            metaDataJsons(ColumnEntityMapGenerator(codeGenerator, rootPackage, logger), metaInformation)
        val foreignKeyEntityDataJsonList =
            metaDataJsons(ForeignKeyMapGenerator(codeGenerator, rootPackage, logger), metaInformation)

        genJsonAndYml("entityDataJsonList", E(entityDataJsonList), E.serializer())
        genJsonAndYml("columnDataJsonList", C(columnEntityDataJsonList), C.serializer())
        genJsonAndYml("foreignKeyDataJsonList", F(foreignKeyEntityDataJsonList), F.serializer())
        return emptyList()
    }

    private inline fun <reified T> genJsonAndYml(
        fileName: String,
        dataJsonList: T,
        serializer: KSerializer<T>,

        ) {
        kotlin.runCatching {
            file = codeGenerator.createNewFile(
                ALL_FILES,
                "JsonMetaModel",
                fileName, "json"
            )
            val encodeToString = json.encodeToString(dataJsonList)
            file.appendText(encodeToString)

            file.close()
        }


        kotlin.runCatching {
            file = codeGenerator.createNewFile(
                ALL_FILES,
                "JsonMetaModel",
                fileName, "yml"
            )
            val yml = Yaml
            val default = yml.default
            val encodeToString = default.encodeToString(serializer, dataJsonList)
            file.appendText(encodeToString)

            file.close()
        }
    }

    private fun <G, MJ> metaDataJsons(
        entityMapGenerator: G,
        metaInformation: MetaInformation,
    ): List<MJ>
            where G : AbstractGenerator<MetaInformation>,
                  G : ISideEffect<MJ> {
        entityMapGenerator.textGenerator(metaInformation)
        return entityMapGenerator.entityDataJsonList()
    }

    @kotlinx.serialization.Serializable
    data class E(val entities: List<IEntityDataJson>)

    @kotlinx.serialization.Serializable
    data class C(val columns: List<IColumnEntityDataJson>)

    @kotlinx.serialization.Serializable
    data class F(val columns: List<FKMetaDataJson>)


    private fun triple(resolver: Resolver): Triple<List<KSAnnotated>, MetaInformation, PackageName> {
        val symbols: List<KSAnnotated> =
            resolver.getSymbolsWithAnnotation(checkNotNull(FlowEntity::class.qualifiedName)).toList()
        logger.warn("count entities ${symbols.size}")

        val metaInformation = metaInformation(symbols, logger)

        metaInformation.entities.values
            .forEach { metaEntity ->
                logger.warn("read MetaEntity ${metaEntity}", metaEntity.ksAnnotated)
            }


        val setMetaEnt = metaInformation.entities.values.toSet()
        val rootPackage = PackageName(commonPackage(setMetaEnt))
        return Triple(symbols, metaInformation, rootPackage)
    }

    fun commonPackage(setMetaEnt: Set<MetaEntity>): String {
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