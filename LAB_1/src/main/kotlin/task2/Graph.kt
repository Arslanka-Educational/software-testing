import java.util.*

class DijkstraAlgorithm(private val graph: Array<IntArray>) {
    private val numVertices: Int = graph.size

    fun shortestPath(startVertex: Int): IntArray {
        val dist = IntArray(numVertices) { Int.MAX_VALUE }
        dist[startVertex] = 0

        val visited = BooleanArray(numVertices)

        for (count in 0 until numVertices - 1) {
            val u = minDistance(dist, visited)
            visited[u] = true
            for (v in 0 until numVertices)
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v]
        }

        // Проверяем, остались ли вершины, до которых нет пути, и если да, устанавливаем для них 0
        for (i in dist.indices) {
            if (dist[i] == Int.MAX_VALUE) {
                dist[i] = 0
            }
        }

        return dist
    }

    private fun minDistance(dist: IntArray, visited: BooleanArray): Int {
        var min = Int.MAX_VALUE
        var minIndex = -1
        for (v in 0 until numVertices)
            if (!visited[v] && dist[v] <= min) {
                min = dist[v]
                minIndex = v
            }
        return minIndex
    }
}
