package com.github.mkobit.aoc2021.day13

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day13Test {

    companion object {
        private val SAMPLE_INPUT_1 = """
            6,10
            0,14
            9,10
            0,3
            10,4
            4,11
            6,0
            6,12
            4,1
            0,13
            10,12
            3,4
            3,0
            8,4
            1,10
            2,14
            8,10
            9,0
            
            fold along y=7
            fold along x=5
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/13/input"
    }

    @Test
    internal fun `sample input transparent origami`() {
        expectThat(foldPaper(SAMPLE_INPUT_1))
            .isEqualTo(17.toUInt())
    }

    @Test
    internal fun `problem input transparent origami`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(foldPaper(input))
            .isEqualTo(837.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input 1 part 2`() {
        expectThat(foldPaper(SAMPLE_INPUT_1))
            .isEqualTo(288957.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input part 2`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(foldPaper(input))
            .isEqualTo(0.toUInt())
    }
}