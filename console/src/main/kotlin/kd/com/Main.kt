package kd.com

import kd.com.Main.Companion.log
import kd.com.config.GameConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Main {
    companion object {
        val log: Logger = LoggerFactory.getLogger(Main::class.java)
    }
}

fun main(args: Array<String>) {
    log.info("Guess No.")
    runApplication<Main>(*args)
}