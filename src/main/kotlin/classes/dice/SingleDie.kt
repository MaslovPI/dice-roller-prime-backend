package io.github.maslovpi.classes.dice

class SingleDie (private val minValue: Int, private val maxValue: Int){

    init {
        if(minValue > maxValue)
            throw IllegalArgumentException("Min value should be less than max value")
        if(minValue < 0)
            throw IllegalArgumentException("Min value should be positive")
    }
    fun roll(): Int {
        return (minValue..maxValue).random()
    }
}