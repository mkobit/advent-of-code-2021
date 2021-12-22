package com.github.mkobit.aoc2021.day16

import com.github.mkobit.aoc2021.day14.optimalPolymer
import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day16Test {

    companion object {
        private const val SAMPLE_INPUT_1 = "8A004A801A8002F478"
        private const val SAMPLE_INPUT_2 = "620080001611562C8802118E34"
        private const val SAMPLE_INPUT_3 = "C0015000016115A2E0802F182340"
        private const val SAMPLE_INPUT_4 = "A0016C880162017C3686B18A3D4780"
        private const val PROBLEM_INPUT_PATH = "test-data/day/16/input"
    }

    private fun deleteMe(input: String): UInt = TODO()

    @Nested
    @Disabled
    inner class PacketVersionsNumbersSumSampleInput {
        @Test
        internal fun `sample input 1 packet version sum`() {
            expectThat(packetVersionNumbersSum(SAMPLE_INPUT_1))
                .isEqualTo(16.toUInt())
        }

        @Test
        internal fun `sample input 2 packet version sum`() {
            expectThat(packetVersionNumbersSum(SAMPLE_INPUT_2))
                .isEqualTo(12.toUInt())
        }

        @Test
        internal fun `sample input 3 packet version sum`() {
            expectThat(packetVersionNumbersSum(SAMPLE_INPUT_3))
                .isEqualTo(23.toUInt())
        }

        @Test
        internal fun `sample input 4 packet version sum`() {
            expectThat(packetVersionNumbersSum(SAMPLE_INPUT_4))
                .isEqualTo(31.toUInt())
        }
    }

    @Test
    @Disabled
    internal fun `problem input packet version sum`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(packetVersionNumbersSum(input))
            .isEqualTo(0.toUInt())
    }

    @Nested
    @Disabled
    inner class Part2SampleInput {
        @Test
        internal fun `sample input 1`() {
            expectThat(deleteMe(SAMPLE_INPUT_1))
                .isEqualTo(0.toUInt())
        }

        @Test
        internal fun `sample input 2`() {
            expectThat(deleteMe(SAMPLE_INPUT_2))
                .isEqualTo(0.toUInt())
        }

        @Test
        internal fun `sample input 3`() {
            expectThat(deleteMe(SAMPLE_INPUT_3))
                .isEqualTo(0.toUInt())
        }

        @Test
        internal fun `sample input 4`() {
            expectThat(deleteMe(SAMPLE_INPUT_4))
                .isEqualTo(0.toUInt())
        }
    }

    @Test
    @Disabled
    internal fun `sample input p2`() {
        expectThat(deleteMe(SAMPLE_INPUT_1))
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