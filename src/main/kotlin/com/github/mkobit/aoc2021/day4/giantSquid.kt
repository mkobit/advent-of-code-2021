package com.github.mkobit.aoc2021.day4


private class Board(
    val rows: List<List<UInt>>,
    val rowMarkCounts: List<UInt> = List(5) { 0.toUInt() },
    val columnMarkCounts: List<UInt> = List(5) { 0.toUInt() },
    val numberToCoordinates: Map<UInt, Pair<Int, Int>> = rows.flatMapIndexed { rowNum, row ->
        row.mapIndexed { columnNum, value ->
            value to (rowNum to columnNum)
        }
    }.toMap(),
    val sum: UInt = rows.flatten().sum()
) {

    fun mark(calledNumber: UInt): Board {
        val coordinates = numberToCoordinates[calledNumber]
        return if (coordinates == null) {
            this
        } else {
            val (calledRow, calledColumn) = coordinates
            Board(
                rows,
                rowMarkCounts.mapIndexed { row, count -> if (row == calledRow) count + 1.toUInt() else count },
                columnMarkCounts.mapIndexed { column, count -> if (column == calledColumn) count + 1.toUInt() else count },
                numberToCoordinates,
                sum - calledNumber
            )
        }
    }

    fun hasWon(): Boolean = rowMarkCounts.any { it == 5.toUInt() } ||
            columnMarkCounts.any { it == 5.toUInt() }

}

fun giantSquid(input: String): UInt {
    val lines = input.splitToSequence(System.lineSeparator())
    val calledNumbers = lines.first().splitToSequence(",")
        .map { it.toUInt() }
        .toList()
    val initialBoards = lines.drop(2)
        .filter { line -> line.isNotBlank() }
        .map { line -> line.trim().split(Regex("""\s+""")).map { it.toUInt() } }
        .windowed(size = 5, step = 5)
        .map { window -> Board(window) }
        .toList()

    data class Result(val boards: List<Board>, val winningBoard: Board?, val finalNumber: UInt?)
    val finalResult: Result = calledNumbers.fold(Result(initialBoards, null, null)) { acc, calledNumber ->
        val (boards, winningBoard) = acc
        if (winningBoard != null) {
            acc
        } else {
            val updatedBoards = boards.map { board -> board.mark(calledNumber) }
            updatedBoards.firstOrNull { it.hasWon() }
                ?.let { Result(boards, it, calledNumber) }
                ?: Result(updatedBoards, null, null)
        }
    }
    check(finalResult.winningBoard != null && finalResult.finalNumber != null) { "must be a winning board and final number" }
    return finalResult.winningBoard.sum * finalResult.finalNumber
}

fun giantSquidLetSquidWin(input: String): UInt {
    val lines = input.splitToSequence(System.lineSeparator())
    val calledNumbers = lines.first().splitToSequence(",")
        .map { it.toUInt() }
        .toList()
    val initialBoards = lines.drop(2)
        .filter { line -> line.isNotBlank() }
        .map { line -> line.trim().split(Regex("""\s+""")).map { it.toUInt() } }
        .windowed(size = 5, step = 5)
        .map { window -> Board(window) }
        .toList()

    data class Result(val boardsLeft: List<Board>, val wonBoards: List<Board>, val finalWinningBoard: Board?, val finalNumber: UInt?)
    val finalResult: Result = calledNumbers.fold(Result(initialBoards, emptyList(), null, null)) { acc, calledNumber ->
        val (boardsLeft, pastWonBoards, finalWinningBoard) = acc
        if (finalWinningBoard != null) {
            acc
        } else {
            val updatedBoards = boardsLeft.map { board -> board.mark(calledNumber) }
            val (nonWonBoards, wonBoards) = updatedBoards.partition { !it.hasWon() }
            if (nonWonBoards.isEmpty() && wonBoards.size == 1) {
                Result(nonWonBoards, pastWonBoards + wonBoards, wonBoards.first(), calledNumber)
            } else {
                Result(nonWonBoards, pastWonBoards + wonBoards, null, null)
            }
        }
    }
    check(finalResult.finalWinningBoard != null && finalResult.finalNumber != null) { "must be a last wining board and final number" }
    return finalResult.finalWinningBoard.sum * finalResult.finalNumber
}