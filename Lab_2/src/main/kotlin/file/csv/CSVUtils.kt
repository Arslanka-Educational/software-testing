package file.csv

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.math.BigDecimal
import java.nio.file.Path

class CSVUtils(private val folderPath: String) {
    fun write(data: List<Pair<Double, Double>>, filename: String) {
        val csvData = data.map { "${it.first}, ${it.second}" }
        val file = File("$folderPath/$filename")
        file.parentFile.mkdirs() // Создаем папки, если их нет
        try {
            file.bufferedWriter().use { writer ->
                csvData.forEach { line ->
                    writer.write(line)
                    writer.newLine()
                }
            }
            println("CSV файл успешно записан: ${file.absolutePath}")
        } catch (e: IOException) {
            println("Ошибка при записи в CSV файл $filename: ${e.message}")
        }
    }
    companion object {
        @JvmStatic
        fun readCSV(fileName: String): List<List<BigDecimal>> {
            val data = mutableListOf<List<BigDecimal>>()
            File(fileName).bufferedReader().use { reader ->
                var line = reader.readLine()
                line = reader.readLine()
                while (line != null) {
                    val values = line.split(",").map { it.trim().toBigDecimal() }
                    data.add(values)
                    line = reader.readLine()
                }
            }
            return data
        }
    }
}