package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (NO "static")

  object Person { // this is both a type and its only instance
    // so this object holds the static / class functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method to create new instances of Person
    def apply(mother: Person, father: Person) = new Person("kid")
  }

  // when we want to define instance-level functionality, we define a class
  // example the class PErson
  class Person(str: String) {
    // holds the instance level
  }

  // class & object Person are companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE

  val mary = Person
  val john = Person
  println(mary == john)
  // returns True because Person is an instance and both are pointing to the same instance

  val mary_class = new Person("mary")
  val john_class = new Person("john")
  println(mary_class == john_class)
  // prints True because now mary_class and john_class are instances

  Person(mary_class, john_class) // returns a new instance of class Person

  // Scala applications = Scala object with
  //  def main(args: Array(String)): Unit
  //  this exact method is required (with exact same signature) and the body is the code we want to be running
}
