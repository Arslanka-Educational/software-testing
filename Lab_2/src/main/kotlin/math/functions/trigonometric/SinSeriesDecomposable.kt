package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal

internal class SinSeriesDecomposable(
    val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {
    override fun getName(): String = "sin"

    override fun getDomain(): Range<in BigDecimalInfinityExtended> = BigDecimalOpenRange(
        startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
        endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val x = input.toBigDecimal()
        var sinX = BigDecimal.ZERO
        var term = BigDecimal.ZERO
        var n = 0
        var sign = 1

        do {
            term = BigDecimal.valueOf(sign.toDouble()).multiply(
                x.pow(2 * n + 1)
                    .divide(factorial(2 * n + 1), BigDecimal.ROUND_HALF_EVEN)
            )
            sinX = sinX.add(term)
            n++
            sign *= -1
        } while (term.abs() > BigDecimal.valueOf(accuracy))

        return BigDecimalInfinityExtended(sinX)
    }

    private fun factorial(n: Int): BigDecimal {
        var result = BigDecimal.ONE
        for (i in 2..n) {
            result *= BigDecimal(i)
        }
        return result
    }
}