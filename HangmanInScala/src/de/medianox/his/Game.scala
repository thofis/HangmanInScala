package de.medianox.his

import scala.annotation.tailrec

class Game(val dictionary: Dictionary) {

  val initialSearchTerm = new SearchTerm(dictionary.randomWord)

  val nrOfFailedAttempts = 7

  def play(): Boolean = {
    takeAGuess(initialSearchTerm, nrOfFailedAttempts)
  }

  @tailrec
  final def takeAGuess(searchTerm: SearchTerm, failedAttemptsLeft: Int): Boolean = {
    if (searchTerm.gameWon) {
      true
    } else if (failedAttemptsLeft == 0) {
      false
    } else {
      println("-----------------------------------------")
      println("Attempts left    : " + failedAttemptsLeft)
      println("Search Term      : " + searchTerm.hiddentext)
      print("Enter a character: ")
      val ch: Char = readChar

      val nextSearchTerm = searchTerm.guessCharacter(ch)
      val nextFailedAttemptsLeft = if (nextSearchTerm.didLastAttemptFail) failedAttemptsLeft - 1 else failedAttemptsLeft

      takeAGuess(nextSearchTerm, nextFailedAttemptsLeft)
    }
  }

}