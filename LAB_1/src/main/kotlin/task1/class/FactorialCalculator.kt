package task1.`class`

import java.math.BigDecimal

class FactorialCalculator {
    private val factorialCache = mutableMapOf<Int, BigDecimal>()

    fun factorial(n: Int): BigDecimal {
        return factorialCache.getOrPut(n) {
            if (n <= 1) BigDecimal.ONE
            else (2..n).fold(BigDecimal.ONE) { acc, i -> acc * BigDecimal(i) }
        }
    }
}