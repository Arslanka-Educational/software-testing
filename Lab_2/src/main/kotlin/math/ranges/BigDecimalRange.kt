package math.ranges

import math.numbers.BigDecimalInfinityExtended

data class BigDecimalOpenStartRange(override val startExclusive: BigDecimalInfinityExtended, override val end: BigDecimalInfinityExtended) : OpenStartRange<BigDecimalInfinityExtended>

data class BigDecimalOpenRange(override val startExclusive: BigDecimalInfinityExtended, override val endExclusive: BigDecimalInfinityExtended): OpenRange<BigDecimalInfinityExtended>