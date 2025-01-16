fun main() {
//    val testInput = readInput("input_test")
    val input = readInput("Day01")

    val solution = Day01()

    println(input.first().toList().size)
    println(solution.part2(input))

//    check(solution.part1(input) == 232)
//
//    check(solution.part2(input) == 1783)

}

class Day01 {
    fun part1(input: List<String>): Int {
        val directions = input.first().toList()
        return directions.count { it == '(' } - directions.count { it == ')' }
    }

    fun part2(input: List<String>): Int {
        val directions = input.first().toList()
        var currentFloor = 0
        var position = 0
        for (i in directions.indices) {
            if (directions[i] == '(') currentFloor ++
            else currentFloor --
            if (currentFloor == -1) {
                position = i + 1
                break
            }
        }
        return position
    }
}