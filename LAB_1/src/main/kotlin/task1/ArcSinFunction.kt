package task1

import java.math.BigDecimal

class ArcSinFunction {
    private val factorialCache = mutableMapOf<Int, BigDecimal>()

    fun calculate(inputX: Double, iterations: Int): Double {
        val x = inputX.toBigDecimal()
        return if (x !in BigDecimal.ONE.unaryMinus()..BigDecimal.ONE) {
            Double.NaN
        } else {
            calculateArcSin(x, iterations).toDouble()
        }
    }

    private fun calculateArcSin(x: BigDecimal, iterations: Int): BigDecimal {
        var result = BigDecimal.ZERO
        for (i in 0..iterations) {
            val term = calculateTerm(x, i)
            result += term
        }
        return result
    }

    private fun calculateTerm(x: BigDecimal, n: Int): BigDecimal {
        val numerator = factorial(2 * n) * x.pow(2 * n + 1)
        val denominator = BigDecimal("4").pow(n) * factorial(n).pow(2) * BigDecimal((2 * n + 1).toString())
        return numerator / denominator
    }

    private fun factorial(n: Int): BigDecimal {
        if (n <= 1) return BigDecimal.ONE

        var result = BigDecimal.ONE
        for (i in 2..n) {
            result *= BigDecimal.valueOf(i.toLong())
        }
        return result
    }

}
