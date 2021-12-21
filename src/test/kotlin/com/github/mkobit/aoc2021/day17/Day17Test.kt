package com.github.mkobit.aoc2021.day17

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day17Test {

    companion object {
        private val SAMPLE_INPUT = """
            target area: x=20..30, y=-10..-5
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/17/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Test
    @Disabled
    internal fun `sample input highest trajectory`() {
        expectThat(highestTrajectory(SAMPLE_INPUT))
            .isEqualTo(45.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input highest trajectory`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(deleteMe(input))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input p2`() {
        expectThat(deleteMe(SAMPLE_INPUT))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input p2`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(deleteMe(input))
            .isEqualTo(0.toUInt())
    }
}