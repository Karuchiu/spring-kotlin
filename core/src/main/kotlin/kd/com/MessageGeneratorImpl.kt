package kd.com

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class MessageGeneratorImpl(
    private var game: Game,
    private var messageSource: MessageSource
) : MessageGenerator {

    companion object {
        val log: Logger = LoggerFactory.getLogger(MessageGeneratorImpl::class.java)
        val MAIN_MESSAGE: String = "game.main.message"
        val GAME_WIN = "game.win"
        val GAME_LOST = "game.lost"
        val GAME_INVALID = "game.invalid"
        val FIRST_GUESS = "game.first.guess"
        val LOWER = "game.lower"
        val HIGHER = "game.higher"
        val REMAINING = "game.remaining"
    }

    @PostConstruct
    fun init() {
        log.info("Value of game is {}", game)
    }

    override fun getMainMessage(): String {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest())
    }

    override fun getResultMessage(): String {
        if (game.isGameWon()) {
            return getMessage(GAME_WIN, game.getNumber())
        } else if (game.isGameLost()) {
            return getMessage(GAME_LOST, game.getNumber())
        } else if (!game.isValidNumberRange()) {
            return getMessage(GAME_INVALID, game.getRemainingGuesses())
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS)
        } else {
            var direction = getMessage(LOWER)

            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER)
            }

            return getMessage(REMAINING, direction, game.getRemainingGuesses())
        }
    }

    fun getMessage(code: String, vararg args: Any): String{
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale())
    }
}