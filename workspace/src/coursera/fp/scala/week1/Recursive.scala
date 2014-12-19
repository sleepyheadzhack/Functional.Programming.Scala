package coursera.fp.scala.week1

/**
 * Created by sleepy-headz on 12/19/2014.
 */
object Recursive {

  // tail recursive gcd
  def gcd(a: Int, b: Int) : Int =
    if(b == 0) a else gcd(b, a%b)

  // non-tail recursive factorial
  def factorial(n: Long): Long =
    if(n == 0) 1 else n*factorial(n-1)

  // tail recursive factorial
  def tailfactorial(n: Long): Long = {
    def loop(acc: Long, n: Long): Long =
      if(n==0) acc
      else loop(acc * n, n-1)

    loop(1,n)
  }

  def main(args: Array[String]) {
    println(gcd(100000000, 10))
    println(tailfactorial(25))
    println(factorial(25))
  }
}
