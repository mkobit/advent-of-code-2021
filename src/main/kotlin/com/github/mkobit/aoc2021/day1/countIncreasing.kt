package com.github.mkobit.aoc2021.day1

fun countIncreasing(text: String): Int =
    text.splitToSequence(System.lineSeparator())
        .map { it.toInt() }
        .zipWithNext()
        .filter { (first, second) -> second > first }
        .count()
