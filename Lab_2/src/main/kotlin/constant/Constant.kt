package constant

import java.math.BigDecimal
import java.math.RoundingMode

object Constant {
    const val SCALE = 30

    object Numbers {
        val TWO = BigDecimal.ONE + BigDecimal.ONE
        val THREE = TWO + BigDecimal.ONE
        val FIVE = THREE + TWO
        val TEN = FIVE + FIVE
        val PI = Math.PI.toBigDecimal()
        val PI_DIV_2 = PI.divide(TWO, SCALE, RoundingMode.HALF_UP)
        val PI_2 = PI + PI
    }
}