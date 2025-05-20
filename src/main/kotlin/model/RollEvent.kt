package io.github.maslovpi.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class RollEvent (
    val rollerName: String,
    val time: LocalDateTime,
    val rollResults: List<RollResult>
)