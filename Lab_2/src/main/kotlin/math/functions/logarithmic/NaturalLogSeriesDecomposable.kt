package math.functions.logarithmic

import math.functions.SeriesMathFunction
import math.numbers.BigDecimalInfinityExtended
import math.ranges.BigDecimalOpenStartRange
import math.ranges.Range
import java.math.BigDecimal

internal class NaturalLogSeriesDecomposable(
    override val accuracy: Double,
) : SeriesMathFunction<BigDecimalInfinityExtended, BigDecimalInfinityExtended, Double>(accuracy) {

    override fun getName(): String = "Ln"
    override fun getDomain(): List<Range<in BigDecimalInfinityExtended>> =
        listOf(
            BigDecimalOpenStartRange(
                startExclusive = BigDecimalInfinityExtended(0.0),
                end = BigDecimalInfinityExtended(Double.POSITIVE_INFINITY),
            )
        )

    override fun decompose(input: BigDecimalInfinityExtended, accuracy: Double): BigDecimalInfinityExtended {
        val x = input.toBigDecimal()
        println(x)
        val xReplacement: BigDecimal = (input.toBigDecimal() - BigDecimal.ONE) / (BigDecimal.ONE + input.toBigDecimal())
        var numerator = xReplacement
        var denominator = BigDecimal.ONE
        var result = BigDecimal.TWO * numerator / denominator
        var numberOfTerms = 1

        do {
            numerator *= xReplacement * xReplacement
            denominator += BigDecimal.TWO
            result += BigDecimal.TWO * numerator / denominator
            numberOfTerms++
        } while (numberOfTerms <= MAX_NUMBER_OF_TERMS) //TODO(improve)

        return BigDecimalInfinityExtended(result)
    }

    private companion object {
        const val MAX_NUMBER_OF_TERMS = 10_000
    }
}