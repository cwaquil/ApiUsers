package org.backend.labs.domain

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime

object UserTable : Table("userTable") {

    private const val SIZE = 32

    val id = integer("id").autoIncrement()
    val name = varchar("name", SIZE)
    val email = varchar("email", SIZE)
    val createdAt = datetime("created_at")
    
    override val primaryKey = PrimaryKey(id, name = "pk_id")
}

data class User(val id: Int, val name: String, val email: String)

data class UserReturned(val id: Int, val name: String, val email: String)
