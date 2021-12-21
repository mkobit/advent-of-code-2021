package com.github.mkobit.aoc2021.day20

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day20Test {

    companion object {
        private val SAMPLE_INPUT = """
            ..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##
            #..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###
            .######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#.
            .#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#.....
            .#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#..
            ...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.....
            ..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/20/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Test
    @Disabled
    internal fun `sample input count lit pixels`() {
        expectThat(countLitPixels(SAMPLE_INPUT))
            .isEqualTo(35.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input count lit pixels`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(countLitPixels(input))
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