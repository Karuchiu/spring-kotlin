package kd.com

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.Scanner

@Component
class ConsoleNumberGuess(
    private val game: Game,
    private val messageGenerator: MessageGenerator
) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(ConsoleNumberGuess::class.java)
    }

    @EventListener(ContextRefreshedEvent::class)
    fun start() {
        log.info("start() --> container ready")

        val scanner = Scanner(System.`in`)

        while (true) {
            println(messageGenerator.getMainMessage())
            println(messageGenerator.getResultMessage())

            val guess: Int = scanner.nextInt()
            scanner.nextLine()
            game.setGuess(guess)
            game.check()

            if (game.isGameWon() || game.isGameLost()) {
                println(messageGenerator.getResultMessage())
                println("Play Again Y/N?")

                val playAgainString = scanner.nextLine().trim()
                if (!playAgainString.equals("y", ignoreCase = true)) {
                    break
                }

                game.reset()
            }
        }
    }
}