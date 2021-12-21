package com.github.mkobit.aoc2021.day14

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day14Test {

    companion object {
        private val SAMPLE_INPUT = """
            NNCB
            
            CH -> B
            HH -> N
            CB -> H
            NH -> C
            HB -> C
            HC -> B
            HN -> C
            NN -> C
            BH -> H
            NC -> B
            NB -> B
            BN -> B
            BB -> N
            BC -> B
            CC -> N
            CN -> C
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/14/input"
    }

    @Test
    internal fun `sample input optimal polymers`() {
        expectThat(optimalPolymer(SAMPLE_INPUT))
            .isEqualTo(1588.toUInt())
    }

    @Test
    internal fun `problem input optimal polymers`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(optimalPolymer(input))
            .isEqualTo(2321.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input part 2`() {
        expectThat(optimalPolymer(SAMPLE_INPUT))
            .isEqualTo(288957.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input part 2`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(optimalPolymer(input))
            .isEqualTo(0.toUInt())
    }
}