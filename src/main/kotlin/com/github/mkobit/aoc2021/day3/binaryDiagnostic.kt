package com.github.mkobit.aoc2021.day3


// gamma rate to epsilon rate
fun binaryDiagnostic(input: String): Pair<UInt, UInt> =
    input.splitToSequence(System.lineSeparator())
        .fold((emptyList<Int>() to 0)) { oneCountsToTotal, binaryText ->
            val (oneCounts, seen) = oneCountsToTotal
            val updatedOneCounts = binaryText.map { it.digitToInt() }
                .mapIndexed { index, binaryInt ->
                    binaryInt + (oneCounts.getOrNull(index) ?: 0)
                }
            updatedOneCounts to seen + 1
        }.let { oneCountsToTotal ->
            val (oneCounts, total) = oneCountsToTotal
            val half = total / 2
            val gammaRate = oneCounts.joinToString(separator = "") { oneCount ->
                if (oneCount > half) "1" else "0"
            }.toUInt(2)
            val epsilonRate = oneCounts.joinToString(separator = "") { oneCount ->
                if (oneCount > half) "0" else "1"
            }.toUInt(2)
            gammaRate to epsilonRate
        }

// oxygen generator rating to CO2 scrubber rating
fun binaryDiagnosticLifeSupport(input: String): Pair<UInt, UInt> {
    val allReadings = input.split(System.lineSeparator())
    return filterReadingsForType(allReadings, 0, ReadingType.OXYGEN) to filterReadingsForType(allReadings, 0, ReadingType.CO2)
}

private enum class ReadingType {
    OXYGEN,
    CO2
}

// these are basically the same with 1 different in the when - could easy be simplified with another parameter
private fun filterReadingsForType(readings: List<String>, index: Int, readingType: ReadingType): UInt {
    check(readings.isNotEmpty()) { "Must have readings to filter for reading type $readingType" }
    if (readings.size == 1) return readings.first().toUInt(2)

    val indexBitCounts = readings.groupingBy { it[index] }.eachCount()
    val (maxBit, minBit) = run {
        if (indexBitCounts['0'] == indexBitCounts['1'] ) {
            null to null
        } else {
            indexBitCounts.maxByOrNull { it.value }?.key to
                    indexBitCounts.minByOrNull { it.value }?.key
        }
    }

    val filterBitChar = when(readingType) {
        ReadingType.OXYGEN -> when (maxBit) {
            // select majority bit, 1 if equal
            null -> '1'
            else -> maxBit
        }
        ReadingType.CO2 -> when (minBit) {
            // select minority bit, 0 if equal
            null -> '0'
            else -> minBit
        }
    }

    return filterReadingsForType(readings.filter { it[index] == filterBitChar }, index + 1, readingType)
}
//
//private fun findCO2ScrubberReading(readings: List<String>, index: Int): UInt {
//    check(readings.isNotEmpty()) { "Cannot be out of readings to filter" }
//    if (readings.size == 1) return readings.first().toUInt(2)
//
//    val onesInIndex = readings.map { it[index] == '1' }
//        .count()
//    return when {
//        onesInIndex < readings.size / 2 -> findOxygenGeneratorReading(readings.filter { it[index] == '1' }, index + 1)
//        else -> findOxygenGeneratorReading(readings.filter { it[index] == '0' }, index + 1)
//    }
//}