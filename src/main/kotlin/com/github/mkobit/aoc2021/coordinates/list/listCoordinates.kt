package com.github.mkobit.aoc2021.coordinates.list

/**
 * A coordinate for a row/column in a list of lists.
 * The (0, 0) is the first column and first row.
 */
typealias ListCoordinate = Pair<Int, Int>

val ListCoordinate.row: Int
  get() = first
val ListCoordinate.column: Int
  get() = second

operator fun <T> List<List<T>>.contains(coordinate: ListCoordinate): Boolean =
  coordinate.row in indices && coordinate.column in first().indices

operator fun <T> List<List<T>>.get(coordinate: ListCoordinate): T =
  get(coordinate.row)[coordinate.column]

operator fun <T> List<MutableList<T>>.set(coordinate: ListCoordinate, value: T) {
  get(coordinate.row)[coordinate.column] = value
}

fun <T> List<List<T>>.getOrNull(coordinate: ListCoordinate): T? =
  getOrNull(coordinate.row)?.getOrNull(coordinate.column)

fun ListCoordinate.adjacent(): Sequence<ListCoordinate> =
  ((row - 1)..(row + 1))
    .asSequence()
    .flatMap { r ->
      ((column - 1)..(column + 1))
        .asSequence()
        .map { c -> r to c }
    }.filterNot { it == this }

fun ListCoordinate.above(): ListCoordinate = (row - 1) to column
fun ListCoordinate.right(): ListCoordinate = row to (column + 1)
fun ListCoordinate.below(): ListCoordinate = (row + 1) to column
fun ListCoordinate.left(): ListCoordinate = row to (column - 1)

/**
 * Generates a sequence of coordinates for a [List] of [List]s.
 * The assumption is that all of the [List] are the same length.
 */
fun <T> List<List<T>>.boxCoordinates(): Sequence<ListCoordinate> =
  indices
    .asSequence()
    .flatMap { row ->
      first().indices.asSequence().map { column -> row to column }
    }
