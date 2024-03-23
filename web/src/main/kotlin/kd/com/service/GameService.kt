package kd.com.service

interface GameService {

    fun isGameOver(): Boolean
    fun getMainMessage(): String
    fun getResultMessage(): String
    fun checkGuess(guess: Int)
    fun reset()
}