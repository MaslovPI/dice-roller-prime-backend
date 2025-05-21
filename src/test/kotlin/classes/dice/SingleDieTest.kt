package io.github.maslovpi.classes.dice

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class SingleDieTest {

    @Test
    fun `should have positive min and max values`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SingleDie(0, -1)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SingleDie(-1, 0)
        }
    }

    @Test
    fun `should have max larger than min`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SingleDie(2, 1)
        }
    }

    @Test
    fun `should roll between min and max values`() {
        val minValue = 0
        val maxValue = 99
        val attempts = 100
        (0..attempts).map {
            val rolledValue = SingleDie(minValue, maxValue).roll()
            Assertions.assertTrue(rolledValue >= minValue)
            Assertions.assertTrue(rolledValue <= maxValue)
        }
    }
}
