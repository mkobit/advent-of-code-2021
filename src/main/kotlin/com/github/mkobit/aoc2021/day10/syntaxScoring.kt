package com.github.mkobit.aoc2021.day10

fun corruptedSyntaxScores(input: String): UInt {
  val lines = input.split(System.lineSeparator())
  val openToClose = mapOf(
    '(' to ')',
    '[' to ']',
    '{' to '}',
    '<' to '>',
  )
  val closeToOpen = openToClose
    .entries
    .associateBy({ it.value }, { it.key })
  val scoreChars = mapOf(
    ')' to 3,
    ']' to 57,
    '}' to 1197,
    '>' to 25137,
  )
  return lines.map { line ->
    line.fold(emptyList<Char>()) { acc, char ->
      when {
        acc.isNotEmpty() && acc.last() == '!' -> acc
        char in openToClose -> acc + openToClose.getValue(char)
        char in closeToOpen && acc.last() == char -> acc.dropLast(1)
        else -> listOf(char, '!')
      }
    }.let {
      when {
        it.last() == '!' -> it.take(1)
        else -> emptyList()
      }
    }
  }.filter { it.isNotEmpty() }
    .map { it.single() }
    .sumOf { scoreChars.getValue(it) }
    .toUInt()
}