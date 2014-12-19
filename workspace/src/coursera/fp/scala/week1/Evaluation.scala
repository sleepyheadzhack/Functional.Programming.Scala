package coursera.fp.scala.week1

/**
 * Created by sleepy-headz on 12/18/2014.
 */
object Evaluation {

  // loop function
  def loop : Int = loop

  // call by value example
  def cbv(a: Int, b: Int) = print(a)

  // call by name example
  def cbn(a: Int, b: => Int) = print(a)

  def main(args: Array[String]) {
    cbn(1, loop) // terminate call (cbn)
    cbv(2, loop) // non-terminate call (cbv)

    def byName  = loop // terminate value definition
    val byValue = loop // non-terminate value definition
  }

}
