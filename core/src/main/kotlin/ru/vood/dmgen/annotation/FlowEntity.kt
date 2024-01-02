package ru.vood.dmgen.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlowEntity(
    val entityType: FlowEntityType = FlowEntityType.INNER,
    @Deprecated("Пока функционал обработки поля до конца не написан")
    val entityName: String = "",
)

enum class FlowEntityType {
    INNER,
    AGGREGATE
}
