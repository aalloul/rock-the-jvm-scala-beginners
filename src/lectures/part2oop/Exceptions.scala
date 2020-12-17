package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) will crash with a NullPointerException

//  val aWeirdValue: String = throw new NullPointerException
  // this syntax is totally okay because the right-hand side is an expression
  // the right hand-side returns Nothing which is a valid substitute for everything

  // throwable classes extend the Throwable class
  //  -> Exceptions and Errors are the major Throwable sub-types
  // Exceptions are for things that went wrong within the program
  // Errors are for errors in the system (for example StackOverFlow Error)

  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("no int for you")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a RuntimeException with message " + e.getMessage)
  } finally {
    // code that will get executed no matter what
    // this block is optional
    // it does not influence the return type of this expression
    // Use finally only for side effects!
    println("Finally!")
  }
  println(potentialFail)

  // 3. Define your own exceptions
  class MyException extends Exception
  val exception = new MyException


}
