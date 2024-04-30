package math.functions.trigonometric

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.numbers.div
import math.ranges.BigDecimalOpenRange
import math.ranges.Range

internal class CotSeriesDecomposable(
    private val sinSeriesDecomposable: SinSeriesDecomposable,
    private val cosSeriesDecomposable: CosSeriesDecomposable,
    override val accuracy: Double,
) :
    SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(sinSeriesDecomposable.accuracy) {
    override fun getName(): String = "tan"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> = listOf(
        BigDecimalOpenRange(
            startExclusive = BigDecimalInfinityExtended(Double.NEGATIVE_INFINITY),
            endExclusive = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
        )
    )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val sin = sinSeriesDecomposable.decompose(input = input, accuracy = accuracy)
        val cos = cosSeriesDecomposable.decompose(input = input, accuracy = accuracy)

        return cos / sin
    }
}
