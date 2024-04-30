package math.functions

import file.csv.CSVUtils
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
import math.numbers.pow
import math.ranges.BigDecimalOpenRange
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.math.BigDecimal
import java.nio.file.Path
import java.util.function.Predicate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PiecewiseFunctionSeriesDecomposableTest {

    private lateinit var sin: SinSeriesDecomposable
    private lateinit var cos: CosSeriesDecomposable
    private lateinit var tan: TanSeriesDecomposable
    private lateinit var cot: CotSeriesDecomposable
    private lateinit var sec: SecSeriesDecomposable
    private lateinit var csc: CscSeriesDecomposable
    private lateinit var ln: NaturalLogSeriesDecomposable
    private lateinit var log2: BaseLogSeriesDecomposable
    private lateinit var log3: BaseLogSeriesDecomposable
    private lateinit var log5: BaseLogSeriesDecomposable
    private lateinit var piecewiseFunctionSeriesDecomposable: PiecewiseFunctionSeriesDecomposable

    private companion object {
        private const val ACCURACY = 0.0001
    }

    @BeforeAll
    internal fun init() {
        sin = Mockito.mock(SinSeriesDecomposable::class.java)
        cos = Mockito.mock(CosSeriesDecomposable::class.java)
        tan = Mockito.mock(TanSeriesDecomposable::class.java)
        cot = Mockito.mock(CotSeriesDecomposable::class.java)
        sec = Mockito.mock(SecSeriesDecomposable::class.java)
        csc = Mockito.mock(CscSeriesDecomposable::class.java)
        ln = Mockito.mock(NaturalLogSeriesDecomposable::class.java)
        log2 = Mockito.mock(BaseLogSeriesDecomposable::class.java)
        log3 = Mockito.mock(BaseLogSeriesDecomposable::class.java)
        log5 = Mockito.mock(BaseLogSeriesDecomposable::class.java)
        piecewiseFunctionSeriesDecomposable = PiecewiseFunctionSeriesDecomposable(
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
                        Double.POSITIVE_INFINITY,
                    ),
                ),
            ),
        )
    }


    @Test
    internal fun `piecewise test`() {
        val cosData =
            CSVUtils.readCSV(Path.of("../../resources/dataInput/cos_values.csv"))
        val cotData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/cot_values.csv"))
        val cscData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/csc_values.csv"))
        val secData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/sec_values.csv"))
        val sinData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/sin_values.csv"))
        val tanData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/tan_values.csv"))
        val lnData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/ln_values.csv"))
        val log2Data =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/log2_values.csv"))
        val log3Data =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/log3_values.csv"))
        val log5Data =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/log5_values.csv"))
        val piecewisefunctionData =
            CSVUtils.readCSV(Path.of("../../../resources/dataInput/piecewiseFunction.csv"))

        for (i in piecewisefunctionData.indices) {
            val xValue = BigDecimal(piecewisefunctionData[i][0])
            val yValue = BigDecimal(piecewisefunctionData[i][1])

            if (xValue < BigDecimal.ZERO) {
                `when`(sin.apply(BigDecimalInfinityExtended(sinData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        sinData[i][1]
                    )
                )
                `when`(cos.apply(BigDecimalInfinityExtended(cosData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        cosData[i][1]
                    )
                )
                `when`(tan.apply(BigDecimalInfinityExtended(tanData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        tanData[i][1]
                    )
                )
                `when`(cot.apply(BigDecimalInfinityExtended(cotData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        cotData[i][1]
                    )
                )
                `when`(csc.apply(BigDecimalInfinityExtended(cscData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        cscData[i][1]
                    )
                )
                `when`(sec.apply(BigDecimalInfinityExtended(secData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        secData[i][1]
                    )
                )
            } else {
                `when`(ln.apply(BigDecimalInfinityExtended(lnData[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        lnData[i][1]
                    )
                )
                `when`(log2.apply(BigDecimalInfinityExtended(log2Data[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        log2Data[i][1]
                    )
                )
                `when`(log3.apply(BigDecimalInfinityExtended(log3Data[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        log3Data[i][1]
                    )
                )
                `when`(log5.apply(BigDecimalInfinityExtended(log5Data[i][0]))).thenReturn(
                    BigDecimalInfinityExtended(
                        log5Data[i][1]
                    )
                )
            }
            assertThat(piecewiseFunctionSeriesDecomposable.apply(BigDecimalInfinityExtended(xValue))).isBetween(
                BigDecimalInfinityExtended(yValue) pow 13,
                BigDecimalInfinityExtended(yValue) pow 15,
            )
        }
    }
}