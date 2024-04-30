import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.SecSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal

@ExtendWith(MockitoExtension::class)
internal class SecSeriesDecomposableTest {

    @Mock
    private lateinit var cosSeriesMock: CosSeriesDecomposable

    @Test
    internal fun `test decompose when cos is 1`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(0.0), 0.001)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }

    @Test
    internal fun `test decompose when cos is not 1`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.5235987755982988), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.5))

        val result = SecSeriesDecomposable(cosSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(0.5235987755982988), 0.001)

        assertEquals(BigDecimalInfinityExtended(2.0), result)
    }

    @Test
    internal fun `test decompose when cos is -1`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI), 0.001))
            .thenReturn(BigDecimalInfinityExtended(-1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 0.001)
            .decompose(BigDecimalInfinityExtended(Math.PI), 0.001)

        assertEquals(BigDecimalInfinityExtended(-1.0), result)
    }


    @Test
    internal fun `test decompose when cos is -1 with zero accuracy`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI), 0.0))
            .thenReturn(BigDecimalInfinityExtended(-1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 0.0)
            .decompose(BigDecimalInfinityExtended(Math.PI), 0.0)

        assertEquals(BigDecimalInfinityExtended(-1.0), result)
    }

    @Test
    internal fun `test decompose when cos is -1 and accuracy is small`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI), 1E-10))
            .thenReturn(BigDecimalInfinityExtended(-1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 1E-10)
            .decompose(BigDecimalInfinityExtended(Math.PI), 1E-10)

        assertEquals(BigDecimalInfinityExtended(-1.0), result)
    }

    @Test
    internal fun `test decompose when cos is -1 and accuracy is large`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(Math.PI), 1E10))
            .thenReturn(BigDecimalInfinityExtended(-1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 1E10)
            .decompose(BigDecimalInfinityExtended(Math.PI), 1E10)

        assertEquals(BigDecimalInfinityExtended(-1.0), result)
    }

    @Test
    internal fun `test decompose when cos is 1 and accuracy is small`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 1E-10))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 1E-10)
            .decompose(BigDecimalInfinityExtended(0.0), 1E-10)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }

    @Test
    internal fun `test decompose when cos is 1 and accuracy is large`() {
        `when`(cosSeriesMock.decompose(BigDecimalInfinityExtended(0.0), 1E10))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = SecSeriesDecomposable(cosSeriesMock, 1E10)
            .decompose(BigDecimalInfinityExtended(0.0), 1E10)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }


}