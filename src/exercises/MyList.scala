package exercises

abstract class MyList {
  /*
    describes a list of integers
    method
     head = first element of the list
     tail = remainder of the list
     is Empty = returns bool
     add(int) +> returns new list with element added
     toString => string representation
   */

  def head(): Int
  def tail(): MyList
  def isEmpty(): Boolean
  def add(int: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  // this is an object because it's a singleton
  override def head(): Int = throw new NoSuchElementException
  override def tail(): MyList = throw new NoSuchElementException

  override def isEmpty = true
  override def add(int: Int): MyList = new Cons(int, this)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {

  override def head(): Int = h
  override def tail(): MyList = t
  override def isEmpty(): Boolean = false
  override def add(int: Int): MyList = new Cons(int, this)

  override def printElements: String = {
    if (t.isEmpty()) {
      "" + head()
    } else {
      head() + "," + t.printElements
    }
  }
}


object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail().head())
  println(list.add(4).head())
}