package com.github.mkobit.aoc2021.day11

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day11Test {

    companion object {
        private val SAMPLE_INPUT = """
            5483143223
            2745854711
            5264556173
            6141336146
            6357385478
            4167524645
            2176841721
            6882881134
            4846848554
            5283751526
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/11/input"
    }

    @Test
    @Disabled
    internal fun `sample input octopus flashes`() {
        expectThat(octopusFlashes(SAMPLE_INPUT))
            .isEqualTo(1656.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input octopus flashes`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(octopusFlashes(input))
            .isEqualTo(0.toUInt())
    }
//
//    @Test
//    internal fun `sample input incomplete syntax score`() {
//        expectThat(incompleteSyntaxScores(SAMPLE_INPUT))
//            .isEqualTo(288957.toULong())
//    }
//
//    @Test
//    internal fun `problem input incomplete syntax score`() {
//        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()
//
//        expectThat(incompleteSyntaxScores(input))
//            .isEqualTo(0.toULong())
//    }
}