package math.functions

import math.numbers.BigDecimalInfinityExtended
import math.numbers.div
import math.numbers.minus
import math.numbers.plus
import math.numbers.times
import math.ranges.Range

operator fun <Input> MathFunction<Input, BigDecimalInfinityExtended>.plus(other: MathFunction<Input, BigDecimalInfinityExtended>): MathFunction<Input, BigDecimalInfinityExtended>
    where Input : Number, Input : Comparable<Input> {
    return object : MathFunction<Input, BigDecimalInfinityExtended> {
        override fun getName(): String {
            return "${this@plus.getName()} + ${other.getName()}"
        }

        override fun getDomain(): List<Range<in Input>> {
            return this@plus.getDomain() + other.getDomain()
        }

        override fun calculate(input: Input): BigDecimalInfinityExtended {
            return this@plus.apply(input) + other.apply(input)
        }
    }
}

operator fun <Input> MathFunction<Input, BigDecimalInfinityExtended>.minus(other: MathFunction<Input, BigDecimalInfinityExtended>): MathFunction<Input, BigDecimalInfinityExtended>
    where Input : Number, Input : Comparable<Input> {
    return object : MathFunction<Input, BigDecimalInfinityExtended> {
        override fun getName(): String {
            return "${this@minus.getName()} - ${other.getName()}"
        }

        override fun getDomain(): List<Range<in Input>> {
            return this@minus.getDomain() + other.getDomain()
        }

        override fun calculate(input: Input): BigDecimalInfinityExtended {
            return this@minus.apply(input) - other.apply(input)
        }
    }
}

operator fun <Input> MathFunction<Input, BigDecimalInfinityExtended>.times(other: MathFunction<Input, BigDecimalInfinityExtended>): MathFunction<Input, BigDecimalInfinityExtended>
    where Input : Number, Input : Comparable<Input> {
    return object : MathFunction<Input, BigDecimalInfinityExtended> {
        override fun getName(): String {
            return "${this@times.getName()} * ${other.getName()}"
        }

        override fun getDomain(): List<Range<in Input>> {
            return this@times.getDomain() + other.getDomain()
        }

        override fun calculate(input: Input): BigDecimalInfinityExtended {
            return this@times.apply(input) * other.apply(input)
        }
    }
}

operator fun <Input> MathFunction<Input, BigDecimalInfinityExtended>.div(other: MathFunction<Input, BigDecimalInfinityExtended>): MathFunction<Input, BigDecimalInfinityExtended>
    where Input : Number, Input : Comparable<Input> {
    return object : MathFunction<Input, BigDecimalInfinityExtended> {
        override fun getName(): String {
            return "${this@div.getName()} / ${other.getName()}"
        }

        override fun getDomain(): List<Range<in Input>> {
            return this@div.getDomain() + other.getDomain()
        }

        override fun calculate(input: Input): BigDecimalInfinityExtended {
            return this@div.apply(input) / other.apply(input)
        }
    }
}

infix fun <Input> MathFunction<Input, BigDecimalInfinityExtended>.pow(num: Int): MathFunction<Input, BigDecimalInfinityExtended>
    where Input : Number, Input : Comparable<Input> {
    return object : MathFunction<Input, BigDecimalInfinityExtended> {
        override fun getName(): String {
            return "${this@pow.getName()}^($num)"
        }

        override fun getDomain(): List<Range<in Input>> {
            return this@pow.getDomain()
        }

        override fun calculate(input: Input): BigDecimalInfinityExtended {
            return BigDecimalInfinityExtended(this@pow.apply(input).toBigDecimal().pow(num))
        }
    }
}
