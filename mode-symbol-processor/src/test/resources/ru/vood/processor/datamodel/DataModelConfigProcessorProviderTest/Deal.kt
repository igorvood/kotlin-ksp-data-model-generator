import ru.vood.dmgen.annotation.*

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: Int
}