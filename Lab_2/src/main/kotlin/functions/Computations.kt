package functions

import java.math.BigDecimal

interface Computations {
    fun calculationWithPrecision(x: BigDecimal, eps: BigDecimal = 0.0000000000000001.toBigDecimal()): BigDecimal
}