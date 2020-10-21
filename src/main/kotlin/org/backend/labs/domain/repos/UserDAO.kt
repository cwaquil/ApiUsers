package org.backend.labs.domain.repos

import org.backend.labs.domain.User
import org.backend.labs.domain.UserTable
import org.jetbrains.exposed.sql.ResultRow

class UserDAO {
    fun save(nome: String, email: String): User {
        return User(nome, email)
    }
}

private fun ResultRow.toUser() = User(
        name = this[UserTable.name],
        email = this[UserTable.email]
)