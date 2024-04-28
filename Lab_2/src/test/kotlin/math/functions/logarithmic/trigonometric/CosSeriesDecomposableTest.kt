package math.functions.logarithmic.trigonometric

import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal

@ExtendWith(MockitoExtension::class)
internal class CosSeriesDecomposableTest {

    @Mock
    private lateinit var sinSeriesMock: SinSeriesDecomposable

    @Test
    internal fun `test decompose when sin is 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.0))

        val result = CosSeriesDecomposable(accuracy = 0.001, sinSeriesDecomposable = sinSeriesMock).apply(
            BigDecimalInfinityExtended(0.0)
        )

        assertEquals(BigDecimalInfinityExtended(BigDecimal.ONE), result)
    }

    @Test
    internal fun `test decompose when sin is not 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI / 3), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.5))

        val cosSeries = CosSeriesDecomposable(0.001, sinSeriesMock)

        val result = cosSeries.apply(BigDecimalInfinityExtended(Math.PI / 3))

        assertEquals(BigDecimalInfinityExtended(0.866), result)
    }
}