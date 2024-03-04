package test1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import task1.ArcSinFunction

class ArcSinFunctionTest {

    @Nested
    inner class CalculateTests {
        @ParameterizedTest(name = "{index} - Arc sin of {0} is {2}")
        @CsvSource(
            "0, 10, 0, 0",
            "0.5, 100, 0.5235987756, π/6",
            "-0.5, 100, -0.5235987756, -π/6",
            "0.86602540378, 100, 1.0471975512, π/3",
            "-0.86602540378, 100, -1.0471975512, -π/3",
            "0.70710678118, 100, 0.7853981634, π/4",
            "-0.70710678118, 100, -0.7853981634, -π/4"
        )
        fun `arcsin calculator in main points and 0`(inputX: Double, iterations: Int, expected: Double) {
            val arcSinFunction = ArcSinFunction()
            val result = arcSinFunction.calculate(inputX, iterations)
            assertEquals(expected, result, 0.001)
        }

        @ParameterizedTest
        @CsvSource(
            "1.0, 3000, 1.5707963267948966, 0.01",
            "-1.0, 3000, -1.5707963267948966, 0.01"
        )
        fun `arcsin calculation of  for extreme cases`(
            inputX: Double,
            iterations: Int,
            expected: Double,
            delta: Double
        ) {
            val arcSinFunction = ArcSinFunction()
            val result = arcSinFunction.calculate(inputX, iterations)
            assertEquals(expected, result, delta)
        }

        @ParameterizedTest
        @CsvSource(
            "2, 10",
            "-2, 10",
            "10, 10",
            "-10, 10"
        )
        fun `arcsin calculation with out of range input`(inputX: Double, iterations: Int) {
            val arcSinFunction = ArcSinFunction()
            val result = arcSinFunction.calculate(inputX, iterations)
            assertEquals(Double.NaN, result)
        }
    }
}