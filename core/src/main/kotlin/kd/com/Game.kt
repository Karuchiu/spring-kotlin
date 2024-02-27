package kd.com

interface Game {
    fun getNumber(): Int
    fun getGuess(): Int
    fun setGuess(guess: Int)
    fun getGuessCount(): Int
    fun getSmallest(): Int
    fun getBiggest(): Int
    fun getRemainingGuesses(): Int
    fun reset()
    fun check()
    fun isValidNumberRange(): Boolean
    fun isGameWon(): Boolean
    fun isGameLost(): Boolean
}