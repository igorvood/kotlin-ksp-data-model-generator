package ru.vood.dmgen.bean.post.processor

import org.reflections.Reflections
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Configuration
import ru.vood.dmgen.annotation.MetaColumns
import ru.vood.dmgen.annotation.MetaEntities
import ru.vood.dmgen.annotation.MetaFKs
import ru.vood.dmgen.annotation.ModelEntity
import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum
import java.util.concurrent.atomic.AtomicBoolean


@Configuration
class DataModelBpp : BeanPostProcessor {

    private val isScaned = AtomicBoolean(false)
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
        if (!isScaned.get()) {
            val reflections = Reflections("ru")
            val metaEntities: Set<Class<*>> = reflections.getTypesAnnotatedWith(MetaEntities::class.java)
            val modelEntity: Set<Class<*>> = reflections.getTypesAnnotatedWith(ModelEntity::class.java)
            val metaColumns: Set<Class<*>> = reflections.getTypesAnnotatedWith(MetaColumns::class.java)
            val metaFKs: Set<Class<*>> = reflections.getTypesAnnotatedWith(MetaFKs::class.java)

            val first = metaEntities.first() as Class<Enum<*>>
            val enumConstants = first.getEnumConstants().first()
            val first1 = first.declaredMethods.filter { it.name == "entityData" }.first()

            val invoke = first1.invoke(enumConstants)

            asdsad<MetaEntities>(metaEntities)
            asdsad<MetaColumns>(metaColumns)
            asdsad<MetaFKs>(metaFKs)


            asdsad<ModelEntity>(modelEntity)

            isScaned.set(true)
        }
        return bean
    }

    fun <T : Enum<T>> getInstance(value: String, enumClass: Class<T>): T {
        return java.lang.Enum.valueOf(enumClass, value)
    }

    private inline fun <reified T> asdsad(metaEntities: Set<Class<*>>) {
        log.info("${T::class.simpleName} -> ${metaEntities.map { it.canonicalName }}")
    }
}