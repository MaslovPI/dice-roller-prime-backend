package io.github.maslovpi.classes.dice

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class SingleDieSetTest {
    @Test
    fun `should have one or more die`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { SingleDieSet(DieType.D4, 0) }
    }

    @Test
    fun `should roll set of dice equal to number`() {
        val number = 10
        val dieType = DieType.D4
        val diceSet = SingleDieSet(dieType, number)
        val resultSet = diceSet.roll()
        Assertions.assertEquals(dieType, resultSet.type)
        Assertions.assertEquals(number, resultSet.result.size)
    }
}
