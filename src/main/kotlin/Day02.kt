package org.example

import kotlin.math.abs

class Day02 : Day {

    private val separator = " "

    override fun part1(input: List<String>): Int {

        var count = 0

        for (line in input) {

            val report = line.split(separator).map { l -> l.toInt() }

            val correct = isReportCorrect(report)

            count += if (correct) 1 else 0
        }

        return count
    }

    override fun part2(input: List<String>): Int {

        var count = 0

        for (line in input) {

            val report = line.split(separator).map { l -> l.toInt() }

            val trend = report[0] > report[1]
            for (i in 1..<report.size) {
                var pLevel = report[i - 1]
                val level = report[i]
                val diff = abs(level - pLevel)
                if (pLevel > level != trend || 0 >= diff || diff > 3) {
                    if (!isReportCorrect(filteredList(report, i - 1)) &&
                        !isReportCorrect(filteredList(report, i)) &&
                        !isReportCorrect(filteredList(report, i + 1))
                    ) {
                        count--
                    }
                    break
                }
            }
            count++
        }
        return count
    }

    private fun isReportCorrect(levels: List<Int>): Boolean {
        val trend = levels[0] > levels[1]
        for (i in 1..<levels.size) {
            var pLevel = levels[i - 1]
            val level = levels[i]
            val diff = abs(level - pLevel)
            if (pLevel > level != trend || 0 >= diff || diff > 3) {
                return false
            }
        }
        return true
    }

    private fun filteredList(report: List<Int>, index: Int): List<Int> {
        return report.withIndex().filter { (i, _) -> i != index - 1 }.map { (_, l) -> l }
    }
}
