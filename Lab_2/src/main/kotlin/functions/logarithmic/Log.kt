package functions.logarithmic

import constant.Constant.SCALE
import functions.Computations
import java.math.BigDecimal
import java.math.RoundingMode


class Log(private val naturalLogarithm: Ln = Ln()) {
    fun evaluate(x: BigDecimal, base: BigDecimal, eps: BigDecimal): BigDecimal {
        val lnX = naturalLogarithm.calculationWithPrecision(x, eps)
        val lnBase = naturalLogarithm.calculationWithPrecision(base, eps)
        return lnX.divide(lnBase, SCALE, RoundingMode.UP)
    }
}

