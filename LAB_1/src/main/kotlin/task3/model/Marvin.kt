package task3.model

import task3.enum.EmotionalState

data class Marvin(
    val logicalSchemes: List<LogicalScheme>,
    var emotionalState: EmotionalState = EmotionalState.COLD_CONTEMPT
)