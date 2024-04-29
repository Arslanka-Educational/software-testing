package math.functions.trigonometric

import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CscSeriesDecomposableTest {

    @Mock
    private lateinit var sinSeriesMock: SinSeriesDecomposable

    @Test
    internal fun `test decompose when sin is very small`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(1e-12), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1e12))

        val result = CscSeriesDecomposable(sinSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(1e-12), 0.001)

        assertEquals(BigDecimalInfinityExtended(0.0), result)
    }



    @Test
    internal fun `test decompose when sin is not 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.5235987755982988), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.5))

        val result = CscSeriesDecomposable(sinSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(0.5235987755982988), 0.001)

        assertEquals(BigDecimalInfinityExtended(2.0), result)
    }

    @Test
    internal fun `test decompose when sin is PI div 3`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(1.0471975511965976), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = CscSeriesDecomposable(sinSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(1.0471975511965976), 0.001)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }

    @Test
    internal fun `test decompose when sin is -PI div 3`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(-1.0471975511965976), 0.001))
            .thenReturn(BigDecimalInfinityExtended(-1.0))

        val result = CscSeriesDecomposable(sinSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(-1.0471975511965976), 0.001)

        assertEquals(BigDecimalInfinityExtended(-1.0), result)
    }

    @Test
    internal fun `test decompose when sin is very large`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(1e12), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1e-12))

        val result = CscSeriesDecomposable(sinSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(1e12), 0.001)

        assertEquals(BigDecimalInfinityExtended(1000000000000.0), result)
    }



}