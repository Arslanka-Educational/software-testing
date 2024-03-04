import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import task3.DamageIdea
import task3.Survivable
import kotlin.test.assertEquals

internal class DamageIdeaTest {

        @ParameterizedTest
        @CsvSource("10, 9", "5, 4", "0, -1") // Initial survivability, Expected survivability
        fun `embody reduces survivability by 1`(initialSurvivability: Int, expectedSurvivability: Int) {
            val survivable = object : Survivable {
                override var survivability = initialSurvivability
            }
            val idea = DamageIdea(survivable)

            idea.embody()

            assertEquals(expectedSurvivability, survivable.survivability)
        }
}

