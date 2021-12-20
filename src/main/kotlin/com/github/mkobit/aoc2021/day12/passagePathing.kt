package com.github.mkobit.aoc2021.day12

import com.github.mkobit.aoc2021.collections.reverse

@JvmInline
private value class Cave(val name: String) {
  fun isSmall() = name.any { it.isLowerCase() }
  fun isBig() = name.all { it.isUpperCase() }
}

private fun parseTextToCaveLinks(input: String): List<Pair<Cave, Cave>> =
  input
    .splitToSequence(System.lineSeparator())
    .map { line -> line.split("-") }
    .map { (left, right) -> Cave(left) to Cave(right) }
    .toList()

fun passagePathing(input: String): UInt {
  val connectedCaves = parseTextToCaveLinks(input)
    .flatMap { sequenceOf(it, it.reverse()) }
    .groupBy(
      { (start, _) -> start },
      { (_, end) -> end }
    ).mapValues { (_, value) -> value.toSet() }

  val start = Cave("start")
  val end = Cave("end")
//
//  // todo: memoize results
//  fun exploreCavePaths(
//    visitedSmallCaves: Set<Cave>,
//    path: List<Cave>,
//  ): UInt {
//    val at = path.last()
//    if (at == end) return 1.toUInt()
//    val connected = connectedCaves.getValue(at)
//    return connected
//      .filterNot { it in visitedSmallCaves && it.isSmall() }
//      .sumOf {
//        when {
//          it.isSmall() -> exploreCavePaths(visitedSmallCaves + it, path + it)
//          else -> exploreCavePaths(visitedSmallCaves, path + it)
//        }
//      }
//  }

  return exploreCavePaths(connectedCaves, listOf(start), end)
    .size
    .toUInt()
}

private fun exploreCavePaths(
  connections: Map<Cave, Set<Cave>>,
  path: List<Cave>,
  destination: Cave
): List<List<Cave>> {
  val at = path.last()
  if (at == destination) return listOf(path)
  val visitedSmall = path.asSequence()
    .filter(Cave::isSmall)
    .toSet()
  return connections.getOrDefault(at, emptySet())
    .filterNot { cave -> cave in visitedSmall }
    .flatMap { cave -> exploreCavePaths(connections, path + cave, destination) }
}