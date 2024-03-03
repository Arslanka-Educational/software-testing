package task3.enum


enum class HydrogenLevel(val threshold: Int, val description: String) {
    LOW(10, "низок"),
    NORMAL(20, "нормальный"),
    HIGH(30, "высокий");

    companion object {
        fun getLevel(hydrogenLevel: Int): HydrogenLevel {
            return when {
                hydrogenLevel < LOW.threshold -> LOW
                hydrogenLevel < NORMAL.threshold -> NORMAL
                else -> HIGH
            }
        }
    }
}