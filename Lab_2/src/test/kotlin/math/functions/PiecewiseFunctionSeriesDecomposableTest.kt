package math.functions

import math.functions.complex.PiecewiseFunctionSeriesDecomposable
import math.functions.logarithmic.BaseLogSeriesDecomposable
import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.CotSeriesDecomposable
import math.functions.trigonometric.CscSeriesDecomposable
import math.functions.trigonometric.SecSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.functions.trigonometric.TanSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import math.numbers.plus
import math.ranges.BigDecimalOpenRange
import math.ranges.BigDecimalOpenStartRange
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.function.Predicate

@ExtendWith(MockitoExtension::class)
class PiecewiseFunctionSeriesDecomposableTest {

    @Mock
    private lateinit var sinSeriesMock: SinSeriesDecomposable

    @Mock
    private lateinit var naturalLogSeriesDecomposable: NaturalLogSeriesDecomposable

    @Mock
    private lateinit var sin: SinSeriesDecomposable
 //   @Mock
   // private lateinit var ln: NaturalLogSeriesDecomposable
    @Mock
    private lateinit var cos: CosSeriesDecomposable
    @Mock
    private lateinit var tan: TanSeriesDecomposable
    @Mock
    private lateinit var cot: CotSeriesDecomposable
    @Mock
    private lateinit var sec: SecSeriesDecomposable
    @Mock
    private lateinit var csc: CscSeriesDecomposable
    @Mock
    private lateinit var ln: NaturalLogSeriesDecomposable
    private val ACCURACY = 0.0001
    private val log3 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(3.0), ln)
    private val log2 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(2.0), ln)
    private val log5 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(5.0), ln)

    @BeforeAll
    internal fun `test all fun`() {
        val ACCURACY = 0.0001
//        private val sin = SinSeriesDecomposable(ACCURACY)
//        private val cos = CosSeriesDecomposable(ACCURACY, sin)
//        private val tan = TanSeriesDecomposable(sin, cos, ACCURACY)
//        private val cot = CotSeriesDecomposable(sin, cos, ACCURACY)
//        private val sec = SecSeriesDecomposable(cos, ACCURACY)
//        private val csc = CscSeriesDecomposable(sin, ACCURACY)
//        private val ln = NaturalLogSeriesDecomposable(ACCURACY)
    //    private val ACCURACY = 0.0001
     //   private val log3 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(3.0), ln)
     //   private val log2 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(2.0), ln)
     //   private val log5 = BaseLogSeriesDecomposable(ACCURACY, BigDecimalInfinityExtended(5.0), ln)
         val piecewiseFunction = PiecewiseFunctionSeriesDecomposable(
            listOf(
                Pair(((((((((((((((((sec / cos) * csc) / sec) + sec) pow 3) / cos) +
                    (tan - tan)) * csc) - sin) / cos) / cos) pow 3) / ((((cos * csc) pow 2) * (csc pow 2)) - (sec * csc))) * sec) pow 3)
                    + (tan * (((cos * tan) - ((tan pow 2) / tan)) + (((tan / sin) / tan) * tan))))
                    + ((((((((sin - sec) - (cot / (tan - csc))) / tan) / ((csc + csc) + cos))
                    + ((cot / (sec / (((sin - sin) - tan) + cot))) * (sec / tan))) pow 3) pow 3)
                    + (((csc * (cot + (sec / (sin + cot)))) - ((csc + ((tan * sec) + sec)) / ((sin * ((cos + cot) / (sin + sec))) - sin)))
                    + (sin + ((csc * (tan / cos)) / ((tan pow 2) - tan))))),
                    Predicate {
                        it in BigDecimalOpenRange(
                            startExclusive = BigDecimalInfinityExtended(
                                Double.NEGATIVE_INFINITY,
                            ),
                            endExclusive = BigDecimalInfinityExtended(
                                0.0,
                            ),
                        )
                    }),
                Pair(
                    (((((log3 pow 3) - log5) * log2) + (log5 * ln)) pow 3),
                    Predicate {
                        it in BigDecimalOpenRange(
                            startExclusive = BigDecimalInfinityExtended(
                                0.0,
                            ),
                            endExclusive = BigDecimalInfinityExtended(
                                Double.POSITIVE_INFINITY,
                            ),
                        )
                    }),
            ),
            accuracy = ACCURACY,
            domain = listOf(
                BigDecimalOpenRange(
                    startExclusive = BigDecimalInfinityExtended(
                        Double.NEGATIVE_INFINITY,
                    ),
                    endExclusive = BigDecimalInfinityExtended(
                        0.0,
                    ),
                ),
            ),
        )
    }
}
