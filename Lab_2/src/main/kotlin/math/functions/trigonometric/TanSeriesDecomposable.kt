package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.minus
import math.numbers.times
import math.ranges.BigDecimalOpenRange
import math.ranges.Range
import java.math.BigDecimal
import java.math.MathContext

internal class TanSeriesDecomposable(
    private val sinSeriesDecomposable: SinSeriesDecomposable,
    private val cosSeriesDecomposable: CosSeriesDecomposable,

    ) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(sinSeriesDecomposable.accuracy) {
    override fun getName(): String = "tan"
    override fun getDomain(): Range<in BigDecimalInfinityExtended> = BigDecimalOpenRange(
        startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
        endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val sin = sinSeriesDecomposable.decompose(input = input, accuracy = accuracy)
        val cos = cosSeriesDecomposable.decompose(input = input, accuracy = accuracy)

        return BigDecimalInfinityExtended(
            sin.toBigDecimal() / cos.toBigDecimal()
        )
    }

}
