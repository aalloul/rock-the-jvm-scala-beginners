package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    // for infix, only 1 parameter accepted
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // prefix
    // only works with + - ~ !
    def unary_! : String = s"$name, what the heck?!"

    // postfix
    // only works when no parameters required
    def isAlive: Boolean = true

    // special method apply
    def apply(): String = s"hi there, I'm $name"
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
}
