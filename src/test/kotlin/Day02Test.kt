import org.example.Day02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Test {

    private val day = Day02()

    @Test
    fun part1_success() {
        val dummyInput = getDummyInput()
        val result = day.part1(dummyInput)
        assertEquals(2, result)
    }

    @Test
    fun part2_success() {
        val dummyInput = getDummyInput()
        val result = day.part2(dummyInput)
        assertEquals(7, result)
    }

    private fun getDummyInput(): List<String> {
        return """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
            12 10 11 14 17
            11 8 12 7 6
            11 8 12 14 17
        """.trimIndent()
            .lines()
    }
}