package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.div
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext

internal class SecSeriesDecomposable(
    private val cosSeriesDecomposable: CosSeriesDecomposable,
    override val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(cosSeriesDecomposable.accuracy) {
    override fun getName(): String = "sec"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY)
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val cos = cosSeriesDecomposable.decompose(input = input, accuracy = accuracy)

        return BigDecimalInfinityExtended(1.0) / cos
    }
}
