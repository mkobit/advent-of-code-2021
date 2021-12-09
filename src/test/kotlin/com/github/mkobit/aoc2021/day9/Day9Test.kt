package com.github.mkobit.aoc2021.day9

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day9Test {

    companion object {
        private val SAMPLE_INPUT = """
            2199943210
            3987894921
            9856789892
            8767896789
            9899965678
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/9/input"
    }

    @Test
    internal fun `sample input crab fuel`() {
        expectThat(lowLevelRiskSum(SAMPLE_INPUT))
            .isEqualTo(15.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input crab fuel`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(lowLevelRiskSum(input))
            .isEqualTo(1.toUInt())
    }
}