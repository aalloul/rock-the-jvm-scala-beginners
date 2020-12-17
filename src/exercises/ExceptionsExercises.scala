package exercises

object ExceptionsExercises extends App {
  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with a StackOverflowError
    3. Define a PocketCalculator
      - add(x: Int, y: Int)
      - substract(x: Int, y: Int)
      - multiply(x: Int, y: Int)
      - divide(x: Int, y: Int)
      Throw
        - OverflowException if add(x,y) exceeds int.MAX_VALUE
        - UnderflowException if substract(x,y) exceeds int.MIN_VALUE
        - MathCalculationException for division by 0
   */

  class CrashWithOOM {
    def append(): Unit = {
      val arr = Array.ofDim(Int.MaxValue)
    }
  }

  class CrashWithSOF {
    def append(): Int = {
      append()
    }
  }

//  val crash_with_oom = new CrashWithOOM().append()
//  val crash_with_sof = new CrashWithSOF().append()

  class MathCalculationException extends RuntimeException("Division By 0")
  class OverflowError extends RuntimeException
  class UnderflowError extends RuntimeException
  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val res = x + y
      if (x > 0 && y > 0 && res < 0) throw new OverflowError
      else if (x < 0 && y < 0 && res > 0) throw new UnderflowError
      else res
    }

    def substract(x: Int, y: Int): Int = {
      val res = x - y
      if (x > 0 && y < 0 && res < 0) throw new OverflowError
      else if (x < 0 && y > 0 && res > 0) throw new UnderflowError
      else res
    }

    def multiply(x: Int, y: Int): Int = {
      val res = x * y
      if (x > 0 && y > 0 && res < 0) throw new OverflowError
      else if (x < 0 && y < 0 && res < 0) throw new OverflowError
      else if (x < 0 && y > 0 && res > 0) throw new UnderflowError
      else if (x > 0 && y < 0 && res > 0) throw new UnderflowError
      else res
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException()
      else   x/y

    }
  }
}
