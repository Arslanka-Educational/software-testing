package task3

internal class Marvin(
    private val logicalSchemes: List<LogicalScheme>,
    private var emotionalState: EmotionalState,
    private var direction: Direction,
) {
    fun observeWithEmotionalState(emotionalState: EmotionalState) {
        this.emotionalState = emotionalState
    }

    fun manipulateIdea(idea: Idea) {
        idea.embody()
    }

    fun compareMolecularComponents(
        lMolecularComponent: MolecularComponent,
        rMolecularComponent: MolecularComponent
    ): Boolean {
        return lMolecularComponent.cells.containsAll(rMolecularComponent.cells)
                && rMolecularComponent.cells.containsAll(
            lMolecularComponent.cells
        )
    }

    fun measureAvgHydrogenLevel(measurable: HydrogenMeasurable): HydrogenLevel {
        val avgThreshold = logicalSchemes.map {
            it.measureHydrogenLevel(measurable = measurable).threshold
        }.average()

        return HydrogenLevel.getLevelByThreshold(hydrogenLevelThreshold = avgThreshold)
    }

    fun changeDirectionTo(direction: Direction) {
        this.direction = direction
    }

    fun disconnectSchemes() {
        logicalSchemes.forEach {
            it.disconnect()
        }
    }
}

