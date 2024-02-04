package ru.vood.model.generator.ksp.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asClassName
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
    val subPackageAbstractDataDictionaryGenerator = PackageName("metaEnum")
    val subPackageIntfGenerator = PackageName("newintf")

    val entityEnum by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageAbstractDataDictionaryGenerator.value}",
            "EntityEnum"
        )
    }

    val serializableEntity by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "SerializableEntity"
        )
    }

    val iEntityOrigin by lazy {
        ClassName(
            "${rootPackage.value}.${subPackageIntfGenerator.value}",
            "IEntityOrigin"
        )
    }


}