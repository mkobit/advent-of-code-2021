package com.github.mkobit.aoc2021.day15

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day15Test {

    companion object {
        private val SAMPLE_INPUT = """
            1163751742
            1381373672
            2136511328
            3694931569
            7463417111
            1319128137
            1359912421
            3125421639
            1293138521
            2311944581
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/14/input"
    }

    @Test
    @Disabled
    internal fun `sample input lowest total risk`() {
        expectThat(lowestTotalRisk(SAMPLE_INPUT))
            .isEqualTo(40.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input lowest total risk`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(lowestTotalRisk(input))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input p2`() {
        expectThat(lowestTotalRisk(SAMPLE_INPUT))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input p2`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(lowestTotalRisk(input))
            .isEqualTo(0.toUInt())
    }
}