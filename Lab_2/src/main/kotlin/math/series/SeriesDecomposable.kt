package math.series

fun interface SeriesDecomposable<in Input : Number, out Output : Number, in Accuracy : Number> {
    fun decompose(input: Input, accuracy: Accuracy): Output
}