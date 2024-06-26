package math.functions

import math.series.SeriesDecomposable

abstract class SeriesMathFunction<Input, Output, Accuracy>(
    open val accuracy: Accuracy,
) :
    MathFunction<Input, Output>,
    SeriesDecomposable<Input, Output, Accuracy> where Input : Number, Input : Comparable<Input>, Output : Number, Accuracy : Number {
    override fun calculate(input: Input): Output =
        decompose(input, accuracy)
}