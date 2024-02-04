package ru.vood.model.generator.ksp.common

import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.dto.PackageName
import java.util.concurrent.atomic.AtomicReference
import javax.annotation.processing.Generated



object CommonClassNames {

    private val rootPackageAtomicReference = AtomicReference<PackageName?>(null)

    private val rootPackage by lazy { rootPackageAtomicReference.get()!! }

    @Synchronized
    fun setRootPackage(rootPackage: PackageName) {
        this.rootPackageAtomicReference.get() ?: this.rootPackageAtomicReference.set(
            rootPackage
        )
    }

    val generated = Generated::class.asClassName()
    val jvmInline = JvmInline::class.asClassName()

    val relationType = ru.vood.dmgen.dto.RelationType::class.asClassName()
    val simpleColumnName = ru.vood.dmgen.dto.SimpleColumnName::class.asClassName()
    val simpleColumnType = ru.vood.dmgen.dto.SimpleColumnType::class.asClassName()
    val boolean = Boolean::class.asClassName()
    val string = String::class.asClassName()

    val kSerializer = ClassName("kotlinx.serialization", "KSerializer")

    val nameT = "T"
    val nameOut = "OUT"
    val nameStar = "*"

    val subPackageAbstractDataDictionaryGenerator = PackageName("metaEnum")
    val subPackageIntfGenerator = PackageName("intf")

    val entityEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "EntityEnum"
        )
    }

    val uniqueKeyEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "UniqueKeyEnum"
        )
    }

    val serializableEntity by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "SerializableEntity"
        )
    }

    val iSyntheticColExtractFunction by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "ISyntheticColExtractFunction"
        )
    }

    val synthetic by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "Synthetic"
        )
    }

    val simpleColExtractFunction by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "SimpleColExtractFunction"
        )
    }

    val iColExtractFunction by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IColExtractFunction"
        )
    }

    val iEntityOrigin by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IEntityOrigin"
        )
    }

    val iEntityDetail by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IEntityDetail"
        )
    }

    val columnEntityData by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "ColumnEntityData"
        )
    }

    val iContextOf by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IContextOf"
        )
    }


    val fkNameEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "FkNameEnum"
        )
    }

    val typeVariableT  by lazy { TypeVariableName(nameT) }
    val typeVariableOUT  by lazy { TypeVariableName(nameOut) }
    val typeVariableStar  by lazy { TypeVariableName(nameStar) }

    val typeVariableF  by lazy { TypeVariableName("(entity: T) -> OUT") }

    val typeVariableIEntityOrigin  by lazy { TypeVariableName(nameT, iEntityOrigin) }


}