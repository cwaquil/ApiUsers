package org.backend.labs.domain.services

import org.backend.labs.domain.User
import org.backend.labs.domain.repos.UserDAO

class UserService(val userDAO: UserDAO) {

    fun saveUser(nome: String, email: String): User {
        return userDAO.save(nome, email)
    }

}