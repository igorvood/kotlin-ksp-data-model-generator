package ru.vood.mock.external

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class MockExternalSystemApplication

fun main(args: Array<String>) {
    runApplication<MockExternalSystemApplication>(*args)
}
