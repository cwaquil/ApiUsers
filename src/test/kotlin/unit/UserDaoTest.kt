package unit

import io.mockk.every
import io.mockk.mockkStatic
import org.backend.labs.domain.User
import org.backend.labs.domain.UserTable
import org.backend.labs.domain.repository.UserDAO
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserDaoTest {

    private val userDAO = UserDAO()

    @Test
    fun `Given an user when it does not exist in the base should create user`() {

        val expectedUser = User(1, "bob", "bob@gmail.com")

        val expressionMap = mutableMapOf<Expression<*>, Any?>()
        expressionMap[UserTable.id] = 1
        expressionMap[UserTable.name] = "bob"
        expressionMap[UserTable.email] = "bob@gmail.com"

        val resultRow = ResultRow.createAndFillValues(expressionMap)

        mockkStatic("org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt")
        every { transaction(statement = any<Transaction.() -> ResultRow>()) } returns resultRow

        val result = userDAO.save("bob", "bob@gmail.com")

        assertEquals(expectedUser, result)
    }

}