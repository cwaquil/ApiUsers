package org.backend.labs.domain.repository

import org.backend.labs.domain.User
import org.backend.labs.domain.UserReturned
import org.backend.labs.domain.UserTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class UserDAO {

    fun save(name: String, email: String): User = transaction {

        UserTable.insert {
            it[this.name] = name
            it[this.email] = email
        }.resultedValues?.first()?.toUser()!!
    }
}

private fun ResultRow.toUser() = User(
        name = this[UserTable.name],
        email = this[UserTable.email]
)

private fun ResultRow.toUserReturned() = UserReturned(
        id = this[UserTable.id],
        name = this[UserTable.name],
        email = this[UserTable.email]
)

//private fun ResultRow.toUser() = User(
//        id = this[UserTable.id],
//        name = this[UserTable.name],
//        email = this[UserTable.email]
//)