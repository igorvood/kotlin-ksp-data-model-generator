import ru.vood.dmgen.annotation.*

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal",
    name = "DealParamOneToOne_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Uk(
    "DealParamOneToOne_UK",
    ["dealId", "paramDate"]
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamOneToOne {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val paramDate: String
}

@FlowEntity
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal",
    name = "DealParamOneToOneOptional_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamOneToOneOptional {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val paramDate: String
}

@FlowEntity//(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal",
    name = "DealParamSet_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamSet {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: Int

    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val id: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val paramDate: String
}

@FlowEntity//(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal",
    name = "DealParamSetNoUK_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamSetNoUK {

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: Int


    @Comment("Параметр сделки, отношение к сделке один к одному")
    val id: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val paramDate: String
}
