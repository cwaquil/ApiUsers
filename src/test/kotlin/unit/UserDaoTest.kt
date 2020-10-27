package unit

import org.backend.labs.domain.User
import org.backend.labs.domain.repository.UserDAO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserDaoTest {

    // TODO create mock connection

    @Test
    fun `Given an user when it does not exist in the base then create user`() {
        val expectedUser = User(id = 1, name = "Bob", email = "bob@gmail.com")

//        every { UserTable.insert { any() } }



        val result = UserDAO().save(name = "Bob", email = "bob@gmail.com")

        assertEquals(expectedUser, result)
    }

}