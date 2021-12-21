package com.github.mkobit.aoc2021.day18

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day18Test {

    companion object {
        private val SAMPLE_INPUT = """
            [1,2]
            [[1,2],3]
            [9,[8,7]]
            [[1,9],[8,5]]
            [[[[1,2],[3,4]],[[5,6],[7,8]]],9]
            [[[9,[3,8]],[[0,9],6]],[[[3,7],[4,9]],3]]
            [[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/18/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Test
    @Disabled
    internal fun `sample input p1`() {
        expectThat(snailfishMagnitude(SAMPLE_INPUT))
            .isEqualTo(4140.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input p1`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(snailfishMagnitude(input))
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