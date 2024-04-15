import math.functions.logarithmic.BaseLogSeriesDecomposable
import math.functions.logarithmic.NaturalLogSeriesDecomposable
import math.functions.trigonometric.CosSeriesDecomposable
import math.functions.trigonometric.SinSeriesDecomposable
import math.numbers.BigDecimalInfinityExtended
import java.io.File
import java.io.IOException
import java.math.BigDecimal

fun main() {
    val folderPath = "/Users/zhenyamint/IdeaProjects/TPO 2/software-testing/Lab_2/src/main/kotlin/fileCSV"
    val csvWriter = CSVWriter(folderPath)

    val naturalLogResults = mutableListOf<Pair<Double, Double>>()
    val log2Results = mutableListOf<Pair<Double, Double>>()
    val log3Results = mutableListOf<Pair<Double, Double>>()
    val log5Results = mutableListOf<Pair<Double, Double>>()
    val sinResults = mutableListOf<Pair<Double, Double>>()
    val cosResults = mutableListOf<Pair<Double, Double>>()

    val step = 0.1
    val start = 0.1
    val end = 10.0

    val naturalLogSeries = NaturalLogSeriesDecomposable(0.0001)
    val sinSeries = SinSeriesDecomposable(0.0001)
    val cosSeries = CosSeriesDecomposable(sinSeries)
    val log2Series = BaseLogSeriesDecomposable(BigDecimalInfinityExtended(BigDecimal(2)), naturalLogSeries)
    val log3Series = BaseLogSeriesDecomposable(BigDecimalInfinityExtended(BigDecimal(3)), naturalLogSeries)
    val log5Series = BaseLogSeriesDecomposable(BigDecimalInfinityExtended(BigDecimal(5)), naturalLogSeries)

    var x = start
    while (x <= end) {
     //   naturalLogResults.add(x to naturalLogSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
      //  log2Results.add(x to log2Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
     //   log3Results.add(x to log3Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
     //   log5Results.add(x to log5Series.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        sinResults.add(x to sinSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        cosResults.add(x to cosSeries.decompose(BigDecimalInfinityExtended(x), 0.001).toDouble())
        x += step
    }

    csvWriter.write(naturalLogResults, "natural_log_results.csv")
    csvWriter.write(log2Results, "log2_results.csv")
    csvWriter.write(log3Results, "log3_results.csv")
    csvWriter.write(log5Results, "log5_results.csv")
    csvWriter.write(sinResults, "sin_results.csv")
    csvWriter.write(cosResults, "cos_results.csv")
}