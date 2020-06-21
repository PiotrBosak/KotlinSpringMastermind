package pb.spring.kotlinmastermind.services


interface GameService {
    fun makeGuess(guess:String):String
}