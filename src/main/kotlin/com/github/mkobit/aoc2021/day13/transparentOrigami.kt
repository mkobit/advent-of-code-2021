package com.github.mkobit.aoc2021.day13

import com.github.mkobit.aoc2021.coordinates.list.ListCoordinate
import java.lang.IllegalArgumentException

private sealed class Fold(val offset: Int) {
  class X(offset: Int) : Fold(offset) {
    override fun toString(): String = "fold along x=$offset"
  }
  class Y(offset: Int) : Fold(offset) {
    override fun toString(): String = "fold along y=$offset"
  }
}

private fun parseInput(text: String): Pair<Set<ListCoordinate>, List<Fold>> {
  val (dotsText, foldsText) = text.split(System.lineSeparator().repeat(2))
  val dots = dotsText.split(System.lineSeparator())
    .map { line ->
      val (x, y) = line.split(",")
      x.toInt() to y.toInt()
    }.toSet()

  val folds = foldsText.split(Regex(System.lineSeparator()))
    .map { it.split("fold along ") }
    .map {
      val (_, fold) = it
      val (axis, value) = fold.split("=")
      when(axis) {
        "x" -> Fold.X(value.toInt())
        "y" -> Fold.Y(value.toInt())
        else -> throw IllegalArgumentException("illegal fold $value")
      }
    }

  return dots to folds
}

fun foldPaper(input: String): UInt {
  val (dots, folds) = parseInput(input)

  return folds
    .first()
    .applyTo(dots)
    .size
    .toUInt()
}

private fun Fold.applyTo(coordinates: Set<ListCoordinate>): Set<ListCoordinate> {
  return when (this) {
    is Fold.X -> {
      val (left, right) = coordinates.partition { (x, _) -> x <= offset }
      (left + right.map { (x, y) ->
        // fold right over to the left
        (offset - (x - offset)) to y
      }).toSet()
    }
    is Fold.Y -> {
      val (above, below) = coordinates.partition { (_, y) -> y <= offset }
      (above + below.map { (x, y) ->
        // fold below over to the above
        x to (offset - (y - offset))
      }).toSet()
    }
  }
}