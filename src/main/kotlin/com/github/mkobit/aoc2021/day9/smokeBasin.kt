package com.github.mkobit.aoc2021.day9

private typealias Coordinate = Pair<Int, Int>

private val Coordinate.x: Int
  get() = first
private val Coordinate.y: Int
  get() = second

private fun Coordinate.adjacentCoordinates(): Sequence<Coordinate> {
  val start = (x - 1) to (y - 1)
  val end = (x + 1) to (y + 1)

  return coordinatesInBox(start, end)
    .filterNot { it == this }
}

private fun Coordinate.isInRange(start: Coordinate, endInclusive: Coordinate): Boolean =
  (x >= start.x && y >= start.y) && (x <= endInclusive.x && y <= endInclusive.y)

private fun coordinatesInBox(start: Coordinate, endInclusive: Coordinate): Sequence<Coordinate> {
  return (start.x..endInclusive.x)
    .asSequence()
    .flatMap { x ->
      (start.y..endInclusive.y)
        .asSequence()
        .map { y -> x to y }
    }
}

fun lowLevelRiskSum(input: String): UInt {
  val heightmap = input.split(System.lineSeparator())
    .map { line -> line.map(Char::digitToInt) }
  val start = 0 to 0
  val end = (heightmap.size - 1) to (heightmap.first().size - 1)
  operator fun List<List<Int>>.get(coordinate: Coordinate): Int =
    get(coordinate.x)[coordinate.y]
  return coordinatesInBox(start, end)
    .filter { coordinate ->
      val height = heightmap[coordinate]
      // low points
      coordinate.adjacentCoordinates()
        .filter { it.isInRange(start, end) }
        .all { adjacent -> height < heightmap[adjacent] }
    }.map { coordinate ->
      heightmap[coordinate] + 1
    }.sum().toUInt()
}