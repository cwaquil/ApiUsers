package org.backend.labs.application.web

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction


class ApiUsersApplication {

    private lateinit var app: Javalin

    fun appStart() {
        app = Javalin.create().start(7000)
        connectDB()
    }



    private fun connectDB() {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
        config.username = "postgres"
        config.password = "123456"

        val dataSource = HikariDataSource(config)

        Database.connect(dataSource)
    }

}


fun main() {
    ApiUsersApplication().appStart()
}