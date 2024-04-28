package math.functions

import math.functions.domains.OutOfDomainException
import math.ranges.Range
import java.util.function.Function

interface MathFunction<Input, Output> :
    Function<Input, Output> where Input : Number, Input : Comparable<Input>, Output : Number {

    fun getName(): String
    fun getDomain(): List<Range<in Input>>
    fun calculate(input: Input): Output
    override fun  apply(input: Input): Output {
        return if (getDomain().any { it.contains(input) }) {
            calculate(input)
        } else {
            throw OutOfDomainException(getName())
        }
    }
}