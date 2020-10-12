package org.backend.labs.domain.repos

import org.backend.labs.domain.User

class UserDAO() {
    fun save(nome: String,email: String): User {
        return User(nome, email)
    }
}
