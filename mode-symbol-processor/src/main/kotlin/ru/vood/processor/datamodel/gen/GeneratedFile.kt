package ru.vood.processor.datamodel.gen

import ru.vood.model.generator.ksp.common.dto.PackageName

data class GeneratedFile(
    val fileName: FileName,
    val generatedCode: GeneratedCode,
    val packageName: PackageName,
)


@JvmInline
value class FileName(val value: String)

@JvmInline
value class GeneratedCode(val value: String)


