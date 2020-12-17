package lectures.part2oop

object Inheritance extends App {

  sealed class Animal {
    val createType = "wild"
    def eat: Unit = println("yummy")
    private def doesntEat: Unit = print("beeurk")
    protected def iamHungry: Unit = print("I am hungry")
    // final prevents overriding
    final def isAlive = true
  }

  // you can only inherit from 1 class
  // can only inherit non-private methods
  class Cat extends Animal {
    def needToEat = {
      // doesntEat is not accessible because private
      // both below are accessible
      iamHungry
      eat
    }
  }

  val cat = new Cat
  cat.eat

  // cat.doesntEat raises exception because it can't be accessed from outside
  // cat.iamHungry raises exception because it can't be accessed from outside

  // Inheritance
  class Person(name: String, age: Int) {
    // you can also define constructors like
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, IdCard: String) extends Person(name, age)
  // the extends part should contain the signature of the constructor otherwise the compiler will complain


  // overriding
  class Dog(override val createType: String) extends Animal {
    override def eat: Unit = {
      // calls the method eat in the super class
      super.eat
      println("Crunch crunch")
    }

    override protected def iamHungry: Unit = println("I need food!")

    // override val createType: String = "Domestic "
    // you can also override fields in the constructor directly
  }
  val dog = new Dog("Canine")

  // type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // prints Crunch crunch instead of yummy

  // to prevent overriding
  //  1. Use final on member
  //  2. Use final on the entire class
  //  3. `seal` the class = the class can be extended in the file but not elsewhere
}
