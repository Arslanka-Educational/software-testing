package math.functions.complex

import math.functions.domains.IncorrectDomainException
import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.Range
import java.util.function.Predicate

internal class PiecewiseFunctionSeriesDecomposable(
    private val listOfSeriesFunctions: List<Pair<SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>, Predicate<BigDecimalInfinityExtended>>>,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(listOfSeriesFunctions.maxOf { it.first.accuracy }) {
    override fun getName(): String = "Piecewise"

    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> {
        return listOfSeriesFunctions.flatMap { it.first.getDomain() }.toList()
    }

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        if (listOfSeriesFunctions.count { it.second.test(input) } > 1) {
            throw IncorrectDomainException(getName())
        }

        return listOfSeriesFunctions.first { it.second.test(input) }.first.apply(input)
    }
}