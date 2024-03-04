package task3

import org.jetbrains.annotations.TestOnly

internal class Marvin(
    private val _logicalSchemes: List<LogicalScheme>,
    private var _direction: Direction,
    private var _emotionalState: EmotionalState
) {
    val emotionalState: EmotionalState
        @TestOnly get() = this._emotionalState
    val direction: Direction
        @TestOnly get() = this._direction

    val logicalSchemes: List<LogicalScheme>
        @TestOnly get() = this._logicalSchemes

    fun observeWithEmotionalState(emotionalState: EmotionalState) {
        this._emotionalState = emotionalState
    }

    fun manipulateIdea(idea: Idea) {
        idea.embody()
    }

    fun compareMolecularComponents(
        lMolecularComponent: MolecularComponent,
        rMolecularComponent: MolecularComponent,
    ): Boolean {
        return lMolecularComponent.cells == rMolecularComponent.cells
    }

    fun measureAvgHydrogenLevel(measurable: HydrogenMeasurable): HydrogenLevel {
        val avgThreshold = _logicalSchemes.map {
            it.measureHydrogenLevel(measurable = measurable).threshold
        }.average()

        return HydrogenLevel.getLevelByThreshold(hydrogenLevelThreshold = avgThreshold)
    }

    fun changeDirectionTo(direction: Direction) {
        this._direction = direction
    }

    fun disconnectSchemes() {
        _logicalSchemes.forEach {
            it.disconnect()
        }
    }
}

