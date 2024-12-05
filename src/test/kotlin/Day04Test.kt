import org.example.Day04
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {

    private val day = Day04()

    @Test
    fun part1_success() {
        val dummyInput = getDummyInput()
        val result = day.part1(dummyInput)
        assertEquals(18, result)
    }

    @Test
    fun part2_success() {
        val dummyInput = getDummyInput()
        val result = day.part2(dummyInput)
        assertEquals(9, result)
    }

    private fun getDummyInput(): List<String> {
        return """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent()
            .lines()
    }
}