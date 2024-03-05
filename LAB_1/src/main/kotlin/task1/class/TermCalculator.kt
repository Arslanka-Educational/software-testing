package task1.`class`

import java.math.BigDecimal

class TermCalculator(private val factorialCalculator: FactorialCalculator) {
    fun calculateTerm(x: BigDecimal, n: Int): BigDecimal {
        val numerator = factorialCalculator.factorial(2 * n) * x.pow(2 * n + 1)
        val denominator = BigDecimal("4").pow(n) * factorialCalculator.factorial(n).pow(2) * BigDecimal((2 * n + 1).toString())
        return numerator / denominator
    }
}