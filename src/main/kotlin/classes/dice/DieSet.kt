package io.github.maslovpi.classes.dice

import io.github.maslovpi.model.RollResult

class DieSet {
    val listOfDieSets = mutableListOf<SingleDieSet>()
    fun add(dieSet: SingleDieSet) {
        listOfDieSets.add(dieSet)
    }

    fun roll(): Array<RollResult> = listOfDieSets.map { it.roll() }.toTypedArray()
}
