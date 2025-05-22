package io.github.maslovpi.service

import io.github.maslovpi.model.RollEvent

interface IRollEventRepository {
    suspend fun allRollEvents(): List<RollEvent>

    suspend fun addRollEvent(rollEvent: RollEvent)
}
