package org.backend.labs.domain

import org.jetbrains.exposed.sql.Table

object UserTable : Table("user") {

    private const val SIZE = 32

    val id = integer("id").autoIncrement()
    val name = varchar("name", SIZE)
    val email = varchar("email", SIZE)

    override val primaryKey = PrimaryKey(id, name = "pk_id")
}

data class User(val name: String, val email: String)
