package org.backend.labs.application.web

import io.javalin.Javalin

class ApiUsersApplication {

    private lateinit var app: Javalin

    fun appStart() {
        app = Javalin.create().start(7000)
    }
}

fun main() {
    ApiUsersApplication().appStart()
}