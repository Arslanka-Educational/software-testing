package test3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource
import task3.*

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MarvinTest {
    private lateinit var marvin: Marvin

    @BeforeEach
    fun regenerate() {
        marvin = Marvin(
            _logicalSchemes = listOf(
                LogicalScheme(SchemaState.entries.random()),
                LogicalScheme((SchemaState.entries.random())),
                LogicalScheme((SchemaState.entries.random())),
                LogicalScheme(SchemaState.ACTIVE),
                LogicalScheme(SchemaState.INACTIVE),
            ),
            _emotionalState = EmotionalState.entries.random(),
            _direction = Direction.entries.random(),
        )
    }

    @ParameterizedTest
    @EnumSource(EmotionalState::class)
    fun `observer should set state`(emotionalState: EmotionalState) {
        marvin.observeWithEmotionalState(emotionalState = emotionalState)
        assertThat(marvin.emotionalState).isEqualTo(emotionalState)
    }


    @ParameterizedTest
    @CsvSource(
        "10, 9",
        "100000000, 99999999",
        "0, -1",
    )
    fun `manipulate with door damaging should decrease survivability`(
        inputSurvivability: Int,
        expectedSurvivability: Int
    ) {
        val door = Door(
            cells = listOf(),
            survivability = inputSurvivability,
        )

        marvin.manipulateIdea(
            idea = DamageIdea(
                survivable = door,
            )
        )

        assertThat(door.survivability).isEqualTo(expectedSurvivability)
    }

    @Test
    fun `compare EQUAL MolecularComponents`() {
        val cells = listOf(HumanCell(), DoorCell(), HumanCell())
        val molecularComponent1 = HumanBrain(
            cells = cells,
        )

        val molecularComponent2 = HumanBrain(
            cells = cells.shuffled(),
        )

        assertThat(
            marvin.compareMolecularComponents(
                lMolecularComponent = molecularComponent1,
                rMolecularComponent = molecularComponent2,
            )
        ).isTrue()
    }

    @Test
    fun `compare NOT EQUAL MolecularComponents`() {
        val cells = listOf(HumanCell(), DoorCell(), HumanCell())
        val molecularComponent1 = HumanBrain(
            cells = cells,
        )

        val molecularComponent2 = HumanBrain(
            cells = cells.shuffled() + HumanCell(),
        )

        assertThat(
            marvin.compareMolecularComponents(
                lMolecularComponent = molecularComponent1,
                rMolecularComponent = molecularComponent2,
            )
        ).isFalse()
    }

    @ParameterizedTest
    @EnumSource(Direction::class)
    fun `changeDirectionTo should set direction`(direction: Direction) {
        marvin.changeDirectionTo(direction = direction)
        assertThat(marvin.direction).isEqualTo(direction)
    }

    @Test
    fun `disconnectSchemes should set all schemes to disconnect`() {
        assertThat(marvin.logicalSchemes.any { it.state == SchemaState.ACTIVE }).isTrue()
        marvin.disconnectSchemes()
        assertThat(marvin.logicalSchemes.any { it.state == SchemaState.ACTIVE }).isFalse()
    }
}