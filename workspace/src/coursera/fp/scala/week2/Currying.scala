package coursera.fp.scala.week2

/**
 * Created by sleepy-headz on 12/19/2014.
 */
object Currying {
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if(a > b) 0 else f(a)+ sum(f)(a+1, b)

  def main(args: Array[String]) {
    def sumCube   = sum(x => x * x * x)_
    def sumSquare = sum(x => x * x)_

    println(sumCube(1,3))
    println(sumSquare(1,3))
  }
}
