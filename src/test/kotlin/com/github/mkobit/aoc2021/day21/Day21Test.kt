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
    internal fun `sample input play dirac dice`() {
        expectThat(playDiracDice(SAMPLE_INPUT))
            .isEqualTo(739_785.toUInt())
    }

    @Test
    internal fun `problem input play dirac dice`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(playDiracDice(input))
            .isEqualTo(556_206.toUInt())
    }

    @Test
    @Disabled("still needs work on algorithm for calculation")
    internal fun `sample input quantum dirac`() {
        expectThat(playDiracDiceQuantumDice(SAMPLE_INPUT))
            .isEqualTo(444_356_092_776_315L.toULong())
    }

    @Test
    @Disabled
    internal fun `problem input quantum dirac`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(playDiracDiceQuantumDice(input))
            .isEqualTo(0L.toULong())
    }
}