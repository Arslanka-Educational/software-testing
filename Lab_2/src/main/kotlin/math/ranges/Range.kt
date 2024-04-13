package math.ranges

interface ClosedRange<T : Comparable<T>> : Range<T> {

    val start: T

    val endInclusive: T

    override operator fun contains(value: T): Boolean = value in start..endInclusive

    override fun isEmpty(): Boolean = start > endInclusive
}

interface OpenEndRange<T : Comparable<T>> : Range<T> {
    val start: T

    val endExclusive: T
    override operator fun contains(value: T): Boolean = value >= start && value < endExclusive

    override fun isEmpty(): Boolean = start >= endExclusive


}

interface OpenStartRange<T : Comparable<T>> : Range<T> {

    val startExclusive: T

    val end: T
    override operator fun contains(value: T): Boolean = value > startExclusive && value <= end

    override fun isEmpty(): Boolean = startExclusive >= end
}

interface OpenRange<T : Comparable<T>> : Range<T> {

    val startExclusive: T

    val endExclusive: T
    override operator fun contains(value: T): Boolean = value > startExclusive && value < endExclusive

    override fun isEmpty(): Boolean = startExclusive > endExclusive
}

interface Range<T : Comparable<T>> {
    operator fun contains(value: T): Boolean

    fun isEmpty(): Boolean
}

