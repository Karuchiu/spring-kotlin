package kd.com

import kd.com.ConsoleMain.Companion.log
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsoleMain{
    companion object {
        val log: Logger = LoggerFactory.getLogger(ConsoleMain::class.java)
    }
}

fun main(args: Array<String>) {
    log.info("Guess No.")
    runApplication<ConsoleMain>(*args)
}

