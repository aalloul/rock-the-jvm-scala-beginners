package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    // for infix, only 1 parameter accepted
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(str: String): Person = new Person(s"{$this.name} ($str)", favoriteMovie, age)

    // prefix
    // only works with + - ~ !
    def unary_! : String = s"$name, what the heck?!"

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age+1)

    def learns(str: String): String = s"$name learns $str"

    def learnsScala: String = learns("Scala")

    // postfix
    // only works when no parameters required
    def isAlive: Boolean = true

    // special method apply
    def apply(): String = s"hi there, I'm $name"

    def apply(int: Int): String = s"$name watched $favoriteMovie $int times"
  }

  // "operators" in Scala
  val mary = new Person("Mary", "movie 1")
  println(mary likes "movie 2") // same as mary.likes("movie 2")
  // this is called infix notation

  val tom = new Person("Tom", "movie 3")
  println(tom + mary) // same as tom.+(mary)

  // prefix
  // these two lines are equivalent
  println(!mary)
  println(mary.unary_!)

  // postfix
  println(mary.isAlive) // equivalent to each other
  println(mary isAlive) // equivalent to each other


  // apply method
  mary.apply() // equivalent to
  mary()

  /*
    1. overload the + operator
        Mary + "the rockstar" => new Person with the name "Mary (the rockstar)"

    2. Add age to Person class
      Add a unary + operator which increments the value and returns a new Person

    3. Add a "learns" method in the Person class
      -> returns "Mary learns $name"

    4. Add a learnsScala method, calls the the learns method with "Scala" as input
      -> as a postfix

    5. Overload the apply method
      may.apply(2) -> "Mary watched $favmovie 2 times"
   */
}
