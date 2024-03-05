package task1

import task1.`class`.ArcSinCalculator
import task1.`class`.FactorialCalculator
import task1.`class`.TermCalculator
import task1.`interface`.TrigonometricFunction
import java.math.BigDecimal

class ArcSinFunction : TrigonometricFunction {
    override fun calculate(inputX: Double, iterations: Int): Double {
        val x = inputX.toBigDecimal()
        return if (x !in BigDecimal.ONE.unaryMinus()..BigDecimal.ONE) {
            Double.NaN
        } else {
            val factorialCalculator = FactorialCalculator()
            val termCalculator = TermCalculator(factorialCalculator)
            val arcSinCalculator = ArcSinCalculator(termCalculator)
            arcSinCalculator.calculateArcSin(x, iterations).toDouble()
        }
    }
}


