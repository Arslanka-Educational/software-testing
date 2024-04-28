package math.functions.logarithmic.logarithmic

import math.functions.domains.OutOfDomainException
import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.util.stream.Stream
import kotlin.math.pow

internal class NaturalLogSeriesDecomposableTest {

    private val naturalLogSeriesDecomposable = NaturalLogSeriesDecomposable(accuracy = ACCURACY)

    @ParameterizedTest
    @ValueSource(doubles = [Double.NEGATIVE_INFINITY, Double.MIN_VALUE - 1, Double.MIN_VALUE / 2, 0.0])
    internal fun `throw exception if input is out of domain`(inputValue: Double) {
        assertThrows<OutOfDomainException> {
            naturalLogSeriesDecomposable.apply(BigDecimalInfinityExtended(inputValue))
        }
    }

    @ParameterizedTest
    @MethodSource("getValues")
    internal fun `decompose ln in series result with expected accuracy`(
        inputValue: BigDecimal,
        expectedValue: BigDecimal,
    ) {
        val result = naturalLogSeriesDecomposable.apply(BigDecimalInfinityExtended(inputValue))

        SoftAssertions.assertSoftly {
            it.assertThat(result.toBigDecimal())
                .isBetween(expectedValue - ACCURACY.toBigDecimal(), expectedValue + ACCURACY.toBigDecimal())
        }
    }

    private companion object {
        @JvmStatic
        fun getValues(): Stream<Arguments> = Stream.of(
            Arguments.of(BigDecimal.ONE, BigDecimal.ZERO),
            Arguments.of(Math.E.toBigDecimal(), BigDecimal.ONE),
            Arguments.of(Math.E.pow(2).toBigDecimal(), BigDecimal.TWO),
            Arguments.of(Math.E.pow(5).toBigDecimal(), BigDecimal(5)),
            Arguments.of(Math.E.pow(7).toBigDecimal(), BigDecimal(7)),
        )

        const val ACCURACY = 1e-5
    }
}