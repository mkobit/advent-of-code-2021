package com.github.mkobit.aoc2021.day10

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day10Test {

    companion object {
        private val SAMPLE_INPUT = """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/10/input"
    }

    @Test
    internal fun `sample input corrupted syntax score`() {
        expectThat(corruptedSyntaxScores(SAMPLE_INPUT))
            .isEqualTo(26397.toUInt())
    }

    @Test
    internal fun `problem input corrupted syntax score`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(corruptedSyntaxScores(input))
            .isEqualTo(554.toUInt())
    }
}