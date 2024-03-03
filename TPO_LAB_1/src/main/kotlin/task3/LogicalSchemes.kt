package task3;

import task3.enum.TestAction

class LogicalSchemes {
    fun performAction(action: TestAction) {
        when (action) {
            TestAction.ACTIVATE_LOGICAL_SCHEMES -> {
                println("Логические схемы активированы.")
            }
            TestAction.MANIPULATE_LOGICAL_SCHEMES -> {
                println("Логические схемы манипулируют ситуацией.")
            }
        }
    }
}