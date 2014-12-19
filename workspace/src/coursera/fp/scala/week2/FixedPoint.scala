package coursera.fp.scala.week2

/**
 * Created by sleepy-headz on 12/19/2014.
 */
object FixedPoint {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    Math.abs((x-y)/x)/x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double ={
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

  def main(args: Array[String]) {
    println(fixedPoint(x => 1 + x/2)(1))

    def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1)
    println(sqrt(9))
  }

}
