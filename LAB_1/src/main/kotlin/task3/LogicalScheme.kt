package task3

internal class LogicalScheme(
    override var state: SchemaState,
) : Scheme {
    override fun disconnect() {
        this.state = SchemaState.INACTIVE
    }
    fun measureHydrogenLevel(measurable: HydrogenMeasurable): HydrogenLevel {
        return measurable.measureHydrogenLevel()
    }
}