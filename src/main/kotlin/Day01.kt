package org.example

import java.util.*
import kotlin.math.abs

class Day01 : Day {

    private val separator = "   "

    override fun part1(input: List<String>): Int {

        val left = PriorityQueue<Int>()
        val right = PriorityQueue<Int>()

        input.forEach { line: String ->
            run {
                val numbers = line.split(separator).map { n -> n.toInt() }
                left.add(numbers[0])
                right.add(numbers[1])
            }
        }

        var lefty: Int?
        var righty: Int?
        var sum = 0

        for (i in 0..<left.size) {
            lefty = left.poll()
            righty = right.poll()
            sum += abs(lefty - righty)
        }

        return sum
    }

    override fun part2(input: List<String>): Int {

        val left = mutableListOf<String>()
        val right = mutableMapOf<String, Int>()

        input.forEach { line: String ->
            run {
                val numbers = line.split(separator)
                left.add(numbers[0])
                right[numbers[1]] = right.getOrDefault(numbers[1], 0) + 1
            }
        }

        var sum = 0
        left.forEach { n ->
            sum += n.toInt() * right.getOrDefault(n, 0)
        }

        return sum
    }
}
