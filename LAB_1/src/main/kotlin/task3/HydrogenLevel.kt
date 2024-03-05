package task3
internal enum class HydrogenLevel(val threshold: Double, val description: String) {
    LOW(10.0, "низкий"),
    NORMAL(20.0, "нормальный"),
    HIGH(30.0, "высокий");

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