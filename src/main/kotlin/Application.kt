package io.github.maslovpi

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureFrameworks()
    configureMonitoring()
    configureSerialization()
    configureDatabases()
    configureSockets()
    configureHTTP()
    configureRouting()
}
