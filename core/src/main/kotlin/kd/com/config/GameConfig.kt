package kd.com.config

import kd.com.qualifiers.GuessCount
import kd.com.qualifiers.MaxNumber
import kd.com.qualifiers.MinNumber
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration(proxyBeanMethods = false)
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = ["kd.com"])

class GameConfig {

    @Value("\${game.guessCount}")
    private var guessCount: Int = 0

    @Value("\${game.maxNumber}")
    private var maxNumber: Int = 0

    @Value("\${game.minNumber}")
    private var minNumber = 0

    @Bean
    @GuessCount
    fun guessCountBean(): Int {
        return guessCount
    }

    @Bean
    @MaxNumber
    fun maxNumberBean(): Int {
        return maxNumber
    }

    @Bean
    @MinNumber
    fun minNumberBean(): Int {
        return minNumber
    }
}