package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal

internal class SinSeriesDecomposable(
    override val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {
    override fun getName(): String = "sin"

    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val x = input.toBigDecimal()
        var sinX = BigDecimal.ZERO
        var term: BigDecimal
        var n = 0

        do {
            term = x.pow(2 * n + 1)
                .divide(factorial(2 * n + 1), 50, BigDecimal.ROUND_HALF_EVEN)
                .multiply(BigDecimal.valueOf((-1).toDouble()).pow(n))

            sinX = sinX.add(term)
            n++
        } while (term.abs() >= BigDecimal.valueOf(accuracy))

        return BigDecimalInfinityExtended(sinX.stripTrailingZeros())
    }

    private fun factorial(n: Int): BigDecimal {
        var result = BigDecimal.ONE
        for (i in 2..n) {
            result *= BigDecimal.valueOf(i.toDouble())
        }
        return result
    }
}