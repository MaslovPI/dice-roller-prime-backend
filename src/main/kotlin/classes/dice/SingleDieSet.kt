package io.github.maslovpi.classes.dice

import io.github.maslovpi.model.RollResult

data class SingleDieSet(val type: DieType, val number: Int) {
    private val minValue: Int
    private val maxValue: Int

    init {
        if(number < 1)
            throw IllegalArgumentException("Should have at least 1 die")

        when(type){
            DieType.D4 -> {
                minValue = 1
                maxValue = 4
            }
            DieType.D6 -> {
                minValue = 1
                maxValue = 6
            }
            DieType.D8 -> {
                minValue = 1
                maxValue = 8
            }
            DieType.D10 -> {
                minValue = 1
                maxValue = 10
            }
            DieType.D12 -> {
                minValue = 1
                maxValue = 12
            }
            DieType.D20 -> {
                minValue = 1
                maxValue = 20
            }
            DieType.D100 -> {
                minValue = 0
                maxValue = 99
            }
        }
    }

    fun roll(): RollResult {
        val results = (1..number)
            .map { _ -> SingleDie(minValue, maxValue).roll() }
            .toTypedArray()
        return RollResult(type, results)
    }
}