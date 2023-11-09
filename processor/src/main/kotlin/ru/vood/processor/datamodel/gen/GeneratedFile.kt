package ru.vood.processor.datamodel.gen

data class GeneratedFile(
    val fileName: FileName,
    val generatedCode: GeneratedCode,
    val packageName: PackageName,
)


@JvmInline
value class FileName(val value: String)

@JvmInline
value class GeneratedCode(val value: String)

@JvmInline
value class PackageName(val value: String)
