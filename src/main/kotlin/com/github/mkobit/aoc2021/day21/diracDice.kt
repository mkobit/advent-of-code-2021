package com.github.mkobit.aoc2021.day21

@JvmInline
private value class DiceRoll(val value: UInt)

@JvmInline
private value class TurnNumber(val number: UInt) {
  fun isPlayerOnesTurn(): Boolean = number.isOdd()
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

  fun advance(spaces: UInt): BoardPosition {
    return BoardPosition(
      (position + spaces - 1.toUInt()).mod(BOARD_MAX) + 1.toUInt()
    )
  }
}

private fun UInt.isOdd() = this.mod(2.toUInt()) != UInt.MIN_VALUE

private fun deterministicDice(): Sequence<DiceRoll> =
  generateSequence { (1.toUInt()..100.toUInt()).asSequence().map(::DiceRoll) }
    .flatten()

private fun turnNumbers(): Sequence<TurnNumber> =
  (1.toUInt()..UInt.MAX_VALUE).asSequence().map(::TurnNumber)

private fun turnRolls() =
  deterministicDice()
    .chunked(3)
    .zip(turnNumbers())

private fun parseInputInitialPositions(text: String): Pair<BoardPosition, BoardPosition> {
  return text.split(System.lineSeparator()).let { (first, second) ->
    val player1 = BoardPosition(first.last().digitToInt().toUInt())
    val player2 = BoardPosition(second.last().digitToInt().toUInt())
    player1 to player2
  }
}

fun playDiracDice(input: String): UInt {
  val (player1Initial, player2Initial) = parseInputInitialPositions(input)
  val winningScore = 1_000.toUInt()
  data class PlayerStatus(val position: BoardPosition, val score: UInt)
  data class Scoreboard(
    val playerOne: PlayerStatus,
    val playerTwo: PlayerStatus,
    val turn: TurnNumber,
  )
  return turnRolls()
    .runningFold(
      Scoreboard(
        playerOne = PlayerStatus(player1Initial, UInt.MIN_VALUE),
        playerTwo = PlayerStatus(player2Initial, UInt.MIN_VALUE),
        turn = TurnNumber(UInt.MIN_VALUE),
      )
    ) { scoreboard, (rolls, turn) ->
      val spacesToMove = rolls.sumOf { it.value }
      when {
        turn.isPlayerOnesTurn() -> {
          val newPosition = scoreboard.playerOne.position.advance(spacesToMove)
          val newScore = scoreboard.playerOne.score + newPosition.position
          scoreboard.copy(playerOne = PlayerStatus(newPosition, newScore), turn = turn)
        }
        else -> {
          val newPosition = scoreboard.playerTwo.position.advance(spacesToMove)
          val newScore = scoreboard.playerTwo.score + newPosition.position
          scoreboard.copy(playerTwo = PlayerStatus(newPosition, newScore), turn = turn)
        }
      }
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