package functions

import functions.logarithmic.Ln
import functions.logarithmic.Log
import java.math.BigDecimal

class FunctionSystems(
    private val ln: Ln = Ln(),
    private val log: Log = Log()
) : Computations {

    override fun calculationWithPrecision(x: BigDecimal, eps: BigDecimal): BigDecimal {
        val log2Result = log.evaluate(x, BigDecimal("2"), eps)
        val log3Result = log.evaluate(x, BigDecimal("3"), eps)
        val log5Result = log.evaluate(x, BigDecimal("5"), eps)

        return if (x > BigDecimal.ZERO) {
            val term1 = log3Result.pow(3) - log5Result
            val term2 = term1 * log2Result
            val term3 = log5Result * ln.calculationWithPrecision(x, eps)
            val result = (term2 + term3).pow(3)
            result
        } else {
            BigDecimal.ZERO // Значение функции при x <= 0
        }
    }
}
