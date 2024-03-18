package kd.com

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import kd.com.qualifiers.GuessCount
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class GameImpl(
    private var numberGenerator: NumberGenerator,
    @GuessCount private var guessCount: Int
) : Game {
    companion object {
        val log: Logger = LoggerFactory.getLogger(GameImpl::class.java)
    }

    private var number: Int = 0
    private var guess: Int = 0
    private var smallest: Int = 0
    private var biggest: Int = 0
    private var remainingGuesses: Int = 0
    private var validNumberRange: Boolean = true

    @PostConstruct
    override fun reset() {
        smallest = numberGenerator.getMinNumber()
        guess = numberGenerator.getMinNumber()
        remainingGuesses = guessCount
        biggest = numberGenerator.getMaxNumber()
        number = numberGenerator.nextNumber()
        log.info("The number is $number")
    }

    @PreDestroy
    fun destroyPre() {
        log.info("preDestroy() called")
    }

    override fun getNumber(): Int {
        return number
    }

    override fun getGuess(): Int {
        return guess
    }

    override fun setGuess(guess: Int) {
        this.guess = guess
    }

    override fun getGuessCount(): Int {
        return guessCount
    }

    override fun getSmallest(): Int {
        return smallest
    }

    override fun getBiggest(): Int {
        return biggest
    }

    override fun getRemainingGuesses(): Int {
        return remainingGuesses
    }

    override fun isValidNumberRange(): Boolean {
        return validNumberRange
    }

    override fun isGameWon(): Boolean {
        return guess == number
    }

    override fun isGameLost(): Boolean {
        return !isGameWon() && remainingGuesses <= 0
    }

    override fun check() {
        checkValidNumberRange()

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1
            }

            if (guess < number) {
                smallest = guess + 1
            }
        }

        remainingGuesses--
    }

    private fun checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest)
    }
}