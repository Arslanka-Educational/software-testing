package math.series

fun interface SeriesDecomposable<Input : Number, Output : Number, Accuracy : Number> {
    fun decompose(input: Input, accuracy: Accuracy): Output
}