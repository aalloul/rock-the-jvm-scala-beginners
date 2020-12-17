package lectures.part2oop

object AbstractDataTyoes extends App {

  // abstract class
  abstract class Animal {
    // can have both abstract and non-abstract members
    val createType: String // not defined hence abstract
    def eat: Unit // not implemented hence abstract
  }

  class Dog extends Animal {
    override val createType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    // can have both abstract and non-abstract members
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val createType: String = "Croc"
    def eat: Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and eating ${animal.createType}")

  }

  /* traits vs abstract class
      1- traits don't have constructor parameters
      2- you can mix in multiple traits, but only inherit from 1 class
      3- traits are behavior. Abstract class is a type of thing
   */

}
