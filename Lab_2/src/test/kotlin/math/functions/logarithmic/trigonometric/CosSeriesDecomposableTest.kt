package math.functions.logarithmic.trigonometric

import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.math.BigDecimal

class CosSeriesDecomposableTest {

    @Test
    fun `test decompose when sin is 0`() {
        val sinSeriesMock = Mockito.mock(SinSeriesDecomposable::class.java)
        Mockito.`when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.0))

        val cosSeries = CosSeriesDecomposable(sinSeriesMock)

        val result = cosSeries.apply(BigDecimalInfinityExtended(0.0))

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }

    @Test
    fun `test decompose when sin is not 0`() {
        // Mocking SinSeriesDecomposable
        val sinSeriesMock = Mockito.mock(SinSeriesDecomposable::class.java)
        Mockito.`when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.5)) // Setting sin to 0.5 for testing

        // Creating instance of CosSeriesDecomposable with mocked SinSeriesDecomposable
        val cosSeries = CosSeriesDecomposable(sinSeriesMock)

        // Testing the decompose method of CosSeriesDecomposable
        val result = cosSeries.apply(BigDecimalInfinityExtended(0.0))

        // Asserting the result
        assertEquals(BigDecimalInfinityExtended(0.8660254038), result, "Test with sin=0.5")
    }
}
