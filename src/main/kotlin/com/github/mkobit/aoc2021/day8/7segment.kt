package com.github.mkobit.aoc2021.day8

//  0:      1:      2:      3:      4:
// aaaa    ....    aaaa    aaaa    ....
//b    c  .    c  .    c  .    c  b    c
//b    c  .    c  .    c  .    c  b    c
// ....    ....    dddd    dddd    dddd
//e    f  .    f  e    .  .    f  .    f
//e    f  .    f  e    .  .    f  .    f
// gggg    ....    gggg    gggg    ....
//
//  5:      6:      7:      8:      9:
// aaaa    aaaa    aaaa    aaaa    aaaa
//b    .  b    .  .    c  b    c  b    c
//b    .  b    .  .    c  b    c  b    c
// dddd    dddd    ....    dddd    dddd
//.    f  e    f  .    f  e    f  .    f
//.    f  e    f  .    f  e    f  .    f
// gggg    gggg    ....    gggg    gggg
//
// bits:
// abcdefg0
// 76543210
private sealed class Digit(private val enabledSegments: UByte) {
  companion object {
    private val MASK = 0x10000000.toUByte()
  }
  val count: Int
    get() = enabledSegments.countOneBits()

  // 0 index starts from most significant bit
  private fun bitEnabledAt(index: Int): Boolean =
    MASK.rotateRight(index).and(enabledSegments) > UByte.MIN_VALUE

  val a: Boolean
    get() = bitEnabledAt(0)
  val b: Boolean
    get() = bitEnabledAt(1)
  val c: Boolean
    get() = bitEnabledAt(2)
  val d: Boolean
    get() = bitEnabledAt(3)
  val e: Boolean
    get() = bitEnabledAt(4)
  val f: Boolean
    get() = bitEnabledAt(5)
  val g: Boolean
    get() = bitEnabledAt(6)

  object Zero : Digit(0b11101110.toUByte())
  object One : Digit(0b00100100.toUByte())
  object Two : Digit(0b10111010.toUByte())
  object Three : Digit(0b10110110.toUByte())
  object Four : Digit(0b01110100.toUByte())
  object Five : Digit(0b11010110.toUByte())
  object Six : Digit(0b11011110.toUByte())
  object Seven : Digit(0b10100100.toUByte())
  object Eight : Digit(0b11111110.toUByte())
  object Nine : Digit(0b11110110.toUByte())
}

fun count7SegmentDigits(input: String): UInt {
  val digits = sequenceOf(Digit.One, Digit.Four, Digit.Seven, Digit.Eight)
    .map(Digit::count)
    .toSet()
  return input.splitToSequence(System.lineSeparator())
    .map { line -> line.split(Regex("""\s+\|\s+""")) }
    .map {
      val (_, output) = it
      output
    }.flatMap { output -> output.split(Regex("""\s""")) }
    .count { it.length in digits }
    .toUInt()
}