package math.numbers

import java.math.BigDecimal

class BigDecimalInfinityExtended : Number, Comparable<BigDecimalInfinityExtended> {

    private val value: BigDecimal

    constructor(value: Double) {
        this.value = when (value) {
            Double.NEGATIVE_INFINITY -> NEGATIVE_INFINITY
            Double.POSITIVE_INFINITY -> POSITIVE_INFINITY
            Double.NaN -> NAN
            else -> value.toBigDecimal().stripTrailingZeros()
        }
    }

    constructor(value: BigDecimal) {
        this.value = value
    }

    fun toBigDecimal(): BigDecimal {
        return if (value === NEGATIVE_INFINITY || value === POSITIVE_INFINITY || value === NAN) {
            throw UnsupportedOperationException()
        } else {
            value
        }
    }

    override fun toByte(): Byte = value.toByte()

    override fun toDouble(): Double = value.toDouble()

    override fun toFloat(): Float = value.toFloat()

    override fun toInt(): Int = value.toInt()

    override fun toLong(): Long = value.toLong()

    override fun toShort(): Short = value.toShort()
    override fun compareTo(other: BigDecimalInfinityExtended): Int {

        if (value === NAN || other.value === NAN) {
            throw UnsupportedOperationException()
        }

        if (value === NEGATIVE_INFINITY) {
            return if (other.value === NEGATIVE_INFINITY) {
                0
            } else {
                -1
            }
        } else if (value === POSITIVE_INFINITY) {
            return if (other.value === POSITIVE_INFINITY) {
                0
            } else {
                1
            }
        }

        return if (other.value === NEGATIVE_INFINITY) {
            1
        } else if (other.value === POSITIVE_INFINITY) {
            -1
        } else {
            return value.compareTo(other.value)
        }
    }

    override fun toString(): String {
        return if (value === NEGATIVE_INFINITY) {
            "NEGATIVE_INFINITY"
        } else if (value === POSITIVE_INFINITY) {
            "POSITIVE_INFINITY"
        } else if (value === NAN) {
            "NAN"
        } else {
            value.toPlainString()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BigDecimalInfinityExtended

        return value.stripTrailingZeros() == other.value.stripTrailingZeros()
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        private val NEGATIVE_INFINITY = BigDecimal(Double.MIN_VALUE)
        private val POSITIVE_INFINITY = BigDecimal(Double.MAX_VALUE)
        private val NAN: BigDecimal = BigDecimal(Double.MAX_VALUE)
    }
}