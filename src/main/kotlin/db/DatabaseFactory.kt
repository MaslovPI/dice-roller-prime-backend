package io.github.maslovpi.db

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val database = Database.connect(
            url = "jdbc:postgresql://localhost:5432/dice-roller-db",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "123"
        )
        transaction(database) {
            SchemaUtils.create(RollEventTable)
        }
    }
}

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)