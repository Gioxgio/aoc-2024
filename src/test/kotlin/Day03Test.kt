import org.example.Day03
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {

    private val day = Day03()

    @Test
    fun part1_success() {
        val dummyInput = getDummyInput()
        val result = day.part1(dummyInput)
        assertEquals(161, result)
    }

    @Test
    fun part2_success() {
        val dummyInput = getDummyInput2()
        val result = day.part2(dummyInput)
        assertEquals(48, result)
    }

    private fun getDummyInput(): List<String> {
        return """
            xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5)) 
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