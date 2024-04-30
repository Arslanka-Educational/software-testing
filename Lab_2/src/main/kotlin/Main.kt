import file.csv.CSVUtils
import math.functions.logarithmic.BaseLogSeriesDecomposable
import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.CscSeriesDecomposable
import math.functions.trigonometric.SecSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.functions.trigonometric.TanSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import java.math.BigDecimal

fun main() {
    val csvUtils = CSVUtils("src/main/resources")

    val naturalLogResults = mutableListOf<Pair<Double, Double>>()
    val log2Results = mutableListOf<Pair<Double, Double>>()
    val log3Results = mutableListOf<Pair<Double, Double>>()
    val log5Results = mutableListOf<Pair<Double, Double>>()
    val sinResults = mutableListOf<Pair<Double, Double>>()
    val cosResults = mutableListOf<Pair<Double, Double>>()
    val cscResults = mutableListOf<Pair<Double, Double>>()
    val tanResults = mutableListOf<Pair<Double, Double>>()
    val secResults = mutableListOf<Pair<Double, Double>>()

    val step = 0.1
    val start = 0.1
    val end = 10.0

    val naturalLogSeries = NaturalLogSeriesDecomposable(0.001)
    val sinSeries = SinSeriesDecomposable(0.001)
    val cosSeries = CosSeriesDecomposable(0.001, sinSeries)
    val cscSeries = CscSeriesDecomposable(sinSeries, 0.001)
    val secSeries = SecSeriesDecomposable(cosSeries, 0.001)
    val tanSeries = TanSeriesDecomposable(sinSeries, cosSeries, 0.001)
    val log2Series = BaseLogSeriesDecomposable(0.001, BigDecimalInfinityExtended(BigDecimal(2)), naturalLogSeries)
    val log3Series = BaseLogSeriesDecomposable(0.001, BigDecimalInfinityExtended(BigDecimal(3)), naturalLogSeries)
    val log5Series = BaseLogSeriesDecomposable(0.001, BigDecimalInfinityExtended(BigDecimal(5)), naturalLogSeries)

    var x = start
    while (x <= end) {
        naturalLogResults.add(x to naturalLogSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        log2Results.add(x to log2Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        log3Results.add(x to log3Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        log5Results.add(x to log5Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        sinResults.add(x to sinSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        cosResults.add(x to cosSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        cscResults.add(x to cscSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        secResults.add(x to secSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        tanResults.add(x to tanSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        x += step
    }

    csvUtils.write(naturalLogResults, "natural_log_results.csv")
    csvUtils.write(log2Results, "log2_results.csv")
    csvUtils.write(log3Results, "log3_results.csv")
    csvUtils.write(log5Results, "log5_results.csv")
    csvUtils.write(sinResults, "sin_results.csv")
    csvUtils.write(cosResults, "cos_results.csv")
    csvUtils.write(tanResults, "tan_results.csv")
    csvUtils.write(cscResults, "csc_results.csv")
    csvUtils.write(secResults, "sec_results.csv")
}