import math.functions.trigonometric.SinSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class SinSeriesDecomposableTest {

    private val sinFunction = SinSeriesDecomposable(0.001)

    @Test
    fun `test sin(0)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(0.0))
        assertEquals(0.0, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(PI)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(Math.PI))
        assertEquals(0.0, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(PI div 2)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(Math.PI / 2))
        assertEquals(1.0, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(PI div 4)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(Math.PI / 4))
        assertEquals(sqrt(2.0) / 2, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(3PI div 2)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(3 * Math.PI / 2))
        assertEquals(-1.0, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(2PI)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(2 * Math.PI))
        assertEquals(0.0, result.toDouble(), 0.001)
    }

    @Test
    fun `test sin(-PI div 4)`() {
        val result = sinFunction.apply(BigDecimalInfinityExtended(-Math.PI / 4))
        assertEquals(-sqrt(2.0) / 2, result.toDouble(), 0.001)
    }
}
