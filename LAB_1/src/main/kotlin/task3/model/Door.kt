package task3.model

data class Door(
    val components: List<DoorComponent>,
    var damaged: Boolean = false
)