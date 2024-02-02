package ru.vood.processor.json

import com.charleskorn.kaml.Yaml
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies.Companion.ALL_FILES
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.dmgen.metaJson.IEntityDataJson
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.metaInformation
import ru.vood.processor.datamodel.gen.PackageName
import ru.vood.processor.datamodel.gen.appendText
import ru.vood.processor.datamodel.gen.meta.EntityMapGenerator
import java.io.OutputStream
import kotlin.properties.Delegates

class JsonSchemeConfigProcessor(val codeGenerator: CodeGenerator, val logger: KSPLogger) : SymbolProcessor {

    private var file by Delegates.notNull<OutputStream>()

    private val json = Json { prettyPrint = true }

//    private val hocon = Hocon { }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val (symbols: List<KSAnnotated>, metaInformation, rootPackage) = triple(resolver)

        val entityMapGenerator = EntityMapGenerator(codeGenerator, rootPackage, logger)
        entityMapGenerator.textGenerator(metaInformation)
        val entityDataJsonList = entityMapGenerator.entityDataJsonList()

//        file = codeGenerator.createNewFileByPath(ALL_FILES, "qwerty", "json")
        kotlin.runCatching {
            file = codeGenerator.createNewFile(
                ALL_FILES,
//            Dependencies(
//                false,
//            ),
                "JsonMetaModel",
                "entityDataJsonList", "json"
            )
            val encodeToString = json.encodeToString(entityDataJsonList)
            file.appendText(encodeToString)

            file.close()
        }


        kotlin.runCatching {
            file = codeGenerator.createNewFile(
                ALL_FILES,
                "JsonMetaModel",
                "entityDataJsonList", "yml"
            )
            val yml = Yaml
            val default = yml.default

            val encodeToString = default.encodeToString(Q.serializer(), Q(entityDataJsonList))
            file.appendText(encodeToString)

            file.close()
        }
        return emptyList()
    }

    @kotlinx.serialization.Serializable
    data class Q(val asd: List<IEntityDataJson>)

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