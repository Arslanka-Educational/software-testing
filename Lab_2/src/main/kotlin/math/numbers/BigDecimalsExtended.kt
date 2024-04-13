package math.numbers

import java.math.RoundingMode

operator fun BigDecimalInfinityExtended.plus(other: BigDecimalInfinityExtended): BigDecimalInfinityExtended =
    BigDecimalInfinityExtended(this.toBigDecimal().add(other.toBigDecimal()))

operator fun BigDecimalInfinityExtended.minus(other: BigDecimalInfinityExtended): BigDecimalInfinityExtended =
    BigDecimalInfinityExtended(this.toBigDecimal().subtract(other.toBigDecimal()))

operator fun BigDecimalInfinityExtended.div(other: BigDecimalInfinityExtended): BigDecimalInfinityExtended =
    BigDecimalInfinityExtended(this.toBigDecimal().divide(other.toBigDecimal(), RoundingMode.HALF_EVEN))

operator fun BigDecimalInfinityExtended.times(other: BigDecimalInfinityExtended): BigDecimalInfinityExtended =
    BigDecimalInfinityExtended(this.toBigDecimal().multiply(other.toBigDecimal()))
