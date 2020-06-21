package pb.spring.kotlinmastermind.game

import pb.spring.kotlinmastermind.game.exceptions.IllegalCodeException
import pb.spring.kotlinmastermind.game.exceptions.Result

class MastermindGame(code: String) {
    companion object {
        private val regex = Regex("[A-F]{4}")
    }

    val code = if (isCodeLegal(code)) code else throw IllegalCodeException

    private fun isCodeLegal(code: String): Boolean = code.matches(regex)
    fun makeGuess(guess: String): Result {
        val positionPoints = getPositionPoints(guess)
        val valuePoints = getAllPoints(guess) - positionPoints
        return Result(valuePoints, positionPoints)
    }

    private fun getPositionPoints(guess: String): Int = guess.withIndex().count { (i, c) -> c == code[i] }


    private fun getAllPoints(guess: String): Int = guess.count { c -> code.contains(c) }

}