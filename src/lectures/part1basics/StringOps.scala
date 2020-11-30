package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("hello"))
  println(str.replace("am", "be"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ "z") // appending and pre-pending
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators

  // s-interpolators
  val name = "Adam"
  val age = 23
  val greeting = s"Hello, my name is $name and I am $age years old"

  // F-interpolators
  val speed = 1.2876f
  println(f"$name%s can eat $speed%2.2f burgers per minute")

  // raw interpolator
  println(raw"This is a \n newline")
}

