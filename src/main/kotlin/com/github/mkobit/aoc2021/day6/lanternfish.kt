package com.github.mkobit.aoc2021.day6

import com.github.mkobit.aoc2021.collections.update

private val NEW_LANTERNFISH = 8.toUInt()
private val RESET_LANTERNFISH = 6.toUInt()

fun lanternfish(input: String, days: UInt): ULong {
    val startingLanternFish =  input.split(",").map { it.toUInt() }
    val fishAtSpawns = List(NEW_LANTERNFISH.toInt() + 1) { daysLeft -> startingLanternFish.count { it == daysLeft.toUInt() }.toULong() }
    return (1.toUInt()..days)
        .fold(fishAtSpawns) { acc, _ ->
            val toSpawn = acc[0]
            val toReset = acc[0]
            acc.drop(1)
                .update(RESET_LANTERNFISH.toInt()) { it + toReset } +
                    toSpawn
        }.sum()
}
