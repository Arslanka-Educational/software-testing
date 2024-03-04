package task3
internal enum class HydrogenLevel(val threshold: Int, val description: String) {
    LOW(10, "низкий"),
    NORMAL(20, "нормальный"),
    HIGH(30, "высокий");

    companion object {
        fun getLevelByThreshold(hydrogenLevelThreshold: Double): HydrogenLevel {
            return when {
                hydrogenLevelThreshold < LOW.threshold -> LOW
                hydrogenLevelThreshold < NORMAL.threshold -> NORMAL
                else -> HIGH
            }
        }
    }
}