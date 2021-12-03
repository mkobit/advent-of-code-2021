package com.github.mkobit.aoc2021.day1

fun countIncreasing(text: String): Int =
    text.splitToSequence(System.lineSeparator())
        .map { it.toInt() }
        .zipWithNext()
        .filter { (first, second) -> second > first }
        .count()

fun countIncreasingWindows(text: String): Int =
    text.splitToSequence(System.lineSeparator())
        .map { it.toInt() }
        .windowed(3)
        .map { window -> window.sum() }
        .zipWithNext()
        .filter { (first, second) -> second > first }
        .count()
