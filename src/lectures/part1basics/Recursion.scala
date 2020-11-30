package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // to make sure it's tail recursive
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }
  /* anotherFactorial(5) = factHelper(5, 1)
  = factHelper(4, 5*1)
  = factHelper(3, 4*5*1)
  = factHelper(2, 3*4*5*1)
  = factHelper(1, 2*3*4*5*1)
  = 1 * 2 * 3 * 4 * 5
   */

    // 1. Concatenate a string n times
  def concatenateString(string: String, n: Int): String = {
    @tailrec
    def tailRecHelper(cnt: Int, acc: String, initialString: String): String = {
      if (cnt <=  1) acc
      else tailRecHelper(cnt - 1, acc + initialString, initialString)
    }

    tailRecHelper(n, string, string)
  }
  println(concatenateString("bla", 3))

    // 2. isPrime tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) isStillPrime
      else isPrimeUntil(t-1, isStillPrime && n % t != 0)
    }

    isPrimeUntil(n/2, true)
  }
  println(isPrime(4))
  println(isPrime(9))
  println(isPrime(13))

    // 3. Fibonacci function, tail recursive
    def fibonacci(n: Int): Int = {
      def fibHelper(x: Int, last: Int, nextToLast: Int): Int = {
        if (x >= n) last
        else fibHelper(x+1, last + nextToLast, last)
      }

      fibHelper(1, 1, 1)
    }
}
