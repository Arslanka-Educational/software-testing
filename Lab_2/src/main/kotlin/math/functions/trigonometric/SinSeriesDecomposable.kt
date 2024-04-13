package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenRange
import math.ranges.Range

internal class SinSeriesDecomposable(
    val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {
    override fun getName(): String = "sin"

    override fun getDomain(): Range<in BigDecimalInfinityExtended> = BigDecimalOpenRange(
        startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
        endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        TODO("Not yet implemented")
    }
}