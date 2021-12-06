package com.github.mkobit.aoc2021.day6

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day6Test {

    companion object {
        private val SAMPLE_INPUT = """
            3,4,3,1,2
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/6/input"
    }

    @Test
    internal fun `sample input lanternfish`() {
        expectThat(lanternfish(SAMPLE_INPUT))
            .isEqualTo(5934.toUInt())
    }

    @Test
    internal fun `problem input lanternfish`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(lanternfish(input))
            .isEqualTo(379114.toUInt())
    }
//
//    @Test
//    internal fun `sample input giant squid wins`() {
//        expectThat(hydrothermalVentDiagonal(SAMPLE_INPUT))
//            .isEqualTo(12.toUInt())
//    }
//
//    @Test
//    internal fun `problem input giant squid wins`() {
//        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()
//
//        expectThat(hydrothermalVentDiagonal(input))
//            .isEqualTo(19374.toUInt())
//    }
}