package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.minus
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext

internal class CosSeriesDecomposable(
    private val sinSeriesDecomposable: SinSeriesDecomposable,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(sinSeriesDecomposable.accuracy) {
    override fun getName(): String = "cos"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val sin = sinSeriesDecomposable.decompose(input = input, accuracy = accuracy)
        return BigDecimalInfinityExtended(
            if (sin < BigDecimalInfinityExtended(0.0)) {
                (((BigDecimalInfinityExtended(1.0) - sin * sin)).toBigDecimal().sqrt(MathContext(10))) * BigDecimal(-1.0)
            } else {
                (BigDecimalInfinityExtended(1.0) - sin * sin).toBigDecimal().sqrt(MathContext(10))
            }
        )
    }

}
