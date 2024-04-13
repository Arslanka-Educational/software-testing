package math.ranges

data class DoubleOpenStartRange(override val startExclusive: Double, override val end: Double) : OpenStartRange<Double>
