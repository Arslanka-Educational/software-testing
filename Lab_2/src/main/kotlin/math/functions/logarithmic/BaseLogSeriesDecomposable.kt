package math.functions.logarithmic

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenStartRange
import math.ranges.Range

internal class BaseLogSeriesDecomposable(
    override val accuracy: Double,
    private val base: BigDecimalInfinityExtended,
    private val naturalLogSeriesDecomposable: NaturalLogSeriesDecomposable,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {
    override fun getName(): String = "Ln${base.toBigDecimal()}"

    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> =
        listOf(
            BigDecimalOpenStartRange(
                startExclusive = BigDecimalInfinityExtended(0.0),
                end = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
            )
        )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended =
        BigDecimalInfinityExtended(
            naturalLogSeriesDecomposable.decompose(input, accuracy)
                .toBigDecimal() / naturalLogSeriesDecomposable.decompose(base, accuracy).toBigDecimal()
        )
}