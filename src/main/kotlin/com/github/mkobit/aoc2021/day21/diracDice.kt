package com.github.mkobit.aoc2021.day21

@JvmInline
private value class DiceRoll(val value: UInt)

@JvmInline
private value class TurnNumber(val number: UInt) {
  fun isPlayerOnesTurn(): Boolean = number.isOdd()

  fun next(): TurnNumber = TurnNumber(number + 1.toUInt())
}

@JvmInline
private value class BoardPosition(val position: UInt) {
  private companion object {
    private val BOARD_MIN = 1.toUInt()
    private val BOARD_MAX = 10.toUInt()
  }
  init {
    check(position in (BOARD_MIN..BOARD_MAX))
  }

  fun advance(spaces: UInt): BoardPosition = BoardPosition(
    (position + spaces - 1.toUInt()).mod(BOARD_MAX) + 1.toUInt()
  )
}

private fun UInt.isOdd() = this.mod(2.toUInt()) != UInt.MIN_VALUE

private fun turnNumbers(): Sequence<TurnNumber> =
  (1.toUInt()..UInt.MAX_VALUE).asSequence().map(::TurnNumber)

private fun parseInputInitialPositions(text: String): Pair<BoardPosition, BoardPosition> {
  return text.split(System.lineSeparator()).let { (first, second) ->
    val player1 = BoardPosition(first.last().digitToInt().toUInt())
    val player2 = BoardPosition(second.last().digitToInt().toUInt())
    player1 to player2
  }
}

private data class PlayerStatus(val position: BoardPosition, val score: UInt)

private data class Scoreboard(
  val playerOne: PlayerStatus,
  val playerTwo: PlayerStatus,
  val turn: TurnNumber,
) {
  fun update(spacesToMove: UInt, playedTurn: TurnNumber): Scoreboard {
    return when {
      playedTurn.isPlayerOnesTurn() -> {
        val newPosition = playerOne.position.advance(spacesToMove)
        val newScore = playerOne.score + newPosition.position
        copy(playerOne = PlayerStatus(newPosition, newScore), turn = playedTurn)
      }
      else -> {
        val newPosition = playerTwo.position.advance(spacesToMove)
        val newScore = playerTwo.score + newPosition.position
        copy(playerTwo = PlayerStatus(newPosition, newScore), turn = playedTurn)
      }
    }
  }
}

fun playDiracDice(input: String): UInt {
  val (player1Initial, player2Initial) = parseInputInitialPositions(input)
  val winningScore = 1_000.toUInt()
  fun deterministicDice(): Sequence<DiceRoll> =
    generateSequence { (1.toUInt()..100.toUInt()).asSequence().map(::DiceRoll) }
      .flatten()

  return deterministicDice()
    .chunked(3)
    .zip(turnNumbers())
    .runningFold(
      Scoreboard(
        playerOne = PlayerStatus(player1Initial, UInt.MIN_VALUE),
        playerTwo = PlayerStatus(player2Initial, UInt.MIN_VALUE),
        turn = TurnNumber(UInt.MIN_VALUE),
      )
    ) { scoreboard, (rolls, turn) ->
      val spacesToMove = rolls.sumOf { it.value }
      scoreboard.update(spacesToMove, turn)
    }.first { scoreboard ->
      scoreboard.run { playerOne.score >= winningScore || playerTwo.score >= winningScore }
    }.let { scoreboard ->
      val lowerScore = scoreboard.run {
        if (playerOne.score > playerTwo.score) {
          playerTwo.score
        } else {
          playerOne.score
        }
      }
      lowerScore * (scoreboard.turn.number * 3.toUInt())
    }
}

fun playDiracDiceQuantumDice(input: String): ULong {
  val (player1Initial, player2Initial) = parseInputInitialPositions(input)
  val winningScore = 21.toUInt()
  fun quantumRolls(): Sequence<DiceRoll> = (1.toUInt()..3.toUInt()).map(::DiceRoll).asSequence()
  // turn 1 - 1,2,3
  // turn 2 - 123,123,123
  // turn 3 - 123123123,123123123,123123123
  fun quantumTurn(scoreboard: Scoreboard): Sequence<Scoreboard> {
    if (scoreboard.run { playerOne.score >= winningScore || playerTwo.score >= winningScore }) {
      // game over
      return sequenceOf(scoreboard)
    }

    // need memoization
    // probably need bigint or something here
    return quantumRolls()
      .map { roll ->
        scoreboard.update(roll.value, scoreboard.turn.next())
      }.flatMap { newScorecard->
        quantumTurn(newScorecard)
      }
  }

  return quantumTurn(
    Scoreboard(
      playerOne = PlayerStatus(player1Initial, UInt.MIN_VALUE),
      playerTwo = PlayerStatus(player2Initial, UInt.MIN_VALUE),
      turn = TurnNumber(UInt.MIN_VALUE),
    )
  ).fold(mutableMapOf<Boolean, ULong>()) { acc, scoreboard ->
    val playerOneWon = scoreboard.playerOne.score >= winningScore
    acc.compute(playerOneWon) { _, previous ->
      if (previous == null) {
        1.toULong()
      } else {
        previous + 1.toULong()
      }
    }
    acc
  }.maxOf { it.value }
//    .groupingBy { it.playerOne.score >= winningScore }
//    .eachCount()
//    .values
//    .maxOf { it }
//    .toULong()
}