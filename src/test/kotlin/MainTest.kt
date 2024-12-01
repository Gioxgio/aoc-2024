import org.example.Day01
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {

    private val day = Day01()

    @Test
    fun part1_success() {
        val dummyInput = getDummyInput()
        val result = day.part1(dummyInput)
        assertEquals(11, result)
    }

    @Test
    fun part2_success() {
        val dummyInput = getDummyInput()
        val result = day.part2(dummyInput)
        assertEquals(31, result)
    }

    private fun getDummyInput(): List<String> {
        return """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()
            .lines()
    }
}