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
import java.math.RoundingMode

@ExtendWith(MockitoExtension::class)
internal class CosSeriesDecomposableTest {

    @Mock
    private lateinit var sinSeriesMock: SinSeriesDecomposable

    @Test
    internal fun `test decompose when sin is 0`() {
        `when`(
            sinSeriesMock.decompose(
                BigDecimalInfinityExtended(
                    BigDecimal.valueOf(Math.PI).div(BigDecimal.TWO).setScale(3, RoundingMode.HALF_EVEN)
                ), 0.001
            )
        ).thenReturn(BigDecimalInfinityExtended(BigDecimal.ONE))

        val result = CosSeriesDecomposable(accuracy = 0.001, sinSeriesDecomposable = sinSeriesMock).apply(
            BigDecimalInfinityExtended(0.0)
        )

        assertEquals(BigDecimalInfinityExtended(BigDecimal.ONE), result)
    }

    @Test
    internal fun `test decompose when sin is not 0`() {
        `when`(
            sinSeriesMock.decompose(
                BigDecimalInfinityExtended(
                    BigDecimal.valueOf(Math.PI).div(BigDecimal.TWO).setScale(3, RoundingMode.HALF_EVEN)
                ), 0.001
            )
        ).thenReturn(BigDecimalInfinityExtended(BigDecimal.valueOf(0.5)))

        val result = CosSeriesDecomposable(accuracy = 0.001, sinSeriesDecomposable = sinSeriesMock).apply(
            BigDecimalInfinityExtended(0.0)
        )

        assertEquals(BigDecimalInfinityExtended(BigDecimal.valueOf(0.5)), result)
    }
}
