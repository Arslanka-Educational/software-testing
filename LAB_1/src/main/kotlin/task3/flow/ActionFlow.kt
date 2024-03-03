package task3.flow

import task3.enum.*
import task3.enum.DoorComponent
import task3.model.*
import java.util.logging.Logger

class ActionFlow {

    fun observe(marvin: Marvin) {
        marvin.emotionalState = EmotionalState.DESPERATION
    }

    fun manipulateIdeaOfViolence(marvin: Marvin, door: Door) {
        if (marvin.emotionalState == EmotionalState.COLD_CONTEMPT) {
            door.damaged = true
        }
    }

    fun compareDoorComponentTypes(door: Door, targetType: DoorComponent): Boolean {
        return door.components.any { it.type.description == targetType.description }
    }

    fun compareComponents(door: Door, humanBrainCells: HumanBrainCells): ComponentComparisonResult {
        val doorComponentsCount = door.components.size
        val brainComponentsCount = humanBrainCells.composition.split(" ").size
        return when {
            doorComponentsCount == brainComponentsCount -> ComponentComparisonResult.EQUAL
            doorComponentsCount > brainComponentsCount -> ComponentComparisonResult.DOOR_HAS_MORE
            else -> ComponentComparisonResult.BRAIN_HAS_MORE
        }
    }

    fun measureHydrogenLevel(space: Space): HydrogenLevel {
        return HydrogenLevel.getLevel(space.hydrogenLevel)
    }



    fun observe(environment: Environment, marvin: Marvin) {
      //Marvin наблюдает
        val message = when (environment.state) {
            EnvironmentState.CALM -> {
                marvin.emotionalState = EmotionalState.COLD_CONTEMPT
                "Среда спокойная. Marvin переходит в состояние холодного презрения."
            }
            EnvironmentState.DANGER -> {
                marvin.emotionalState = EmotionalState.DESPERATION
                "Среда опасная. Marvin переходит в состояние отчаяния."
            }
            else -> {
                "Неизвестное состояние окружающей среды."
            }
        }
    }
}