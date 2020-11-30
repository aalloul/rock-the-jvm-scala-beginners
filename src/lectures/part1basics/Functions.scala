package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction) // called without parenthesis

  // Compiler can't figure out the return type of a recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  // WHEN YOU NEED LOOPS, USE RECURSION!

  // Functions can contain functions
   def aBigFunction(n: Int): Int = {
     def aSmallerFunction(a: Int, b: Int): Int = a + b

     aSmallerFunction(n, n+1)
   }

  // Exercises

  // 1. A greeting function (name, age) => "Hi, my name is <name> and I am <age> years old"
  def greetingFunction(name: String, age: Int): Unit =
    println("Hi, my name is " + name + " and I am " + age + " years old")

  // 2. Factorial function
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // 3. A Fibonacci
  // f(1) = 1
  // f(2) = 1
  // f(3) = f(n - 1) + f(n-2)
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // 4. Tests if a number is prime
  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
}
