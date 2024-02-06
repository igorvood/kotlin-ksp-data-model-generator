package ru.vood.model.generator.ksp.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import ru.vood.dmgen.annotation.FlowEntityType
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
    val flowEntityType = FlowEntityType::class.asClassName()


    val relationType = ru.vood.dmgen.dto.RelationType::class.asClassName()
    val simpleColumnName = ru.vood.dmgen.dto.SimpleColumnName::class.asClassName()
    val simpleColumnType = ru.vood.dmgen.dto.SimpleColumnType::class.asClassName()
    val boolean = Boolean::class.asClassName()
    val string = String::class.asClassName()

    val kClass = ClassName("kotlin.reflect", "KClass")
    val any = ClassName("kotlin", "Any")
    val kSerializer = ClassName("kotlinx.serialization", "KSerializer")

    val nameT = "T"
    val nameOut = "OUT"
    val nameStar = "*"
    val nameSINTH_IN = "SINTH_IN"

    val subPackageAbstractDataDictionaryGenerator = PackageName("metaEnum")
    val subPackageIntfGenerator = PackageName("intf")

    val entityEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "EntityEnum"
        )
    }

    val fullColumnNameEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "FullColumnNameEnum"
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

    val fkPair by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "FkPair"
        )
    }

    val iEntityData by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IEntityData"
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
    val typeVariableSinthIn by lazy { TypeVariableName(nameSINTH_IN) }
    val typeVariableT by lazy { TypeVariableName(nameT) }
    val typeVariableOUT by lazy { TypeVariableName(nameOut) }
    val typeVariableStar by lazy { TypeVariableName(nameStar) }


    val typeVariableF by lazy { TypeVariableName("(entity: T) -> OUT") }
    val typeVariableFConOf by lazy { TypeVariableName("(T) -> IContextOf<out IEntityOrigin>") }
    val typeVariableFQ by lazy { TypeVariableName("(entity: SINTH_IN) -> Set<IEntityDetail<OUT>>") }

    val typeVariableIEntityOrigin by lazy { TypeVariableName(nameT, iEntityOrigin) }
    val typeVariableIEntityOriginOut by lazy { TypeVariableName(nameOut, iEntityOrigin) }

    //    val typeVariableIEntityDetail  by lazy { TypeVariableName(typeVariableSINTH_IN, iEntityDetail) }
    val typeVariableIEntityDetail by lazy {
        TypeVariableName(
            nameSINTH_IN, iEntityDetail.plusParameter(
                TypeVariableName(typeVariableIEntityOrigin.name, KModifier.OUT)
            )
        )
    }


}