package pb.spring.kotlinmastermind.services

import org.springframework.stereotype.Service
import pb.spring.kotlinmastermind.game.MastermindGame
import pb.spring.kotlinmastermind.game.exceptions.IllegalGuessException

@Service
class GameServiceImpl : GameService {
    val mastermindGame = MastermindGame(MastermindGame.generateRandomCode())


    override fun makeGuess(guess:String):String =
            try {
                mastermindGame.makeGuess(guess).toString()
            }
            catch (e:IllegalGuessException) {
                "your guess is illegal"
            }
}