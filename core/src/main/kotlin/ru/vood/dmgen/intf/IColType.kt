package ru.vood.dmgen.intf

sealed interface IColType

data class EntityType(
    val entityName: EntityName
): IColType

data class SympleType(
    val simpleColumnType: SimpleColumnType
): IColType