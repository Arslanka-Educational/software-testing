package file.csv

import java.io.File
import java.io.IOException

class CSVWriter(private val folderPath: String) {
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
}