package org.example

class Day03 : Day {

    override fun part1(input: List<String>): Int {

        var sum = 0
        val inp = input.joinToString()

        val multiplication = inp.split("mul(")
        for (m in multiplication) {
            if (!m.contains(",") || !m.contains(")")) continue

            val factors = m.split(",")
            val iFactor = factors.firstOrNull() ?: continue

            try {
                val iiFactor = factors[1].split(")").firstOrNull() ?: continue


                sum += iFactor.toInt() * iiFactor.toInt()
            } catch (_: Exception) {
            }
        }

        return sum
    }

    override fun part2(input: List<String>): Int {

        var sum = 0
        val inp2 = "do()" + input.joinToString()

        val chunks = inp2.split("don't()")
        for (chunk in chunks) {
            val dos = chunk.indexOf("do()")
            if (dos < 0) continue

            val inp = chunk.substring(dos)
            val multiplication = inp.split("mul(")
            for (m in multiplication) {
                if (!m.contains(",") || !m.contains(")")) continue

                val factors = m.split(",")
                val iFactor = factors.firstOrNull() ?: continue

                try {
                    val iiFactor = factors[1].split(")").firstOrNull() ?: continue

                    sum += iFactor.toInt() * iiFactor.toInt()
                } catch (_: Exception) {
                }
            }
        }

        return sum
    }
}
