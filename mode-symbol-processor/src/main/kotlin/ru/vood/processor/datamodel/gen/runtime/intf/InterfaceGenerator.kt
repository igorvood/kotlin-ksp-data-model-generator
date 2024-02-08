package ru.vood.processor.datamodel.gen.runtime.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.SimpleColumnType
import ru.vood.dmgen.dto.TypeUk
import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageAbstractDataDictionaryGenerator
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*
import java.util.*
import javax.annotation.processing.Generated

class InterfaceGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger,

    ) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val trimIndent = """
package ${packageName.value}


import kotlinx.serialization.KSerializer
import ${Generated::class.java.canonicalName}
import ${GeneratedClasses.UniqueKeyEnum.getPac(rootPackage)}
import ${SimpleColumnName::class.java.canonicalName}
import ${SimpleColumnType::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}
import ${FlowEntityType::class.java.canonicalName}
import ${RelationType::class.java.canonicalName}.*
import kotlin.reflect.KClass
import ${RelationType::class.java.canonicalName}
import ${TypeUk::class.java.canonicalName}
import ${GeneratedClasses.EntityEnum.getPac(rootPackage)}
import ${GeneratedClasses.FkNameEnum.getPac(rootPackage)}
import ${GeneratedClasses.FullColumnNameEnum.getPac(rootPackage)}


""".trimIndent()
        val generatedFile = GeneratedFile(
            FileName("DataInterfaces"),
            GeneratedCode(trimIndent),
            packageName
        )

        return setOf(generatedFile)
    }

    override val subPackage: PackageName
        get() = interfaceGeneratorPackageName

    companion object {
        val interfaceGeneratorPackageName = PackageName("intf")
    }

    enum class GeneratedClasses(val subPackageName: PackageName) {
        @Deprecated("")
        FKMetaData(interfaceGeneratorPackageName),

        @Deprecated("")
        SealedEntityData(interfaceGeneratorPackageName),

        @Deprecated("")
        UKEntityData(interfaceGeneratorPackageName),

        @Deprecated("")
        FkPair(interfaceGeneratorPackageName),
        EntityEnum(subPackageAbstractDataDictionaryGenerator),
        FkNameEnum(subPackageAbstractDataDictionaryGenerator),
        FullColumnNameEnum(subPackageAbstractDataDictionaryGenerator),
        UniqueKeyEnum(subPackageAbstractDataDictionaryGenerator)
        ;

        fun getPac(root: PackageName) = root.value + "." + subPackageName.value + "." + this
    }
}