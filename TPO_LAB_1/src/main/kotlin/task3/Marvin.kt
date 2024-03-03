package task3

import org.gradle.internal.impldep.com.amazonaws.services.s3.model.Bucket
import task3.enum.MarvinState
import task3.enum.TestAction
import java.awt.Desktop

class Marvin {
    var state: MarvinState = MarvinState.NORMAL

    fun performAction(action: TestAction) {
        when (action) {
            TestAction.START_OBSERVATION -> {
                state = MarvinState.OBSERVING
                println("Марвин начал наблюдение.")
            }
            TestAction.FEEL_CONTEMPT -> {
                state = MarvinState.CONTEMPTUOUS
                println("Марвин испытывает презрение к ситуации.")
            }
            TestAction.FEEL_DESPERATION -> {
                state = MarvinState.DESPERATE
                println("Марвин чувствует отчаяние.")
            }
        }
    }
}