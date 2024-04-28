package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.minus
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext

internal class CscSeriesDecomposable(
    private val sinSeriesDecomposable: SinSeriesDecomposable,
    override val accuracy: Double,
    ) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(sinSeriesDecomposable.accuracy) {
    override fun getName(): String = "csc"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val sin = sinSeriesDecomposable.decompose(input = input, accuracy = accuracy)
        return BigDecimalInfinityExtended(
            BigDecimalInfinityExtended(1.0).toBigDecimal() / sin.toBigDecimal()
        )
    }
}

