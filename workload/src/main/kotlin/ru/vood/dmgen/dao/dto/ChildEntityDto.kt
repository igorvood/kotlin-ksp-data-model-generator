package ru.vood.dmgen.dao.dto

import ru.vood.dmgen.datamodel.metaEnum.EntityEnum


data class ChildEntityDto(val entityType: EntityEnum, val payload: PayLoadJsonVal)
