package math.functions

import math.series.SeriesDecomposable

abstract class SeriesMathFunction<in Input, out Output, out Accuracy>(
    private val accuracy: Accuracy,
) :
    MathFunction<Input, Output>,
    SeriesDecomposable<@UnsafeVariance Input, @UnsafeVariance Output, @UnsafeVariance Accuracy> where Input : Number, Input : Comparable<Input>, Output : Number, Accuracy : Number {
    override fun calculate(input: Input): Output =
        decompose(input, accuracy)
}