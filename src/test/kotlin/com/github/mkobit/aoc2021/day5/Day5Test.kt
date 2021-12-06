package com.github.mkobit.aoc2021.day5

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day5Test {

    companion object {
        private val SAMPLE_INPUT = """
            0,9 -> 5,9
            8,0 -> 0,8
            9,4 -> 3,4
            2,2 -> 2,1
            7,0 -> 7,4
            6,4 -> 2,0
            0,9 -> 2,9
            3,4 -> 1,4
            0,0 -> 8,8
            5,5 -> 8,2
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/5/input"
    }

    @Test
    internal fun `sample input geothermal vent`() {
        expectThat(hydrothermalVent(SAMPLE_INPUT))
            .isEqualTo(5.toUInt())
    }

    @Test
    internal fun `problem input geothermal vent`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(hydrothermalVent(input))
            .isEqualTo(8350.toUInt())
    }

    @Test
    internal fun `sample input giant squid wins`() {
        expectThat(hydrothermalVentDiagonal(SAMPLE_INPUT))
            .isEqualTo(12.toUInt())
    }

    @Test
    internal fun `problem input giant squid wins`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(hydrothermalVentDiagonal(input))
            .isEqualTo(19374.toUInt())
    }
}