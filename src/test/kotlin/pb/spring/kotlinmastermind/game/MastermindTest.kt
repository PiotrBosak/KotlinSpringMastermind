package pb.spring.kotlinmastermind.game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import pb.spring.kotlinmastermind.game.exceptions.IllegalCodeException

class MastermindTest {


    @Test
    fun whenCreateGameWithCode_CodeStaysTheSame() {
        val code = "AAAA"
        val game = MastermindGame(code)
        assertEquals(game.code, code)
        println(MastermindGame.generateRandomCode())
    }

    @Test
    fun whenPassTooShortCode_ThrowException() {
        val tooShortCode = "AAA"
        assertThrows<IllegalCodeException> { val game = MastermindGame(tooShortCode)}
    }
    @Test
    fun whenPassCodeWithIllegalCharacters_ThrowException(){
        val tooShortCode = "GAAA"
        assertThrows<IllegalCodeException> { val game = MastermindGame(tooShortCode)}
    }
    @Test
    fun whenPassTotallyWrongGuess_GiveZeroPoints(){
        val result = makeGuess("ABCD","FFFF")
        assertEquals(0,result.positionPoints)
        assertEquals(0,result.valuePoints)
    }
    @Test
    fun whenPassCodeForOneValuePoint_GetOneValuePoint(){
        val result = makeGuess("ABCD","DFFF")
        assertEquals(0,result.positionPoints)
        assertEquals(1,result.valuePoints)

    }
    @Test
    fun whenPassCodeForOneValuePointAndOnePosition_GetThat(){
        val result = makeGuess("BBAA","ABFF")
        assertEquals(1,result.valuePoints)
        assertEquals(1,result.positionPoints)
    }

    @Test
    fun whenPassedCorrectCode_GiveFourPositionPoints(){
        val result = makeGuess("AAAA","AAAA")
        assertEquals(0,result.valuePoints)
        assertEquals(4,result.positionPoints)
    }
    private fun makeGuess(code:String,guess:String): Result {
        val mastermindGame = MastermindGame(code)
        return mastermindGame.makeGuess(guess)
    }


}