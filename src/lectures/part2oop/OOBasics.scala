package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 23 )
  println(person.age)
  println(person.x)
  // you can't do person.name
  person.greet("Adam")
}

// this is a constructor
class Person(name: String, val age: Int = 0) {
  // class parameters are different from class fields
  // if you want a field, you need to add `val` before the field definition

  // body
  val x = 2

  // this will be evaluated with every instantiation
  println(1+3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // overloading constructors
  // not really useful because an auxiliary constructor can only call another auxiliary constructor or the primary one
  // This basically means we can use default parameters in the primary constructor
  def this(name: String) = this(name, 0)
}

/*
  Novel and Writer class
  Writer: first name, surname, year of birth
    - method fullname: concat firstname + surname

  Novel: name, year of release, author
    - authorAge: age of author at year of release
    - isWrittenBy
    - copy (new year of release) = new instance of novel
 */


class Author(firstname: String, surname: String, val yearOfBirth: Int) {
  def fullName(): String = this.firstname + " " + this.surname
}

class Novel(name: String, yearOfRelease: Int, author: Author) {
  def authorAge(): Int = this.yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Author): Boolean = this.author == author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}


/*
  Counter class
    - receives an int
    - has a method which returns current count
    - method to increment and decrement by +1 : returns new Counter
    - overland inc/dec to receive an amount
 */

class Counter(cnt: Int) {
  def currentCount(): Int = cnt
  def increment(): Counter = new Counter(cnt + 1)
  def decrement(): Counter = new Counter(cnt - 1)
  def increment(inc: Int): Int = {
    if (inc <= 0) cnt
    else increment().increment(inc - 1)
  }
  def decrement(inc: Int) :Int= {
    if (inc <= 0) cnt
    else decrement().decrement(inc-1)
  }

}