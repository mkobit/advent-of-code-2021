package com.github.mkobit.aoc2021.day1

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day1Test {

    companion object {
        private val SAMPLE_INPUT = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/1/input"
    }

    @Test
    internal fun `sample question input`() {
        expectThat(countIncreasing(SAMPLE_INPUT))
            .isEqualTo(7)
    }

    @Test
    internal fun `puzzle input`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()
        expectThat(countIncreasing(input))
            .isEqualTo(1711)
    }

    @Test
    internal fun `sample question input windowed`() {
        expectThat(countIncreasingWindows(SAMPLE_INPUT))
            .isEqualTo(5)
    }

    @Test
    internal fun `puzzle input for window follow up`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(countIncreasingWindows(input))
            .isEqualTo(1743)
    }
}