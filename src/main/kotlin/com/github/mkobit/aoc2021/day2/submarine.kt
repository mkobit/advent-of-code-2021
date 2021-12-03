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
                "backward" -> (x - distance) to y
                "up" -> x to (y - distance) // depth is considered positive distance for the sub
                "down" -> x to (y + distance)
                else -> throw IllegalArgumentException("Illegaly direction $direction")
            }
        }
