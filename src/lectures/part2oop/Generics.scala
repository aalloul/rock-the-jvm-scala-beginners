package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // A is a generic type
  }

  class MyMao[Key, Value]

  trait MyTrait[My]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    // objects cannot be parameterized with generic types
    // but their methods can be parameterized with generic methods
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
  Question: Does a list of Cat extend List of Animal. 3 possible answers
    1. yes List[Cat] extends List[Animal] = COVARIANCE
  */
  class CovariantList[+A] // note the + sign
  val animal: Animal = new Cat // reminder of polymorphism
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // works just fine
  // animalList.add(new Dog) ??? HARD QUESTION! because it would pollute the list of Cats

  /*
    2. NO = INVARIANCE
   */
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  // This doesn't work because it's INVARIANT

  /*
    3. Hell, no! CONTRAVARIANCE
   */
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  //  => Option 3 is the exact inverse of option 1 in terms of class hierarchy

  // Bounded types
  // Upper bound
  class Cage[A <: Animal](animal: A) // this means it only accepts sub-types of Animal
  // Lower bound
  class Cage2[A >: Animal] // Only accepts parent-type of Animal

  class MyList2[+A] {
    def add[B >: A](element: B): MyList2[B] = ???
    // this means that if we have a list of Cat and want to add a Dog
    // we will return a list of Animal because that's the parent-type
  }

}
