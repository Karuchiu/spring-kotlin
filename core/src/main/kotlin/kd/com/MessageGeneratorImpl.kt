package kd.com

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MessageGeneratorImpl(
    private var game: Game
) : MessageGenerator {

    companion object {
        val log: Logger = LoggerFactory.getLogger(MessageGeneratorImpl::class.java)
    }

    @PostConstruct
    fun init() {
        log.info("Value of game is {}", game)
    }

    override fun getMainMessage(): String {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?"
    }

    override fun getResultMessage(): String {
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber()
        } else if (game.isGameLost()) {
            return "You lost. (Loser) The number was " + game.getNumber()
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!"
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?"
        } else {
            var direction = "Lower"

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher"
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left"
        }
    }
}