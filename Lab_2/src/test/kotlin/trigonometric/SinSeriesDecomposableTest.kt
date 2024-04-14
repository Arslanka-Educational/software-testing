package trigonometric

import math.functions.trigonometric.SinSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.math.sqrt

class SinSeriesDecomposableTest {
    private val accuracy = 1e-10


    @Test
    fun testPiHalf() {
        val sinFunction = SinSeriesDecomposable(accuracy)
        val piHalf = BigDecimal.valueOf(Math.PI / 2)
        val result = sinFunction.decompose(BigDecimalInfinityExtended(piHalf), accuracy).toDouble()
        assertEquals(1.0, result, accuracy)
    }

    @Test
    fun testPi() {
        val sinFunction = SinSeriesDecomposable(accuracy)
        val pi = BigDecimal.valueOf(Math.PI)
        val result = sinFunction.decompose(BigDecimalInfinityExtended(pi), accuracy).toDouble()
        assertEquals(0.0, result, accuracy)
    }

    @Test
    fun testNegativePiHalf() {
        val sinFunction = SinSeriesDecomposable(accuracy)
        val negativePiHalf = BigDecimal.valueOf(-Math.PI / 2)
        val result = sinFunction.decompose(BigDecimalInfinityExtended(negativePiHalf), accuracy).toDouble()
        assertEquals(-1.0, result, accuracy)
    }

    @Test
    fun testNegativePi() {
        val sinFunction = SinSeriesDecomposable(accuracy)
        val negativePi = BigDecimal.valueOf(-Math.PI)
        val result = sinFunction.decompose(BigDecimalInfinityExtended(negativePi), accuracy).toDouble()
        assertEquals(0.0, result, accuracy)
    }

    @Test
    fun testPiOverFour() {
        val sinFunction = SinSeriesDecomposable(accuracy)
        val piOverFour = BigDecimal.valueOf(Math.PI / 4)
        val result = sinFunction.decompose(BigDecimalInfinityExtended(piOverFour), accuracy).toDouble()
        assertEquals(sqrt(2.0) / 2, result, accuracy)
    }
}
