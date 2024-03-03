package task3

import task3.enum.TestAction

class MolecularComponents {
    fun performAction(action: TestAction) {
        when (action) {
            TestAction.COMPARE_COMPONENTS -> {
                println("Молекулярные компоненты сравниваются.")
            }
        }
    }
}