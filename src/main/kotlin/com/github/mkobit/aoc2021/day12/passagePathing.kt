package com.github.mkobit.aoc2021.day12

@JvmInline
private value class Cave(val name: String) {
  fun isSmall() = name.any { it.isLowerCase() }
  fun isBig() = name.all { it.isUpperCase() }
}

fun passagePathing(input: String): UInt {
  val connectedCaves = input
    .splitToSequence(System.lineSeparator())
    .map { line -> line.split("-") }
    .map { (left, right) -> Cave(left) to Cave(right) }
    .flatMap { sequenceOf(it, it.second to it.first) }
    .groupBy(
      { (start, _) -> start },
      { (_, end) -> end }
    ).mapValues { (_, value) -> value.toSet() }

  val start = Cave("start")
  val end = Cave("end")

  // todo: memoize results
  fun exploreCavePaths(
    visitedSmallCaves: Set<Cave>,
    path: List<Cave>,
  ): UInt {
    val at = path.last()
    if (at == end) return 1.toUInt()
    val connected = connectedCaves.getValue(at)
    return connected
      .filterNot { it in visitedSmallCaves && it.isSmall() }
      .sumOf {
        when {
          it.isSmall() -> exploreCavePaths(visitedSmallCaves + it, path + it)
          else -> exploreCavePaths(visitedSmallCaves, path + it)
        }
      }
  }

  return exploreCavePaths(setOf(start), listOf(start))
}