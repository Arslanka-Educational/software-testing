package task3

import task3.enum.TestAction
import kotlin.random.Random

class Space {
    fun performAction(action: TestAction) {
        when (action) {
            TestAction.MEASURE_HYDROGEN_LEVEL -> {
                val hydrogenLevel = Random.nextDouble(0.0, 10.0)
                println("Измеряется уровень водорода в космосе: $hydrogenLevel.")
            }
        }
    }
}
