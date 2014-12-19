package coursera.fp.scala.coursera.fp.scala.week3

/**
 * Created by sleepy-headz on 12/20/2014.
 */
object Set {

  def main(args: Array[String]){
    val t1 = new NonEmpty(2, Empty, Empty);
    val t2 = t1.include(3).include(5);
    val t3 = new NonEmpty(4, Empty, Empty);
    val t4 = t3.include(1);
    val t5 = t2.union(t4);

    println(t2);
    println(t4);
    println(t5);
  }
}

abstract class IntSet{
  def contains(x: Int): Boolean;
  def include(x: Int): IntSet;
  def union(other: IntSet): IntSet;
}

object Empty extends IntSet{
  def contains(x: Int) = false;
  def include(x: Int) = new NonEmpty(x, Empty, Empty);
  def union(other: IntSet) = other;
  override def toString = ".";
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  def contains(x: Int) = {
    if(x<elem) left.contains(x)
    else if (x>elem) right.contains(x)
    else true;
  }

  def include(x: Int) = {
    if(x<elem) new NonEmpty(elem, left.include(x), right)
    else if(x>elem) new NonEmpty(elem, left, right.include(x))
    else this;
  }

  def union(other: IntSet) = {
    ((right union left) union other) include elem;
  }

  override def toString = "{"+ left + elem + right +"}";
}
