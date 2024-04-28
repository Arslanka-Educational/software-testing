import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.functions.trigonometric.TanSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class TanSeriesDecomposableTest {

    @Mock
    private lateinit var sinSeriesMock: SinSeriesDecomposable

    @Mock
    private lateinit var cosSeriesMock: CosSeriesDecomposable

    @Test
    internal fun `test decompose when sin is 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.0))
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = TanSeriesDecomposable(sinSeriesMock, cosSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(0.0), 0.001)

        assertEquals(BigDecimalInfinityExtended(0.0), result)
    }

    @Test
    internal fun `test decompose when cos is 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI / 2), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1.0))
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI / 2), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.0))

        assertThrows<Exception> {
            TanSeriesDecomposable(sinSeriesMock, cosSeriesMock, 0.001)
                .decompose(BigDecimalInfinityExtended(Math.PI / 2), 0.001)
        }
    }

    @Test
    internal fun `test decompose when sin and cos are not 0`() {
        `when`(sinSeriesMock.decompose(BigDecimalInfinityExtended(0.7853981633974483), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.707))
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.7853981633974483), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.707))

        val result = TanSeriesDecomposable(sinSeriesMock, cosSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(0.7853981633974483), 0.001)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }
}
