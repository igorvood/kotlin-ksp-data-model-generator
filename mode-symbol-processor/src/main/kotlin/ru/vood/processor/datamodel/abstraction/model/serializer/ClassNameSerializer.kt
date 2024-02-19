package ru.vood.processor.datamodel.abstraction.model.serializer

import com.squareup.kotlinpoet.ClassName
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder.Companion.DECODE_DONE
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

object ClassNameSerializer : KSerializer<ClassName> {
    override fun deserialize(decoder: Decoder): ClassName {
        return decoder.decodeStructure(descriptor) {
            var packageName: String? = null
            var simpleName: String? = null
            loop@ while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    DECODE_DONE -> break@loop
                    0 -> packageName = decodeStringElement(descriptor, 0)
                    1 -> simpleName = decodeStringElement(descriptor, 1)
                    else -> throw SerializationException("Unexpected index $index")
                }
            }

            ClassName(
                requireNotNull(packageName),
                requireNotNull(simpleName),
            )
        }
    }

    override val descriptor: SerialDescriptor
        get() = buildClassSerialDescriptor(ClassName::class.java.canonicalName) {
            element<String>("packageName")
            element<String>("simpleName")
        }


    override fun serialize(encoder: Encoder, value: ClassName) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.packageName)
            encodeStringElement(descriptor, 1, value.simpleName)
        }
    }

}