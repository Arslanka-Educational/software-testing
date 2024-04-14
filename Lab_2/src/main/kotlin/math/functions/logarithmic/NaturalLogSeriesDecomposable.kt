package math.functions.logarithmic

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenStartRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext

internal class NaturalLogSeriesDecomposable(
    val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {

    override fun getName(): String = "Ln"
    override fun getDomain(): Range<in BigDecimalInfinityExtended> =
        BigDecimalOpenStartRange(
            startExclusive = BigDecimalInfinityExtended(0.0),
            end = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        require(input > BigDecimalInfinityExtended(0.0)) { "Input must be greater than 0" }

        val x = input.toBigDecimal()
        val terms = mutableListOf<BigDecimal>()
        var result = BigDecimal.ZERO

        var n = 1
        var term = BigDecimal.ONE
        var sign = BigDecimal.ONE

        while (term.abs() > BigDecimal(accuracy)) {
            result += term
            terms.add(result)
            n++
            sign = sign.negate()
            term = sign * ((x - BigDecimal.ONE).pow(n)).divide(BigDecimal(n), MathContext.DECIMAL128)
        }

        return BigDecimalInfinityExtended(result)
    }
}