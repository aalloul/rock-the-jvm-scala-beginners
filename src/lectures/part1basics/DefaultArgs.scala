package lectures.part1basics

object DefaultArgs extends App {

  def tailRecFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecFact(n-1, n*acc)

  val fact_10 = tailRecFact(10)

  def savePicture(format: String= "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saved!")
  savePicture(width = 200)
}
