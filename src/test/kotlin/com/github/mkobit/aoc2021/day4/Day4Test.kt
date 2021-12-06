package com.github.mkobit.aoc2021.day4

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day4Test {

    companion object {
        private val SAMPLE_INPUT = """
            7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
            
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
            
             3 15  0  2 22
             9 18 13 17  5
            19  8  7 25 23
            20 11 10 24  4
            14 21 16 12  6
            
            14 21 17 24  4
            10 16 15  9 19
            18  8 23 26 20
            22 11 13  6  5
             2  0 12  3  7
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/4/input"
    }

    @Test
    internal fun `sample input giant squid`() {
        expectThat(giantSquid(SAMPLE_INPUT))
            .isEqualTo(4512.toUInt())
    }

    @Test
    internal fun `problem input giant squid`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(giantSquid(input))
            .isEqualTo(54275.toUInt())
    }

    @Test
    internal fun `sample input giant squid wins`() {
        expectThat(giantSquidLetSquidWin(SAMPLE_INPUT))
            .isEqualTo(1924.toUInt())
    }

    @Test
    internal fun `problem input giant squid wins`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(giantSquidLetSquidWin(input))
            .isEqualTo(13158.toUInt())
    }
}