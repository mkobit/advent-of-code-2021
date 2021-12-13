package com.github.mkobit.aoc2021.day9

import com.github.mkobit.aoc2021.coordinates.list.adjacent
import com.github.mkobit.aoc2021.coordinates.list.boxCoordinates
import com.github.mkobit.aoc2021.coordinates.list.get
import com.github.mkobit.aoc2021.coordinates.list.contains

fun lowLevelRiskSum(input: String): UInt { ;
  val heightmap = input.split(System.lineSeparator())
    .map { line -> line.map(Char::digitToInt) }
  return heightmap.boxCoordinates()
    .filter { coordinate ->
      val height = heightmap[coordinate]
      // low points
      coordinate.adjacent()
        .filter { it in heightmap }
        .all { adjacent -> height < heightmap[adjacent] }
    }.map { coordinate ->
      heightmap[coordinate] + 1
    }.sum().toUInt()
}