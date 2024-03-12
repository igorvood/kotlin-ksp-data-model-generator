package ru.vood.calculator.ext.abstraction

import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionOperations

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractTests {

    @Autowired
    lateinit var transactionManager: PlatformTransactionManager


    @Autowired
    lateinit var transactionOperations: TransactionOperations


    fun <R> withTransactional(block: () -> R): R? {
        return transactionOperations.execute { q ->
            block.invoke()
        }
    }

}