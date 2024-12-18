package org.example

class Day04 : Day {

    override fun part1(input: List<String>): Int {

        var sum = 0

        for (y in input.indices) {
            val line = input[y]
            for (x in line.indices) {
                val char = line[x]
                if (char != 'X') continue
                sum += search(input, x, y)
            }
        }

        return sum
    }

    override fun part2(input: List<String>): Int {

        var sum = 0

        for (y in input.indices) {
            val line = input[y]
            for (x in line.indices) {
                val char = line[x]
                if (!"MS".contains(char)) continue
                sum += if (search2(input, x, y, char)) 1 else 0
            }
        }

        return sum
    }

    private fun search(input: List<String>, x: Int, y: Int): Int {

        var sum = 0
        val searchLeft = x > 2
        val searchTop = y > 2
        val searchRight = x < input[y].length - 3
        val searchBottom = y < input.size - 3

        if (searchTop) {
            if (search(input, x, y, 0, 0, -1)) sum++
            if (searchLeft && search(input, x, y, 0, -1, -1)) sum++
            if (searchRight && search(input, x, y, 0, 1, -1)) sum++
        }
        if (searchBottom) {
            if (search(input, x, y, 0, 0, 1)) sum++
            if (searchLeft && search(input, x, y, 0, -1, 1)) sum++
            if (searchRight && search(input, x, y, 0, 1, 1)) sum++
        }
        if (searchLeft && search(input, x, y, 0, -1, 0)) sum++
        if (searchRight && search(input, x, y, 0, 1, 0)) sum++

        return sum
    }

    private fun search(input: List<String>, x: Int, y: Int, i: Int, vX: Int, vY: Int): Boolean {
        val stringToSearch = "MAS"
        val curX = x + vX
        val curY = y + vY
        val curChar = input[curY][curX]

        return curChar == stringToSearch[i] && (i == 2 || search(input, curX, curY, i + 1, vX, vY))
    }

    private fun search2(input: List<String>, x: Int, y: Int, char: Char): Boolean {

        if (x > input[y].length - 3) return false
        if (y > input.size - 3) return false

        val otherChar = if ('M' == char) 'S' else 'M'
        return input[y + 1][x + 1] == 'A' &&
                ((input[y][x + 2] == otherChar && input[y + 2][x] == char && input[y + 2][x + 2] == otherChar) ||
                        (input[y][x + 2] == char && input[y + 2][x] == otherChar && input[y + 2][x + 2] == otherChar))
    }
}
