package math.functions.complex

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.Range

internal class PiecewiseFunctionSeriesDecomposable(

) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(0.0) {
    override fun getName(): String = "Piecewise"

    override fun getDomain(): Range<in BigDecimalInfinityExtended> {
        TODO()
    }

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        TODO()
    }
}