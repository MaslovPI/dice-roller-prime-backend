package io.github.maslovpi.model

import io.github.maslovpi.classes.dice.DieType
import kotlinx.serialization.Serializable


@Serializable
data class RollResult (val type: DieType, val result: Array<Int>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RollResult

        if (type != other.type) return false
        if (!result.contentEquals(other.result)) return false

        return true
    }

    override fun hashCode(): Int {
        var result1 = type.hashCode()
        result1 = 31 * result1 + result.contentHashCode()
        return result1
    }
}
