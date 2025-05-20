package io.github.maslovpi

import io.github.maslovpi.db.DatabaseFactory
import io.ktor.server.application.*

fun Application.configureDatabases() {
    DatabaseFactory.init()
}
