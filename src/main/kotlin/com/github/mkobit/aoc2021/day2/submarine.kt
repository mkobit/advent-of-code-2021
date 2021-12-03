package com.github.mkobit.aoc2021.day2

fun submarineCoordinates(input: String): Pair<Int, Int> =
    input.splitToSequence(System.lineSeparator())
        .map { line -> line.split(" ") }
        .fold(0 to 0) { coordinate, split ->
            val (x, y) = coordinate
            val (direction, distanceText) = split
            val distance = distanceText.toInt()
            when (direction) {
                "forward" -> (x + distance) to y
                "up" -> x to (y - distance) // depth is considered positive distance for the sub
                "down" -> x to (y + distance)
                else -> throw IllegalArgumentException("Illegal direction $direction")
            }
        }

fun submarineCoordinatesAim(input: String): Pair<Int, Int> =
    input.splitToSequence(System.lineSeparator())
        .map { line -> line.split(" ") }
        .fold(Triple(0, 0, 0)) { coordinateWithAim, split ->
            val (x, y, aim) = coordinateWithAim
            val (direction, distanceText) = split
            val units = distanceText.toInt()
            when (direction) { // depth is considered positive distance for the sub
                "forward" -> Triple(x + units, y + aim * units, aim)
                "up" -> Triple(x, y, aim - units)
                "down" -> Triple(x, y, aim + units)
                else -> throw IllegalArgumentException("Illegal direction $direction")
            }
        }.let { (x, y, _) -> x to y }
