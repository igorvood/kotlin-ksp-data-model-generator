package ru.vood.processor.datamodel.newG.abstraction

import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageIntfGenerator
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractIntfGenerator(rootPackage: PackageName, moduleName: String) : AbstractGenerator(
    rootPackage = rootPackage,
    subPackage = subPackageIntfGenerator,
    moduleName = moduleName
)
