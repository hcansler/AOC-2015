fun main() {
    val input = readInput("Day02")

    val solution = Day02()

    check(solution.part1(input) == 1588178)
    check(solution.part2(input) == 3783758)

}

class Day02 {
    fun part1(input: List<String>): Int {
        val allDims = parseInput(input)
        return allDims.sumOf { calculateNeededPaper(it) }
    }

    fun part2(input: List<String>): Int {
        val allDims = parseInput(input)
        return allDims.sumOf { calculateNeededRibbon(it) }
    }

    data class Dims(val l: Int, val w: Int, val h: Int, val shortest: Pair<Int, Int>)

    private fun parseInput(input: List<String>): List<Dims> {
        val dims = mutableListOf<Dims>()
        for (line in input) {
            val ints = line.split('x').map { it.toInt() }
            dims += Dims(
                ints[0],
                ints[1],
                ints[2],
                ints.sorted()[0] to ints.sorted()[1],
            )
        }
        return dims
    }

    private fun calculateNeededPaper(dims: Dims): Int {
        val area = (2 * dims.l * dims.w) + (2 * dims.w * dims.h) + (2 * dims.l * dims.h)
        val extra = dims.shortest.first * dims.shortest.second
        return area + extra
    }

    private fun calculateNeededRibbon(dims: Dims): Int {
        return (2 * dims.shortest.first) + (2 * dims.shortest.second) + (dims.l * dims.w * dims.h)
    }
}