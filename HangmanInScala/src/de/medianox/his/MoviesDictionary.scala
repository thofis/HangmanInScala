package de.medianox.his;

import scala.util.Random

class MoviesDictionary extends Dictionary {

  val movies: List[String] = scala.io.Source.fromFile("movies.txt", "utf-8").getLines.toList

  val random = new Random

  def randomWord(): String = {
    movies(random.nextInt(movies.size))
  }

}