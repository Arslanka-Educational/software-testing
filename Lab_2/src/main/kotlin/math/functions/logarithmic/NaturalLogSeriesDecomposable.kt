package math.functions.logarithmic

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenStartRange
import math.ranges.Range

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
        return BigDecimalInfinityExtended(1.0)
    }
}