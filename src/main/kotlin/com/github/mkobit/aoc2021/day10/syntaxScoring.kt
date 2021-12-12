package com.github.mkobit.aoc2021.day10

private val openToClose = mapOf(
  '(' to ')',
  '[' to ']',
  '{' to '}',
  '<' to '>',
)
private val closeToOpen = openToClose
  .entries
  .associateBy({ it.value }, { it.key })

// if first non-null, syntax is invalid
// if first is null, second contains all required closing syntax markers in LIFO order
private fun parseSyntax(syntax :String): Pair<Char?, List<Char>> {
  val nullChar: Char? = null
  return syntax.fold(nullChar  to emptyList()) { (invalid, leftToClose, ), char ->
    when {
      invalid != null -> invalid to emptyList()
      char in openToClose -> null to (leftToClose + openToClose.getValue(char))
      char in closeToOpen && leftToClose.last() == char -> null to leftToClose.dropLast(1)
      else -> char to emptyList()
    }
  }
}

fun corruptedSyntaxScores(input: String): UInt {
  val lines = input.split(System.lineSeparator())

  val scoreChars = mapOf(
    ')' to 3,
    ']' to 57,
    '}' to 1197,
    '>' to 25137,
  )
  return lines.mapNotNull { line ->
    parseSyntax(line).first
  }.sumOf { scoreChars.getValue(it) }
    .toUInt()
}

fun incompleteSyntaxScores(input: String): ULong {
  val lines = input.split(System.lineSeparator())

  val scoreChars = mapOf(
    ')' to 1.toULong(),
    ']' to 2.toULong(),
    '}' to 3.toULong(),
    '>' to 4.toULong(),
  )

  fun <E> List<E>.middle(): E =
    when(size) {
      0 -> throw IndexOutOfBoundsException("can't get middle element of empty list")
      1 -> first()
      else -> get(size / 2) // not entirely accurate for even lists
    }


  return lines.map { line ->
    parseSyntax(line).second
  }.filter { it.isNotEmpty() }
    .map {
      it.foldRight(0.toULong()) { char, acc -> 5.toULong() * acc + scoreChars.getValue(char) }
    }.sorted()
    .middle()
}