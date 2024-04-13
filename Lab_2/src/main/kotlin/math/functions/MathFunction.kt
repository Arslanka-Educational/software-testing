package math.functions

import math.ranges.Range
import java.util.function.Function

interface MathFunction<in Input, out Output> :
    Function<@UnsafeVariance Input, @UnsafeVariance Output> where Input : Number, Input : Comparable<Input>, Output : Number {

    fun getName(): String
    fun getDomain(): Range<in @UnsafeVariance Input>
    fun calculate(input: Input): Output
    override fun apply(input: Input): Output {
        return if (getDomain().contains(input)) {
            calculate(input)
        } else {
            throw OutOfDomainException(getName())
        }
    }
}