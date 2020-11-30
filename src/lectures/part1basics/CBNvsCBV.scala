package lectures.part1basics

object CBNvsCBV extends App {
  // Call by name vs Call by value

  def CallByValue(x: Long): Unit = {
    // when there's no arrow, the value of x is evaluated then passed along
    println("by value " + x)
    println("by value " + x)
  }

  def CallByVName(x: => Long): Unit = {
    // the little arrow tells Scala to evaluate the value of x anew, wherever it appears.
    // with this approach, the evaluation is delayed until x is called. if x is called twice, it will be evaluated twice
    println("by name " + x)
    println("by name " + x)
  }
  CallByValue(System.nanoTime())
  CallByVName(System.nanoTime())

}
