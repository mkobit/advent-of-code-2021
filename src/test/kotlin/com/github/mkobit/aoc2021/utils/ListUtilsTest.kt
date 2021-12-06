package com.github.mkobit.aoc2021.utils

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly

internal class ListUtilsTest {

    companion object {
        private val LIST = listOf(0, 1, 2, 3, 4)
    }

    @Test
    internal fun `update first element`() {
        expectThat(LIST.update(0) { it + 10 })
            .containsExactly(10, 1, 2, 3, 4)
    }

    @Test
    internal fun `update middle element`() {
        expectThat(LIST.update(2) { it + 10 })
            .containsExactly(0, 1, 12, 3, 4)
    }

    @Test
    internal fun `update last element`() {
        expectThat(LIST.update(4) { it + 10 })
            .containsExactly(0, 1, 2, 3, 14)
    }
}