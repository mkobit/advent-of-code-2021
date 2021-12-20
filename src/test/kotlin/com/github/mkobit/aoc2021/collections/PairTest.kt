package com.github.mkobit.aoc2021.collections

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.first
import strikt.assertions.isEqualTo
import strikt.assertions.second

internal class PairTest {
  @Test
  internal fun `reverse pair`() {
    expectThat(1 to 2)
      .get { reverse() }
      .and {
        first.isEqualTo(2)
        second.isEqualTo(1)
      }
  }
}