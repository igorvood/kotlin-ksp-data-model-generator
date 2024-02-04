package ru.vood.model.generator.ksp.common

import com.squareup.kotlinpoet.asClassName
import ru.vood.model.generator.ksp.common.dto.PackageName
import java.util.concurrent.atomic.AtomicReference
import javax.annotation.processing.Generated

object CommonClassNames {

    private val rootPackage = AtomicReference<PackageName?>(null)
    @Synchronized
    fun setRootPackage(rootPackage : PackageName) {
        this.rootPackage.get() ?:
            this.rootPackage.set(
                rootPackage
            )

    }

    val generated = Generated::class.asClassName()
}