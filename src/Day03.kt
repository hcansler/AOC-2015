fun main() {
    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    val solution = Day03()

    println(solution.part2(input))

    check(solution.part1(input) == 2572)
    check(solution.part2(input) == 2631)

}

class Day03 {
    fun part1(input: List<String>): Int {
        val houses = followDirections(input.first(), Location(0, 0))
        return houses.distinct().count()
    }

    fun part2(input: List<String>): Int {
        val roboDirections = input.first().filterIndexed{ index, _ -> index % 2 == 0 }
        val santaDirections = input.first().filterIndexed{ index, _ -> index % 2 == 1 }
        val roboHouses = followDirections(roboDirections, Location(0, 0))
        val santaHouses = followDirections(santaDirections, Location(0, 0))
        return (roboHouses + santaHouses).distinct().count()
    }

    data class Location(
        val x: Int = 0,
        val y: Int = 0
    )

    fun followDirections(directions: String, startingLocation: Location): MutableList<Location> {
        val houses = mutableListOf(startingLocation)
        var currentLocation = startingLocation
        for (move in directions) {
            val previousLocation = currentLocation
            currentLocation = updateLocation(move, previousLocation)
            houses += currentLocation
        }
        return houses
    }

    fun updateLocation(move: Char, previousLocation: Location): Location {
        return when (move) {
            '>' -> Location(previousLocation.x + 1,previousLocation.y)
            '<' -> Location(previousLocation.x - 1, previousLocation.y)
            '^' -> Location(previousLocation.x, previousLocation.y + 1)
            'v' -> Location(previousLocation.x, previousLocation.y - 1)
            else -> throw IllegalArgumentException("Invalid move $move")
        }
    }

}