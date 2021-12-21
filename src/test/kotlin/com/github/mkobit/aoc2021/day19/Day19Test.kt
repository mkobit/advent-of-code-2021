package com.github.mkobit.aoc2021.day19

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day19Test {

    companion object {
        private val SAMPLE_INPUT = """
            --- scanner 0 ---
            -1,-1,1
            -2,-2,2
            -3,-3,3
            -2,-3,1
            5,6,-4
            8,0,7

            --- scanner 0 ---
            1,-1,1
            2,-2,2
            3,-3,3
            2,-1,3
            -5,4,-6
            -8,-7,0

            --- scanner 0 ---
            -1,-1,-1
            -2,-2,-2
            -3,-3,-3
            -1,-3,-2
            4,6,5
            -7,0,8

            --- scanner 0 ---
            1,1,-1
            2,2,-2
            3,3,-3
            1,3,-2
            -4,-6,5
            7,0,8

            --- scanner 0 ---
            1,1,1
            2,2,2
            3,3,3
            3,1,2
            -6,-4,-5
            0,7,-8
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/19/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Test
    @Disabled
    internal fun `sample input count beacons`() {
        expectThat(assembleMapAndCountBeacons(SAMPLE_INPUT))
            .isEqualTo(79.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input count beacons`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(assembleMapAndCountBeacons(input))
            .isEqualTo(0.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input p2`() {
        expectThat(deleteMe(SAMPLE_INPUT))
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