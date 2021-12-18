package com.github.mkobit.aoc2021.day12

import com.github.mkobit.aoc2021.resourceText
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@Disabled("incomplete")
internal class Day12Test {

    companion object {
        private val SAMPLE_INPUT_1 = """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end
        """.trimIndent()
        private val SAMPLE_INPUT_2 = """
            HN-start
            start-kj
            dc-start
            dc-HN
            LN-dc
            HN-end
            kj-sa
            kj-HN
            kj-dc
        """.trimIndent()
        private val SAMPLE_INPUT_3 = """
            fs-end
            he-DX
            fs-he
            start-DX
            pj-DX
            end-zg
            zg-sl
            zg-pj
            pj-he
            RW-he
            fs-DX
            pj-RW
            zg-RW
            start-pj
            he-WI
            zg-he
            pj-fs
            start-RW
        """.trimIndent()
        private const val PROBLEM_INPUT_PATH = "test-data/day/11/input"
    }

    @Nested
    inner class SampleInputs {
        @Test
        internal fun `sample input 1 passage pathing`() {
            expectThat(passagePathing(SAMPLE_INPUT_1))
                .isEqualTo(10.toUInt())
        }

        @Test
        fun `sample input 2 passage pathing`() {
            expectThat(passagePathing(SAMPLE_INPUT_2))
                .isEqualTo(19.toUInt())
        }

        @Test
        internal fun `sample input 3 passage pathing`() {
            expectThat(passagePathing(SAMPLE_INPUT_3))
                .isEqualTo(226.toUInt())
        }
    }


    @Test
    internal fun `problem input passage pathing`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(passagePathing(input))
            .isEqualTo(1793.toUInt())
    }

    @Test
    @Disabled
    internal fun `sample input 1 part 2`() {
        expectThat(passagePathing(SAMPLE_INPUT_1))
            .isEqualTo(288957.toUInt())
    }

    @Test
    @Disabled
    internal fun `problem input part 2`() {
        val input = resourceText(PROBLEM_INPUT_PATH).trimIndent()

        expectThat(passagePathing(input))
            .isEqualTo(0.toUInt())
    }
}