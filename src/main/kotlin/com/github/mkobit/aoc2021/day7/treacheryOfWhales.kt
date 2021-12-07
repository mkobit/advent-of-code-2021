package com.github.mkobit.aoc2021.day7

fun crabFuelCost(input: String): UInt {
    val positions = input.split(",").map(String::toUInt)
    val minPosition = positions.minOrNull() ?: throw IllegalStateException("positions must have a minimum")
    val maxPosition = positions.maxOrNull() ?: throw IllegalStateException("positions must have a maximum")

    return (minPosition..maxPosition).map { position ->
        positions.map { initial ->
            if (initial >= position) initial - position else position - initial
        }
    }.minOfOrNull { changes -> changes.sum() } ?: throw IllegalStateException("must be able to calculate fuel cost")
}

fun crabFuelCostIncreasedCost(input: String): UInt {
    val positions = input.split(",").map(String::toUInt)
    val minPosition = positions.minOrNull() ?: throw IllegalStateException("positions must have a minimum")
    val maxPosition = positions.maxOrNull() ?: throw IllegalStateException("positions must have a maximum")

    return (minPosition..maxPosition).map { position ->
        positions.map { initial ->
            if (initial >= position) initial - position else position - initial
        }.map { distance -> (0.toUInt()..distance) }
            .map { costs -> costs.sum() }
    }.minOfOrNull { changes -> changes.sum() } ?: throw IllegalStateException("must be able to calculate fuel cost")
}


