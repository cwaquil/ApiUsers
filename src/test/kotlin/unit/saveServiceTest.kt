package unit

import io.mockk.every
import io.mockk.mockk
import org.backend.labs.domain.User
import org.backend.labs.domain.UserTable
import org.backend.labs.domain.repos.UserDAO
import org.backend.labs.domain.services.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.sql.SQLException

class SaveServiceTest {

    private val userDAO = mockk<UserDAO>(relaxed = true)

    @Test
    fun `Given a customer when it does not exist in the base then create user`() {
        val expectedUser = User(name = "Bob", email = "bob@gmail.com")

        every { userDAO.save(nome = "Bob", email = "bob@gmail.com") } returns expectedUser

        val result = UserService(userDAO).saveUser(nome = "Bob", email = "bob@gmail.com")

        assertEquals(expectedUser, result)
    }

    @Test
    fun `Given a customer without name should throw an Exception`() {
        val email = "bob@gmail.com"
        val expectedMessage = "Field can not be empty"

        every { userDAO.save(any(), email) } throws SQLException()

        val result = assertThrows<SQLException> {
            UserService(userDAO).saveUser("", email = "bob@gmail.com")
        }.message

        assertEquals(expectedMessage, result)
    }
}