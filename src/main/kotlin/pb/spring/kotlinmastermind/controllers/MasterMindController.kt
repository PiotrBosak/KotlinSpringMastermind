package pb.spring.kotlinmastermind.controllers

import org.springframework.web.bind.annotation.*
import pb.spring.kotlinmastermind.services.GameService

@RestController
@RequestMapping("mastermind/")
class MasterMindController(private val gameService: GameService) {

    @GetMapping("index")
    fun index(): String {
        return "bitch"
    }
    @PostMapping("guess")
    fun makeGuess(@RequestBody guess:String):String = gameService.makeGuess(guess)


}