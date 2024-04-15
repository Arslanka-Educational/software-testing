package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.MathContext

internal class SecSeriesDecomposable(
    private val cosSeriesDecomposable: CosSeriesDecomposable
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(sinSeriesDecomposable.accuracy) {
    override fun getName(): String = "sec"
    override fun getDomain(): Range<in BigDecimalInfinityExtended> = BigDecimalOpenRange(
        startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
        endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY)
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val cos = cosSeriesDecomposable.decompose(input = input, accuracy = accuracy)

        return BigDecimalInfinityExtended(
            BigDecimalInfinityExtended(1.0) / cos.toBigDecimal()
        )
    }
}
