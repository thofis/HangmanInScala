package de.medianox.his

import org.scalatest.FunSuite
import scala.collection.mutable.Stack

class HangmanTestSuite extends FunSuite {

  val plaintext = "abcdef - xyz"
  val hiddentext = "****** - ***"

  test("plaintext gets correctly converted to hiddentext") {
    val searchterm = new SearchTerm(plaintext)
    assert(hiddentext == searchterm.hiddentext)
  }

  test("correct guess of a character") {
    val searchterm = new SearchTerm(plaintext)
    val nextSearchterm = searchterm.guessCharacter('C')
    assert(nextSearchterm.hiddentext == "**c*** - ***")
    assert(nextSearchterm.didLastAttemptFail == false)
  }

  test("incorrect guess of a character") {
    val searchterm = new SearchTerm(plaintext)
    val nextSearchterm = searchterm.guessCharacter('q')
    println(nextSearchterm.hiddentext)
    assert(nextSearchterm.hiddentext == "****** - ***")
    assert(nextSearchterm.didLastAttemptFail == true)
  }

}