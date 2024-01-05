package datamodel

import org.junit.jupiter.api.Test

class Generate1000Entity {

    @Test
    fun t100(){
        val map = (0..1000)
            .map {

                val s = """@Comment("Это сущность Сделка$it")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal$it {
    @Pk
    @Comment("Это ее идентификатор $it")
    val id: DealId
}
"""


                if (it == 0) {
                    s
                } else {
                    """@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal${it - 1}",
    name = "OneOfDto_FK${it}",
    cols = [ForeignKeyColumns("id", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
                        $s""".trimIndent()
                }
            }
            .joinToString("\n")

        println(map.length)

    }


}