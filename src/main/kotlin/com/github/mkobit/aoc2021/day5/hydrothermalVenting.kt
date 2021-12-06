package com.github.mkobit.aoc2021.day5


private data class Point(val x: UInt, val y: UInt)

private data class Line(val first: Point, val second: Point)

private fun Line.isStraightLine(): Boolean =
    first.x == second.x || first.y == second.y

private fun pointTextToPoint(text: String): Point =
    text.split(",").let { split -> Point(split[0].toUInt(), split[1].toUInt()) }
private fun lineTextToLine(text: String) =
    text.split(Regex("""\s+->\s+""")).let { pointsTexts -> Line(pointTextToPoint(pointsTexts[0]), pointTextToPoint(pointsTexts[1])) }

fun hydrothermalVent(input: String): UInt {
    // "Consider only horizontal and vertical lines. At how many points do at least two lines overlap?"
    val straightLines = input.splitToSequence(System.lineSeparator())
        .map { lineTextToLine(it) }
        .filter { it.isStraightLine() }
        .toList()
    fun Line.points(): Sequence<Point> = if (first.y == second.y) {
        (if (first.x < second.x) first.x..second.x else first.x downTo second.x)
            .asSequence()
            .map { Point(it, first.y) }
    } else {
        (if (first.y < second.y) first.y..second.y else first.y downTo second.y)
            .asSequence()
            .map { Point(first.x, it) }
    }
    return straightLines.asSequence()
        .flatMap { it.points() }
        .groupingBy { it }
        .eachCount()
        .filterValues { count -> count > 1 }
        .count()
        .toUInt()
}

fun hydrothermalVentDiagonal(input: String): UInt {
    // "Because of the limits of the hydrothermal vent mapping system,
    // the lines in your list will only ever be horizontal,
    // vertical, or a diagonal line at exactly 45 degrees. In other words:"
    val lines = input.splitToSequence(System.lineSeparator())
        .map { lineTextToLine(it) }
        .toList()
    fun Line.points(): Sequence<Point> = if (first.y == second.y) {
        // horizontal
        (if (first.x < second.x) first.x..second.x else first.x downTo second.x)
            .asSequence()
            .map { Point(it, first.y) }
    } else if (first.x == second.x) {
        // vertical
        (if (first.y < second.y) first.y..second.y else first.y downTo second.y)
            .asSequence()
            .map { Point(first.x, it) }
    } else {
        // 45 diagonal
        val xs = (if (first.x < second.x) first.x..second.x else first.x downTo second.x)
        val ys = (if (first.y < second.y) first.y..second.y else first.y downTo second.y)
        xs.zip(ys).asSequence().map { (x, y) -> Point(x, y) }
    }
    return lines.asSequence()
        .flatMap { it.points() }
        .groupingBy { it }
        .eachCount()
        .filterValues { count -> count > 1 }
        .count()
        .toUInt()
}
