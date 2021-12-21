package com.github.mkobit.aoc2021.day7

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day7Test {

    companion object {
        private val SAMPLE_INPUT = """
            16,1,2,0,4,2,7,1,2,14
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/7/input"
    }

    @Test
    internal fun `sample input crab fuel`() {
        expectThat(crabFuelCost(SAMPLE_INPUT))
            .isEqualTo(37.toUInt())
    }

    @Test
    internal fun `problem input crab fuel`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(crabFuelCost(input))
            .isEqualTo(364898.toUInt())
    }

    @Test
    internal fun `sample input crap fuel increasing cost`() {
        expectThat(crabFuelCostIncreasedCost(SAMPLE_INPUT))
            .isEqualTo(168.toUInt())
    }

    @Test
    internal fun `problem input crap fuel increasing cost`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(crabFuelCostIncreasedCost(input))
            .isEqualTo(104149091.toUInt())
    }
}