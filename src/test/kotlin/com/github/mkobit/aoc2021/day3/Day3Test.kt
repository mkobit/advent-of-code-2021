package com.github.mkobit.aoc2021.day3

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day3Test {

    companion object {
        private val SAMPLE_INPUT = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent()
    }

    @Test
    internal fun `sample input diagnostic`() {
        expectThat(binaryDiagnostic(SAMPLE_INPUT))
            .isEqualTo(22.toUInt() to 9.toUInt())
    }

    @Test
    internal fun `problem input diagnostic`() {
        val input = resourceText("test-data/day/3/input").trimIndent()

        expectThat(binaryDiagnostic(input))
            .isEqualTo(2520.toUInt() to 1575.toUInt())
    }

    @Test
    internal fun `sample input life support`() {
        expectThat(binaryDiagnosticLifeSupport(SAMPLE_INPUT))
            .isEqualTo(23.toUInt() to 10.toUInt())
    }

    @Test
    internal fun `problem input life support`() {
        val input = resourceText("test-data/day/3/input").trimIndent()

        expectThat(binaryDiagnosticLifeSupport(input))
            .isEqualTo(2509.toUInt() to 1701.toUInt())
    }
}