package com.github.mkobit.aoc2021.day1

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day1Test {
    @Test
    internal fun `sample question input`() {
        val input = """
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

        expectThat(countIncreasing(input))
            .isEqualTo(7)
    }

    @Test
    internal fun `puzzle input`() {
        val input = resourceText("test-data/day/1/input").trimIndent()

        expectThat(countIncreasing(input))
            .isEqualTo(1711)
    }
}