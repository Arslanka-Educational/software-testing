package test3

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import task3.CubicParsecSpace
import task3.HydrogenLevel
import kotlin.test.assertEquals
import org.junit.jupiter.params.provider.EnumSource


internal class CubicParsecSpaceTest {
        @ParameterizedTest
        @EnumSource(HydrogenLevel::class)
        fun `measureHydrogenLevel returns correct hydrogen level`(hydrogenLevel: HydrogenLevel) {
            val space = CubicParsecSpace(hydrogenLevel)
            assertEquals(hydrogenLevel, space.measureHydrogenLevel())
        }
}
