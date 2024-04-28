package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.minus
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext
import kotlin.math.abs
import kotlin.math.log10

internal class CosSeriesDecomposable(
    override val accuracy: Double,
    private val sinSeriesDecomposable: SinSeriesDecomposable,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {
    override fun getName(): String = "cos"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val sin = sinSeriesDecomposable.decompose(input = input, accuracy = accuracy)
        val mc = MathContext(  1 + abs(log10(accuracy)).toInt())
        return BigDecimalInfinityExtended(
            if (sin < BigDecimalInfinityExtended(0.0)) {
                (((BigDecimalInfinityExtended(1.0) - sin * sin)).toBigDecimal().sqrt( mc) * BigDecimal(-1.0))
            } else {
                (BigDecimalInfinityExtended(1.0) - sin * sin).toBigDecimal().sqrt(mc)
            }
        )
    }

}
