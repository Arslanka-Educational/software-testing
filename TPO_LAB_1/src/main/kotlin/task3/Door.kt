package task3

import task3.enum.TestAction
import kotlin.random.Random

class Door {
    fun performAction(action: TestAction) {
        when (action) {
            TestAction.APPLY_PHYSICAL_FORCE -> {
                if (Random.nextBoolean()) {
                    println("Физическая сила применяется к двери.")
                } else {
                    println("Физическая сила не применяется к двери.")
                }
            }
        }
    }
}