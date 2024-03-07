package datamodel

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import ru.vood.dmgen.datamodel.sealedData.oneOf.DealOneDataEntity
import ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDtoEntity
import ru.vood.dmgen.datamodel.valueClasses.DealId

class OneOfDtoEntityTest {

    private val json = Json { }

    @Test
    fun asd() {
        val oneOfDtoEntity: OneOfDtoEntity = DealOneDataEntity(DealId("asdsa"), "sdasd")


        val encodeToString = json.encodeToString(OneOfDtoEntity.serializer(), oneOfDtoEntity)

        val decodeFromString = json.decodeFromString<OneOfDtoEntity>(OneOfDtoEntity.serializer(), encodeToString)
        println(decodeFromString)
    }
}