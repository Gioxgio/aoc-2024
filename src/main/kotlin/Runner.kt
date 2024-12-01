package org.example

import java.io.File

fun main() {

    fun readInput(path: String): List<String> =
        object {}.javaClass.getResource(path)?.toURI()?.let { File(it).readLines() }.orEmpty()

    val day = Day01()
    val input = readInput("/day01.txt")

    val output01 = day.part1(input)
    val output02 = day.part2(input)

    println("Part 01: $output01")
    println("Part 02: $output02")
}
