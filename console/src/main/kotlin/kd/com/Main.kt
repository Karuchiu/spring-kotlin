package kd.com

import kd.com.Main.Companion.log
import kd.com.config.GameConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class Main {
    companion object {
        val log: Logger = LoggerFactory.getLogger(Main::class.java)
    }
}

fun main() {
    log.info("Guess No.")

    val context: ConfigurableApplicationContext =
        AnnotationConfigApplicationContext(GameConfig::class.java)

    context.close()
}

