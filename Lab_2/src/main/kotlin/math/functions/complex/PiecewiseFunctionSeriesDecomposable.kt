package math.functions.complex

import math.functions.MathFunction
import math.functions.domains.IncorrectDomainException
import math.numbers.BigDecimalInfinityExtended
import math.ranges.Range
import java.util.function.Function
import java.util.function.Predicate

internal class PiecewiseFunctionSeriesDecomposable(
    private val listOfSeriesFunctions: List<Pair<Function<BigDecimalInfinityExtended, BigDecimalInfinityExtended>, Predicate<BigDecimalInfinityExtended>>>,
    private val domain: List<Range<in BigDecimalInfinityExtended>>,
    val accuracy: Double,
) : MathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended> {
    override fun getName(): String = "piecewise"

    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> {
        return domain
    }

    override fun calculate(input: BigDecimalInfinityExtended): BigDecimalInfinityExtended {
        if (listOfSeriesFunctions.count { it.second.test(input) } > 1) {
            throw IncorrectDomainException(getName())
        }

        return listOfSeriesFunctions.first { it.second.test(input) }.first.apply(input)
    }
}