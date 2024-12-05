import org.example.Day05
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Test {

    private val day = Day05()

    @Test
    fun part1_success() {
        val dummyInput = getDummyInput()
        val result = day.part1(dummyInput)
        assertEquals(143, result)
    }

    @Test
    fun part2_success() {
        val dummyInput = getDummyInput()
        val result = day.part2(dummyInput)
        assertEquals(9, result)
    }

    private fun getDummyInput(): List<String> {
        return """
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13

            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47
       """.trimIndent()
            .lines()
    }
}