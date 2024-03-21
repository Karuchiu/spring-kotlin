package kd.com.util

import jakarta.annotation.PostConstruct
import kd.com.Game
import kd.com.GameService
import kd.com.MessageGenerator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GameServiceImpl(
    private var game: Game,
    private var msgGenerator: MessageGenerator
) : GameService {

    companion object {
        val log: Logger = LoggerFactory.getLogger(GameServiceImpl::class.java)
    }

    @PostConstruct
    fun init() {
        log.info("Test message ${getMainMessage()}")
        log.info("Test number ${game.getNumber()}")
    }

    override fun isGameOver(): Boolean {
        return game.isGameLost() || game.isGameWon()
    }

    override fun getMainMessage(): String {
        return msgGenerator.getMainMessage()
    }

    override fun getResultMessage(): String {
        return msgGenerator.getResultMessage()
    }

    override fun checkGuess(guess: Int) {
        game.setGuess(guess)
        game.check()
    }

    override fun reset() {
        game.reset()
    }
}