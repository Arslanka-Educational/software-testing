import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DijkstraAlgorithmTest {

    @Test
    fun testShortestPath() {
        val graph = arrayOf(
            intArrayOf(0, 4, 0, 0, 0, 0, 0, 8, 0),
            intArrayOf(4, 0, 8, 0, 0, 0, 0, 11, 0),
            intArrayOf(0, 8, 0, 7, 0, 4, 0, 0, 2),
            intArrayOf(0, 0, 7, 0, 9, 14, 0, 0, 0),
            intArrayOf(0, 0, 0, 9, 0, 10, 0, 0, 0),
            intArrayOf(0, 0, 4, 14, 10, 0, 2, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 2, 0, 1, 6),
            intArrayOf(8, 11, 0, 0, 0, 0, 1, 0, 7),
            intArrayOf(0, 0, 2, 0, 0, 0, 6, 7, 0)
        )
        val dijkstra = DijkstraAlgorithm(graph)
        val shortestPath = dijkstra.shortestPath(0)

        // Ожидаемое кратчайшее расстояние от вершины 0 до каждой другой вершины
        val expectedShortestPath = intArrayOf(0, 4, 12, 19, 21, 11, 9, 8, 14)
        // Проверка совпадения фактического и ожидаемого кратчайшего пути
        assertArrayEquals(expectedShortestPath, shortestPath)
    }

    @Test// НАШ ГРАФ
    fun Ifsematrix() {
        val graph = arrayOf(
            intArrayOf(0, 0, 7, 0, 3, 0, 0, 0),
            intArrayOf(0, 0, 0, 7, 0, 0, 4, 0),
            intArrayOf(7, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 7, 0, 0, 0, 0, 0, 1),
            intArrayOf(3, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 3, 0),
            intArrayOf(0, 4, 0, 0, 0, 3, 0, 0),
            intArrayOf(0, 0, 0, 1, 0, 0, 0, 0)
        )
        val dijkstra = DijkstraAlgorithm(graph)
        val shortestPath = dijkstra.shortestPath(0)

        val expectedShortestPath = intArrayOf(0, 0, 4, 0, 3, 0, 0, 0)
        assertArrayEquals(expectedShortestPath, shortestPath)
    }

        @Test
        fun testIfNoPath() {
            val graph = arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0)
            )
            val dijkstra = DijkstraAlgorithm(graph)
            val shortestPath = dijkstra.shortestPath(3)
            val expectedNoPath = intArrayOf(0, 0, 0, 0)
            assertArrayEquals(expectedNoPath, shortestPath)
        }
}
