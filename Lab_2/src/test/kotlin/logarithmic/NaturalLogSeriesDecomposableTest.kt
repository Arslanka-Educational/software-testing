import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.math.BigDecimal

internal class NaturalLogSeriesDecomposableTest {

    @Test
    fun `test decompose with valid input`() {
        val accuracy = 1e-5
        val function = NaturalLogSeriesDecomposable(accuracy)

        val result = function.decompose(BigDecimalInfinityExtended(2.0), accuracy)

        assertEquals(0.69314, result.toDouble(), accuracy)
    }

    @Test
    fun `test decompose with zero input`() {
        val accuracy = 1e-5
        val function = NaturalLogSeriesDecomposable(accuracy)

        val exception = assertThrows<IllegalArgumentException> {
            function.decompose(BigDecimalInfinityExtended(0.0), accuracy)
        }

        assertEquals("Input must be greater than 0", exception.message)
    }

    @Test
    fun `test decompose with negative input`() {
        val accuracy = 1e-5
        val function = NaturalLogSeriesDecomposable(accuracy)

        val exception = assertThrows<IllegalArgumentException> {
            function.decompose(BigDecimalInfinityExtended(-1.0), accuracy)
        }

        assertEquals("Input must be greater than 0", exception.message)
    }

}
