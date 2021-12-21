package com.github.mkobit.aoc2021.day21

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day21Test {

    companion object {
        private val SAMPLE_INPUT = """
            Player 1 starting position: 4
            Player 2 starting position: 8
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/21/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Test
    @Disabled
    internal fun `sample input play dirac dice`() {
        expectThat(playDiracDice(SAMPLE_INPUT))
            .isEqualTo(739_785.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input play dirac dice`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(deleteMe(input))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input p2`() {
        expectThat(optimalPolymer(SAMPLE_INPUT))
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