package coursera.fp.scala.week2

/**
 * Created by sleepy-headz on 12/20/2014.
 */
object Rationals {
  def main(args: Array[String]){
    val x = new Rational(3);
    val y = new Rational(5, 7);
    val z = new Rational(3, 2);

    println(x+" + "+y+" = "+x + y);
    println(x+" - "+y+" - "+z+" = "+(x - y - z));
    println(x+" less than "+y+" = "+(x < y));
    println("max of "+x+" and "+y+" = "+x.max(y));

  }
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non zero");

  def this(x: Int) = this(x,1);

  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a%b);
  private val g = gcd(x,y);
  def numer = x/g;
  def denom = y/g;

  def + (that: Rational) =  new Rational(this.numer*that.denom+this.denom*that.numer, this.denom*that.denom);
  def unary_- = new Rational(-numer, denom);
  def - (that: Rational) = this + -that;
  def < (that: Rational) = this.numer * that.denom < that.numer * this.denom;
  def max(that: Rational) = if (this < that) that else this;
  override def toString = numer + "/" + denom;
}