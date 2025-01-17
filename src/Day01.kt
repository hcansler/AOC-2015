fun main() {
    val input = readInput("Day01")

    val solution = Day01()

    check(solution.part1(input) == 232)
    check(solution.part2(input) == 1783)

}

class Day01 {
    fun part1(input: List<String>): Int {
        val directions = input.first().toList()
        return directions.count { it == '(' } - directions.count { it == ')' }
    }

    fun part2(input: List<String>): Int? {
        val directions = input.first().toList()
        var currentFloor = 0
        for (i in directions.indices) {
            if (directions[i] == '(') currentFloor ++
            else currentFloor --
            if (currentFloor == -1) {
                return i + 1
            }
        }
        return null
    }
}