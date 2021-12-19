package com.github.mkobit.aoc2021.day11

import com.github.mkobit.aoc2021.coordinates.list.ListCoordinate
import com.github.mkobit.aoc2021.coordinates.list.adjacent
import com.github.mkobit.aoc2021.coordinates.list.boxCoordinates
import com.github.mkobit.aoc2021.coordinates.list.contains
import com.github.mkobit.aoc2021.coordinates.list.get
import com.github.mkobit.aoc2021.coordinates.list.set

fun octopusFlashes(input: String): UInt {
  return (1..100).fold(parseLevelsText(input) to UInt.MIN_VALUE) { (levels, flashes), _ ->
    val (nextLevels, updateCount) = stepUpdate(levels)
    nextLevels to (flashes + updateCount)
  }.second
}

private fun parseLevelsText(text: String): List<List<Int>> =
  text.split(System.lineSeparator())
    .map { line ->
      line.map { numberChar -> numberChar.digitToInt() }
    }

fun octopusSynchronizedFlash(input: String): UInt {
  return generateSequence(0.toUInt() to parseLevelsText(input)) { (step, levels) ->
    step + 1.toUInt() to stepUpdate(levels).first
  }.first { (_, levels) ->
    levels.all { row -> row.all { level -> level == 0 } }
  }.first
}

private fun stepUpdate(levels: List<List<Int>>): Pair<List<List<Int>>, UInt> {
  // add 1 to each coordinate
  // all 10s need to flash
  // repeat with new 10s
  // could probably make this more functional
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
  return nextLevels.toList() to flashed.size.toUInt()
//  fun flash(levels: List<List<Int>>, updatedPositions: Set<ListCoordinate>):
}
