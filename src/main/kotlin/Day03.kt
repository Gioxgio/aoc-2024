package org.example

class Day03 : Day {

    override fun part1(input: List<String>): Int {

        var sum = 0
        val inp = input.joinToString()

        var multiplication = inp.split("mul(")
        for (m in multiplication) {
            if (!m.contains(",") || !m.contains(")")) continue

            var factors = m.split(",")
            var iFactor = factors.firstOrNull()
            if (iFactor == null) continue

            try {
                var iiFactor = factors[1].split(")").firstOrNull()
                if (iiFactor == null) continue


                sum += iFactor.toInt() * iiFactor.toInt()
            } catch (_: Exception) {
            }
        }

        return sum
    }

    override fun part2(input: List<String>): Int {

        var sum = 0
        val inp2 = "do()" + input.joinToString()

        var chunks = inp2.split("don't()")
        for (chunk in chunks) {
            val dos = chunk.indexOf("do()")
            if (dos < 0) continue

            val inp = chunk.substring(dos)
            var multiplication = inp.split("mul(")
            for (m in multiplication) {
                if (!m.contains(",") || !m.contains(")")) continue

                var factors = m.split(",")
                var iFactor = factors.firstOrNull()
                if (iFactor == null) continue

                try {
                    var iiFactor = factors[1].split(")").firstOrNull()
                    if (iiFactor == null) continue

                    sum += iFactor.toInt() * iiFactor.toInt()
                } catch (_: Exception) {
                }
            }
        }

        return sum
    }
}
