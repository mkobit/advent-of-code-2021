package com.github.mkobit.aoc2021.day6

private val NEW_LANTERNFISH = 8.toUInt()
private val RESET_LANTERNFISH = 6.toUInt()

fun lanternfish(input: String, days: UInt): UInt {
    val initialTimes = input.split(",").map { it.toUInt() }
    // can just do this recursively with math without this reduction
    // this, however is an easy way to think about it even though it blows space complexity up
    return (1.toUInt()..days).fold(initialTimes) { times, _ ->
        val toSpawn = times.count { it == UInt.MIN_VALUE }
        times.asSequence()
            .map {
                when(it) {
                    UInt.MIN_VALUE -> RESET_LANTERNFISH
                    else -> it - 1.toUInt()
                }
            }
            .toList() + List(toSpawn) { NEW_LANTERNFISH }
    }.count().toUInt()
}
