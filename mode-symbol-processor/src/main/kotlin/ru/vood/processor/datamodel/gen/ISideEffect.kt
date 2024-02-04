package ru.vood.processor.datamodel.gen

interface ISideEffect<T> {

    fun entityDataJsonList(): List<T>
}