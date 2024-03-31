package functions.logarithmic

import constant.Constant
import constant.Constant.SCALE
import functions.Computations
import java.math.BigDecimal
import java.math.RoundingMode

class Ln : Computations {


    override fun calculationWithPrecision(x: BigDecimal, eps: BigDecimal): BigDecimal {
        assertX(x)
        return calculateDecomposition(
            x = x,
            eps = eps,
        )
    }
    private fun calculateDecomposition(
        x: BigDecimal,
        eps: BigDecimal?,
    ): BigDecimal {
        assertX(x)

        val constant = ((x - BigDecimal.ONE).pow(2))
            .divide((x + BigDecimal.ONE).pow(2), SCALE, RoundingMode.HALF_UP)
        var currentValue = (x - BigDecimal.ONE)
            .divide((x + BigDecimal.ONE), SCALE, RoundingMode.HALF_UP)

        var sum = BigDecimal.ZERO
        var step = 1

        fun condition(): Boolean {
            return if (eps != null) {
                currentValue.abs() > eps.divide(Constant.Numbers.TWO, SCALE, RoundingMode.HALF_UP)
            } else {
                false
            }
        }

        while (condition()) {
            sum += currentValue
            val nVal = (2 * step - 1).toBigDecimal()
            currentValue = (nVal * currentValue * constant) / (2 * step + 1).toBigDecimal()
            step++
        }
        sum *= Constant.Numbers.TWO
        return sum
    }

    private fun assertX(x: BigDecimal) {
        if (x <= BigDecimal.ZERO) {
            throw Exception("Логарифм от отрицательного числа")
        }
    }
}