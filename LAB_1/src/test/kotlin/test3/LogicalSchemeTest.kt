import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import task3.HydrogenLevel
import task3.HydrogenMeasurable
import task3.LogicalScheme
import task3.SchemaState

@DisplayName("LogicalScheme tests")
internal class LogicalSchemeTest {
        @ParameterizedTest(name = "When disconnect is called, state should be INACTIVE")
        @EnumSource(SchemaState::class)
        fun `test disconnect method`(state: SchemaState) {
            val logicalScheme = LogicalScheme(state)
            logicalScheme.disconnect()
            assertEquals(SchemaState.INACTIVE, logicalScheme.state)
        }
}
