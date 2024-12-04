import org.example.Day03
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
        val dummyInput = getDummyInput2()
        val result = day.part2(dummyInput)
        assertEquals(48, result)
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

    private fun getDummyInput2(): List<String> {
        return """
            xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
        """.trimIndent()
            .lines()
    }
}