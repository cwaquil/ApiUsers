package unit

import io.mockk.mockk
import net.bytebuddy.matcher.ElementMatchers.any
import org.backend.labs.domain.User
import org.backend.labs.domain.UserTable
import org.backend.labs.domain.repository.UserDAO
import org.jetbrains.exposed.sql.insert
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserDaoTest {

    private val userDAO = UserDAO()

    @Test
    fun `Given an user when it does not exist in the base should create user`() {
        // Arrange
        val expectedUser = User(1,"bob", "bob@gmail.com")

        every { UserTable.insert ( any() ) }


        // Action
        val result = userDAO.save("bob", "bob@gmail.com")



        // Assert
        // Oque espero?
//        Espero que meu metodo save da UserDAO funcione


        assertEquals(expectedUser, result)
    }

}