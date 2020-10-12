package unit

import org.backend.labs.domain.User
import org.backend.labs.domain.services.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SaveServiceTest{

    @Test
    fun `Given a customer without registration when it does not exist in the base then create user`() {
        //Arrange
        val expectedUser = User(name = "Bob", email = "bob@gmail.com")

        //Action
        val result = UserService().saveUser(nome = "Bob", email = "bob@gmail.com")

        //Assert

        assertEquals(expectedUser, result)
    }

}