package de.medianox.his

object Main {

  def main(args: Array[String]) {
    val dictionary = new MoviesDictionary
    val theGame = new Game(dictionary)
    val gameWon = theGame.play

    if (gameWon) println("Game Won!") else println("Game Lost!")
    println("SearchTerm was : " + theGame.initialSearchTerm.plaintext)
  }

}