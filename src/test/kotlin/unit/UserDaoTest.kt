package unit

import io.mockk.mockk
import org.backend.labs.domain.User
import org.backend.labs.domain.UserTable
import org.backend.labs.domain.repository.UserDAO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserDaoTest {

    object mockTable {
        val id = 1
        val name = "bob"
        val email = "bob@gmail.com"
        val createdAt = "2020-11-05"
    }

    private val userTable = mockk<mockTable>(relaxed = true)

    private val userDAO = UserDAO()

    @Test
    fun `Given an user when it does not exist in the base should create user`() {
        // Arrange
        val expectedTable = User()

        every { userTable }


        // Action

        userDAO.save("bob", "bob@gmail.com")


        // Assert
        // Oque espero?
//        Espero que meu metodo save da UserDAO funcione


        assertEquals(expectedUser, result)
    }

}