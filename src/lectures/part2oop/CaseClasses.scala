package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)
  /*
  The use of "CASE" has the effect of
    1. class parameters are fields
    2. produces a "sensible" toString representation
    3. equals and hashCode are implemented out of the box
    4. there's a copy method to create a new instance of the instance
    5. Case classes have companion objects
      5a. The companion objects come with factory methods
    7. Case classes are serializable
    8. Case classes have extractor patterns = CCs can be used in PATTERN MATCHING
   */

  val jim = new Person("Jim", 34)
  println(jim.name)
  println(jim.toString)

  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // this returns true!

  val jim3 = jim.copy(age = 45) // name is Jim but age is now 45

  val thePerson = Person // this is the companion object

  val mary = Person("Mary", 23) // this delegates to the apply method of object Person

  // This exists :) but don't have a companion object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
