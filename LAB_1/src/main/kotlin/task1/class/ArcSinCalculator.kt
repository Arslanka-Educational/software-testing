package task1.`class`

import java.math.BigDecimal

class ArcSinCalculator(private val termCalculator: TermCalculator) {
    fun calculateArcSin(x: BigDecimal, iterations: Int): BigDecimal {
        var result = BigDecimal.ZERO
        for (i in 0..iterations) {
            val term = termCalculator.calculateTerm(x, i)
            result += term
        }
        return result
    }
}