package io.github.maslovpi.service

import io.github.maslovpi.db.RollEventDAO
import io.github.maslovpi.db.daoToModel
import io.github.maslovpi.db.suspendTransaction
import io.github.maslovpi.model.RollEvent
import kotlinx.serialization.json.Json

class PostgresRollEventRepository : IRollEventRepository {
    override suspend fun allRollEvents(): List<RollEvent> =
        suspendTransaction {
            RollEventDAO.all().map(::daoToModel)
        }

    override suspend fun addRollEvent(rollEvent: RollEvent) {
        RollEventDAO.new {
            rollerName = rollEvent.rollerName
            rollResult = Json.encodeToString(rollEvent.rollResults)
            time = rollEvent.time
        }
    }
}
