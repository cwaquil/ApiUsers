package org.backend.labs.domain.services

import org.backend.labs.domain.User
import org.backend.labs.domain.repos.UserDAO
import java.lang.Exception
import java.sql.SQLException

class UserService(val userDAO: UserDAO) {

    fun saveUser(nome: String, email: String): User {

        return try {
            userDAO.save(nome, email)
        } catch (ex: Exception) {
            throw SQLException("Field can not be empty")
        }
    }

}