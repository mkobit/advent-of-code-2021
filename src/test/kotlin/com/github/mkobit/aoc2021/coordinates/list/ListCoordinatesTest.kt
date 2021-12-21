package com.github.mkobit.aoc2021.coordinates.list

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isNull
import strikt.assertions.isTrue

internal class ListCoordinatesTest {

  companion object {
    private val list = listOf(
      listOf("00", "01", "02"),
      listOf("10", "11", "12"),
      listOf("20", "21", "22"),
    )
  }

  @Test
  internal fun `row and column getters`() {
    val subject = 1 to 5
    expectThat(subject) {
      get { row }.isEqualTo(subject.first)
      get { column }.isEqualTo(subject.second)
    }
  }

  @Test
  internal fun `get list coordinate`() {
    expectThat(list) {
      get { this[0 to 2] }.isEqualTo("02")
      get { this[1 to 1] }.isEqualTo("11")
      get { this[2 to 0] }.isEqualTo("20")
    }
    expectThrows<IndexOutOfBoundsException> { list[2 to 4] }
  }

  @Test
  internal fun `get or null coordinate`() {
    expectThat(list) {
      get { getOrNull(0 to 2) }.isEqualTo("02")
      get { getOrNull(1 to 1) }.isEqualTo("11")
      get { getOrNull(2 to 0) }.isEqualTo("20")
      get { getOrNull(2 to 4) }.isNull()
    }
  }

  @Test
  internal fun `contains list coordinate`() {
    expectThat(list) {
      get { this.contains(0 to 2) }.isTrue()
      get { this.contains(1 to 1) }.isTrue()
      get { this.contains(2 to 0) }.isTrue()
      get { this.contains(2 to 4) }.isFalse()
    }
  }

  @Test
  internal fun `box coordinates`() {
    expectThat(list)
      .get { boxCoordinates().toList() }
      .containsExactly(
        0 to 0,
        0 to 1,
        0 to 2,
        1 to 0,
        1 to 1,
        1 to 2,
        2 to 0,
        2 to 1,
        2 to 2,
      )
  }

  @Test
  internal fun `adjacent coordinates`() {
    expectThat(1 to 1)
      .get { adjacent().toList() }
      .containsExactly(
        0 to 0,
        0 to 1,
        0 to 2,
        1 to 0,
        1 to 2,
        2 to 0,
        2 to 1,
        2 to 2,
      )
  }

  @Test
  internal fun `cardinal coordinates`() {
    expectThat(1 to 1) {
      get { above() }.isEqualTo(0 to 1)
      get { right() }.isEqualTo(1 to 2)
      get { below() }.isEqualTo(2 to 1)
      get { left() }.isEqualTo(1 to 0)
    }
  }
}