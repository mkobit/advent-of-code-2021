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
private sealed class Digit(private val enabledSegments: UByte, val value: UInt) {
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

  object Zero : Digit(0b11101110.toUByte(), UInt.MIN_VALUE)
  object One : Digit(0b00100100.toUByte(), 1.toUInt())
  object Two : Digit(0b10111010.toUByte(), 2.toUInt())
  object Three : Digit(0b10110110.toUByte(), 3.toUInt())
  object Four : Digit(0b01110100.toUByte(), 4.toUInt())
  object Five : Digit(0b11010110.toUByte(), 5.toUInt())
  object Six : Digit(0b11011110.toUByte(), 6.toUInt())
  object Seven : Digit(0b10100100.toUByte(), 7.toUInt())
  object Eight : Digit(0b11111110.toUByte(), 8.toUInt())
  object Nine : Digit(0b11110110.toUByte(), 9.toUInt())
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

fun add7SegmentDigits(input: String): UInt {
  return input.splitToSequence(System.lineSeparator())
    .map { line -> line.split(Regex("""\s+\|\s+""")) }
    .map {
      val (patterns, output) = it
      val enabledSegments = patterns.split(Regex("""\s+"""))
        .map(String::toSet)
      val outputSegments = output.split(Regex("""\s+"""))
        .map(String::toSet)
      enabledSegments to outputSegments
    }.map { (uniqueSegments, outputSegments) ->
      val digitsToSegments = buildMap<Digit, Set<Char>> {
        // find 1
        put(Digit.One, uniqueSegments.single { it.size == 2 })
        // find 4
        put(Digit.Four, uniqueSegments.single { it.size == 4 })
        // find 7
        put(Digit.Seven, uniqueSegments.single { it.size == 3 })
        // find 8
        put(Digit.Eight, uniqueSegments.single { it.size == 7 })
        // find 6
        put(
          Digit.Six,
          uniqueSegments.single {
            it.size == 6 && it.intersect(getValue(Digit.One)).size == 1
          }
        )
        // find 0
        put(
          Digit.Zero,
          uniqueSegments.single {
            it.size == 6 &&
                it.intersect(getValue(Digit.Four)).size == 3 &&
                it.intersect(getValue(Digit.One)).size == 2
          }
        )
        // find 5
        put(
          Digit.Five,
          uniqueSegments.single {
            it.size == 5 &&
                it.intersect(getValue(Digit.Zero)).size == 4 &&
                it.intersect(getValue(Digit.Six)).size == 5
          }
        )
        // find 2
        put(
          Digit.Two,
          uniqueSegments.single {
            it.size == 5 &&
                it.intersect(getValue(Digit.Five)).size == 3
          }
        )
        // find 3
        put(
          Digit.Three,
          uniqueSegments.single {
            it.size == 5 &&
                it.intersect(getValue(Digit.Five)).size == 4
          }
        )
        // find 9
        put(
          Digit.Nine,
          uniqueSegments.single {
            it.size == 6 &&
                it.intersect(getValue(Digit.Three)).size == 5
          }
        )
      }
      val segmentsToDigits = digitsToSegments.entries
        .associate { (key, value) -> value to key }
        .toMap()

     outputSegments.map { segmentsToDigits.getValue(it) }
       .map(Digit::value)
       .joinToString("")
       .toUInt()
    }.sum()
}