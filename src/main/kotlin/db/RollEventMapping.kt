package io.github.maslovpi.db

import io.github.maslovpi.model.RollEvent
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object RollEventTable: IntIdTable("rollEvent") {
    val rollerName = varchar("rollerName", 50)
    val time = datetime("time")
    val rollResults = text("rollResultJson")
}

class RollEventDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RollEventDAO>(RollEventTable)

    var rollerName by RollEventTable.rollerName
    var time by RollEventTable.time
    var rollResult by RollEventTable.rollResults
}

fun daoToModel(dao: RollEventDAO) = RollEvent(
    dao.rollerName,
    dao.time,
    Json.decodeFromString(dao.rollResult)
    )
