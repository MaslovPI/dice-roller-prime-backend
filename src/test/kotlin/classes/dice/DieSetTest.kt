package io.github.maslovpi.classes.dice

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class DieSetTest {
    @Test
    fun `should roll set of dice`() {
        val set1 = SingleDieSet(DieType.D4, 10)
        val set2 = SingleDieSet(DieType.D6, 5)

        var dieSet = DieSet()
        dieSet.add(set1)
        dieSet.add(set2)

        val result = dieSet.roll()
        Assertions.assertEquals(set1.type, result[0].type)
        Assertions.assertEquals(set1.number, result[0].result.size)
        Assertions.assertEquals(set2.type, result[1].type)
        Assertions.assertEquals(set2.number, result[1].result.size)
    }
}
