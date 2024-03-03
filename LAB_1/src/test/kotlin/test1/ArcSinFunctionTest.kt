package task1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.PI

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArcSinFunctionTest {
    private lateinit var function: ArcSinFunction

    @BeforeAll
    fun tearUp() {
        function = ArcSinFunction()
    }

    @Test
    fun `when x is 1, should return something close to PI div 2`() {
        val x = 1.0
        val iterations = 1_000
        val epsilon = 1e-1

        val result = function.calculate(x, iterations)

        assertThat(result).isBetween(PI / 2.0 - epsilon, PI / 2.0 + epsilon)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 15, 30, 45])
    fun `when x = 1, should return something close to PI div 2`(n: Int) {
        val x = 1.0

        val res = function.calculate(x, n)

        assertThat(res).isBetween(1.4, Math.PI / 2.0)
    }

    @Test
    fun `when x is 0, should return 0`() {
        val x = 0.0
        val iterations = 1_000

        val result = function.calculate(x, iterations)

        assertThat(result).isEqualTo(0.0)
    }

    @ParameterizedTest
    @CsvSource(
        "-0.01, 1000",
        "0.0, 1000",
        "0.01, 1000"
    )
    fun `when x is close to 0, should return something close to 0`(x: Double, iterations: Int) {
        val epsilon = 1e-2

        val res = function.calculate(x, iterations)

        assertThat(res).isBetween(0.0 - epsilon, 0.0 + epsilon)
    }

    @Test
    fun `when x is -1, should return something close to -PI div 2`() {
        val x = -1.0
        val iterations = 1_000
        val epsilon = 1e-1

        val result = function.calculate(x, iterations)

        assertThat(result).isBetween(-PI / 2.0 - epsilon, -PI / 2.0 + epsilon)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 15, 30, 45])
    fun `when x = -1, should return something close to -(PI div 2)`(n: Int) {
        val x = -1.0

        val res = function.calculate(x, n)

        assertThat(res).isBetween(-Math.PI / 2.0, -1.4)
    }

    @ParameterizedTest
    @ValueSource(doubles = [1.001, -1.1])
    fun `when x is out of range, should return Double NaN`(x: Double) {
        val iterations = 1

        val result = function.calculate(x, iterations)

        assertThat(result).isNaN()
    }
}
