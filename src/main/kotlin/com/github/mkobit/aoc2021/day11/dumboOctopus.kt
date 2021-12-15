package com.github.mkobit.aoc2021.day11

import com.github.mkobit.aoc2021.coordinates.list.ListCoordinate
import com.github.mkobit.aoc2021.coordinates.list.adjacent
import com.github.mkobit.aoc2021.coordinates.list.boxCoordinates
import com.github.mkobit.aoc2021.coordinates.list.contains
import com.github.mkobit.aoc2021.coordinates.list.get
import com.github.mkobit.aoc2021.coordinates.list.set

fun octopusFlashes(input: String): UInt {
  val initialLevels = input.split(System.lineSeparator())
    .map { line -> line.map { numberChar -> numberChar.digitToInt() } }
  return (1..100).fold(0 to initialLevels) { (flashes, levels), _ ->
    // increment current levels, result to
    val flashed = mutableSetOf<ListCoordinate>()
    val nextLevels = levels.map { it.toMutableList() }
    val toAdd = levels.boxCoordinates().toMutableList()
    while (toAdd.isNotEmpty()) {
      val coordinate = toAdd.removeFirst()
      nextLevels[coordinate] = nextLevels[coordinate] + 1
      if (nextLevels[coordinate] == 10) {
        toAdd.addAll(
          coordinate.adjacent().filter { it in nextLevels } - flashed
        )
        flashed.add(coordinate)
      }
    }
    flashed.forEach { nextLevels[it] = 0 }
    // increment all values
    (flashes + flashed.size) to nextLevels.toList()
  }.first
    .toUInt()
}