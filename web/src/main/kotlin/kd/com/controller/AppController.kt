package kd.com.controller

import kd.com.service.GameService
import kd.com.util.AttributeNames
import kd.com.util.GameMappings
import kd.com.util.ViewNames
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AppController(
    private val gameService: GameService
) {

    companion object {
        private val log = LoggerFactory.getLogger(AppController::class.java)
    }

    @GetMapping(GameMappings.PLAY)
    fun play(model: Model): String {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage())
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage())
        log.info("Model $model")

        if (gameService.isGameOver()){
            return ViewNames.GAME_OVER
        }

        return ViewNames.PLAY
    }

    @PostMapping(GameMappings.PLAY)
    fun processMessage(@RequestParam(name = "guess") guess: Int): String{
        log.info("Guess = $guess")
        gameService.checkGuess(guess)
        return GameMappings.REDIRECT_PLAY
    }

    @GetMapping(GameMappings.RESTART)
    fun restart(): String {
        gameService.reset()
        return GameMappings.REDIRECT_PLAY
    }
}