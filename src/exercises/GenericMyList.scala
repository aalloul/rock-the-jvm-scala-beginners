package exercises

abstract class GenericMyList[+A]() {
  def head: A

  def tail: GenericMyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): GenericMyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B]

  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B]

  def filter(predicate: MyPredicate[A]): GenericMyList[A]

  def ++[B >: A](list: GenericMyList[B]): GenericMyList[B]
}

case object GenericEmpty extends GenericMyList[Nothing] {
  // this is an object because it's a singleton
  // Nothing is a good replacement for anything
  override def head: Nothing = throw new NoSuchElementException

  override def tail: GenericMyList[Nothing] = throw new NoSuchElementException

  override def isEmpty = true

  override def add[B >: Nothing](element: B): GenericMyList[B] = GenericCons(element, this)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): GenericMyList[B] = GenericEmpty

  def flatMap[B](transformer: MyTransformer[Nothing, GenericMyList[B]]): GenericMyList[B] = GenericEmpty

  def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = GenericEmpty

  // Concatenation function
  def ++[B >: Nothing](list: GenericMyList[B]): GenericMyList[B] = list
}

case class GenericCons[+A](h: A, t: GenericMyList[A]) extends GenericMyList[A] {

  def head: A = h

  override def tail: GenericMyList[A] = t

  override def isEmpty: Boolean = false

  def add[B >: A](elem: B): GenericMyList[B] = GenericCons(elem, this)

  override def printElements: String = {
    if (t.isEmpty) {
      "" + head
    } else {
      head + "," + t.printElements
    }
  }

  def filter(predicate: MyPredicate[A]): GenericMyList[A] = {
    if (predicate.test(h)) GenericCons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B] = {
    GenericCons(transformer.transform(h), t.map(transformer))
  }

  def ++[B >: A](list: GenericMyList[B]): GenericMyList[B] = GenericCons(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(t: Int): Boolean = t % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(a: String): Int = a.toInt
}

object GenericListText extends App {
  val listOfIntegers: GenericMyList[Int] = GenericCons(1, GenericCons(2, GenericCons(3, GenericEmpty)))
  val listOfStrings: GenericMyList[String] = GenericCons("Hello", GenericCons("Scala", GenericEmpty))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)
}