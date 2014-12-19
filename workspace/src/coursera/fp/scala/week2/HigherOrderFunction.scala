package scala

/**
 * Created by sleepy-headz on 12/19/2014.
 */
object HigherOrderFunction {

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(acc: Int, a: Int): Int = {
      if(a > b) acc
      else loop(acc + f(a), a+1)
    }

    loop(0,a)
  }

  def main(args: Array[String]) {
    def cube(x: Int) = x * x * x
    def square(x: Int) = x * x

    println(sum(cube, 1, 3))
    println(sum(square, 1, 3))
    println(sum(x => 2*x, 1, 3))
  }
}
