package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("awrwerewrwe")
  }
  /*
  this is equivalent to:
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("werewrew")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  /*
    1. create a generic trait MyPredicate[-T] with a little method test(T) -> Boolean
    2. Generic trait called MyTransformer[-A, B]: converts A to B with a method transform(A) -> B
    3. MyList:
      - map(transformer) => MyList of a different type
     - filter (predicate) => MyList
     - flatMap(transformer from a to MyList[B]) => MyList[B]

     class EvenPredicate extends MyPredicate[Int[
     class StringToIntTransformer extends MyTransformer[String, Int]

     [1,2,3].map(n*2) = [2,4,6] // pseudo code
     [1,2,3,4].filter(n%2) = [2,5] // psuedo code
     [1,2,3].flatmap(n => [n, n+1]) => [1,2, 2, 3, 3, 4]
   */
}
