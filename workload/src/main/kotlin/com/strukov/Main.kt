package com.strukov

import com.strukov.processor.*

//internal fun main() {
//    SampleUrlPrinter().print()
//    val dealId = DealId("Asd")
//    val value = DealParamOneToOneEntity(dealId, "Asd")
//    val json = Json
//    val message = json.encodeToString(
//        DealParamOneToOneEntity.serializer(),
//        value
//    )
//
//
//    println(
//        message
//    )
//
//
////    val value1 = DealEntity(dealId, "asd", "Asd", true, false, value)
////    val encodeToString = json.encodeToString(DealEntity.serializer(), value1)
//
////    println(encodeToString)
//}

@UrlPrinter
internal interface SampleUrl {
    val sampleConfigUrl: SampleConfigUrl?
}

@EnvironmentSettings
internal interface SampleEnvironment

@EnvironmentConfig
internal interface SampleConfig {
    @Url(environment = Environment.PROD, name = "https://www.prod.com")
    val prod: String

    @Url(environment = Environment.TEST, name = "https://www.test.com")
    val test: String
}