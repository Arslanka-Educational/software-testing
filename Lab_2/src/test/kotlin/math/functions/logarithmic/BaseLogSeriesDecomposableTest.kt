import math.functions.logarithmic.BaseLogSeriesDecomposable
import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class BaseLogSeriesDecomposableTest {

    @Mock
    private lateinit var naturalLogSeriesMock: NaturalLogSeriesDecomposable

    @Test
    internal fun `test decompose`() {
        `when`(naturalLogSeriesMock.decompose(BigDecimalInfinityExtended(2.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.693))

        `when`(naturalLogSeriesMock.decompose(BigDecimalInfinityExtended(10.0), 0.001))
            .thenReturn(BigDecimalInfinityExtended(0.693))

        val result = BaseLogSeriesDecomposable(0.001, BigDecimalInfinityExtended(10.0), naturalLogSeriesMock)
            .decompose(BigDecimalInfinityExtended(2.0), 0.001)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }

    @Test
    internal fun `test decompose when base is e`() {
        `when`(naturalLogSeriesMock.decompose(BigDecimalInfinityExtended(Math.E), 0.001))
            .thenReturn(BigDecimalInfinityExtended(1.0))

        val result = BaseLogSeriesDecomposable(0.01, BigDecimalInfinityExtended(Math.E), naturalLogSeriesMock)
            .decompose(BigDecimalInfinityExtended(Math.E), 0.001)

        assertEquals(BigDecimalInfinityExtended(1.0), result)
    }
}
