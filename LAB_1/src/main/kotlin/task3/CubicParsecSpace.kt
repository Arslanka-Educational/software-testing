package task3

internal data class CubicParsecSpace(
    val hydrogenLevel: HydrogenLevel
) : HydrogenMeasurable {
    override fun measureHydrogenLevel(): HydrogenLevel {
        return hydrogenLevel
    }
}
