package de.medianox.his

class SearchTerm(val plaintext: String, val displayedText: String = "", val didLastAttemptFail: Boolean = false) {

  val validChars = ('a' to 'z').toList ::: ('A' to 'Z').toList

  val hiddentext = {
    if (displayedText == "") {
      (for (ch <- plaintext) yield if (validChars.contains(ch)) '*' else ch).toString
    } else {
      displayedText
    }
  }

  def guessCharacter(guessChar: Char): SearchTerm = {
    if (charAlreadyGuessed(guessChar) || invalidCharEntered(guessChar)) {
      new SearchTerm(plaintext, hiddentext, false)
    } else {
      val plainAndHidden = plaintext zip hiddentext
      val nextHiddentext = (for ((plain, hidden) <- plainAndHidden) yield if (plain.toLower == guessChar.toLower) plain else hidden).mkString
      val didAttemptFail = hiddentext == nextHiddentext
      new SearchTerm(plaintext, nextHiddentext, didAttemptFail)
    }
  }

  def gameWon(): Boolean = plaintext == hiddentext

  def charAlreadyGuessed(ch: Char): Boolean = hiddentext exists (_.toLower == ch.toLower)

  def invalidCharEntered(ch: Char): Boolean = !(validChars contains (ch))
}