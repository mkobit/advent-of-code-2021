package com.github.mkobit.aoc2021.day2

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day2Test {
    companion object {
        private val SAMPLE_INPUT = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/2/input"
    }

    @Test
    internal fun `sample input coordinates`() {
        expectThat(submarineCoordinates(SAMPLE_INPUT))
            .isEqualTo(15 to 10)
    }

    @Test
    internal fun `problem input coordinates`() {
        val input = resourceText("test-data/day/2/input").trimIndent()

        expectThat(submarineCoordinates(input))
            .isEqualTo(2073 to 850)
    }

    @Test
    internal fun `sample input coordinates aim`() {
        expectThat(submarineCoordinatesAim(SAMPLE_INPUT))
            .isEqualTo(15 to 60)
    }

    @Test
    internal fun `problem input aim`() {
        val input = resourceText("test-data/day/2/input").trimIndent()
        expectThat(submarineCoordinatesAim(input))
            .isEqualTo(2073 to 895269)
    }
}