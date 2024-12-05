package org.example

import java.util.*

class Day05 : Day {

    override fun part1(input: List<String>): Int {

        var sum = 0

        val (instructions2, updates2) = processInput(input)

        val instructions = processInstructions(instructions2)
        val updates = processUpdates(updates2)

        for (pages in updates) {
            sum += checkUpdate(pages, instructions)
        }

        return sum
    }

    override fun part2(input: List<String>): Int {

        var sum = 0
        return sum
    }

    private fun processInput(input: List<String>): Pair<List<String>, List<String>> {
        val separator = input.withIndex().filter { (_, line) -> line.isEmpty() }.map { (i, _) -> i }.first()
        return Pair(input.subList(0, separator), input.subList(separator + 1, input.size))
    }

    private fun processInstructions(instructions: List<String>): Pair<MutableMap<Int, TreeSet<Int>>, MutableMap<Int, TreeSet<Int>>> {
        val mapAfter = mutableMapOf<Int, TreeSet<Int>>()
        val mapBefore = mutableMapOf<Int, TreeSet<Int>>()
        instructions.forEach { instruction ->
            val (left, right) = instruction.split("|").map(String::toInt)
            mapAfter[left]?.add(right) ?: run { mapAfter[left] = newTreeSet(right) }
            mapBefore[right]?.add(left) ?: run { mapBefore[right] = newTreeSet(left) }
        }
        return Pair(mapBefore, mapAfter)
    }

    private fun processUpdates(updates: List<String>): List<List<Int>> {
        return updates.map { line -> line.split(",").map(String::toInt) }
    }

    private fun checkUpdate(
        pages: List<Int>,
        instructions: Pair<MutableMap<Int, TreeSet<Int>>, MutableMap<Int, TreeSet<Int>>>
    ): Int {

        val (before, after) = instructions

        for (i in 1..pages.lastIndex) {
            val curPage = pages[i]
            val previousPages = pages.subList(0, i)
            val nextPages = pages.subList(i + 1, pages.size)

            if (!checkNone(previousPages, after[curPage] ?: TreeSet<Int>())
                || !checkNone(nextPages, before[curPage] ?: TreeSet<Int>())
            ) return 0
        }
        return pages[pages.lastIndex / 2]
    }

    private fun checkNone(pages: List<Int>, tree: TreeSet<Int>): Boolean {
        return pages.none { page -> tree.contains(page) }
    }

    private fun <T> newTreeSet(item: T): TreeSet<T> {
        val tree = TreeSet<T>()
        tree.add(item)
        return tree
    }
}
