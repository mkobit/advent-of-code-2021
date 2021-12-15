package com.github.mkobit.aoc2021.day14

fun optimalPolymer(input: String): UInt {
  val template = input.splitToSequence(System.lineSeparator())
    .first()
  val insertionRules = input.splitToSequence(System.lineSeparator())
    .drop(2)
    .map { line -> line.split(Regex("""\s+->\s+""")) }
    .map { (pair, mapping) -> pair to mapping }
    .toMap()

  fun convertPolymer(polymer: String): String {
    return polymer
      .zipWithNext()
      .joinToString("") { (first, second) ->
        "$first${insertionRules["$first$second"]}"
      } + polymer.last()
  }
//  NN
  // NC
  // CB

  return (1..10).fold(template) { polymer, _ ->
    convertPolymer(polymer)
  }.groupingBy { it }
    .eachCount()
    .let { counts ->
      counts.maxOf { it.value } - counts.minOf { it.value }
    }.toUInt()
}