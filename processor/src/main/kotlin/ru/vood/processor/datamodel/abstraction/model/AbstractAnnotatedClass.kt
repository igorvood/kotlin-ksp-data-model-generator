package ru.vood.processor.datamodel.abstraction.model


//abstract class AbstractAnnotatedClass<FIELD_META : AbstractField>(
//    private val element: Element
//)/*<Annotation>*/ {
//
//
//    val modelClassName = ModelClassName(kotlinMetaClass.toString())
//
//    val name: String by lazy { element.asType().toString().split(".").last() }
//
//    val entityFileldName = name[0].lowercaseChar() + name.substring(1)
//
//    abstract fun elementToIGeneratedField(posicion: Int, e: Element): FIELD_META
//
//    val fields: List<FIELD_META> by lazy {
//        element.enclosedElements.withIndex()
//            .filter { e -> e.value.kind.isField }
//            .map { element -> elementToIGeneratedField(element.index, element.value) }
//    }
//
//    val shortName: String by lazy {
//        val dotIdx = name.lastIndexOf('.')
//        name.substring(dotIdx + 1)
//    }
//
//    val packageName: String by lazy {
//        val dotIdx = name.lastIndexOf('.')
//        name.substring(0, dotIdx)
//    }
//
//}