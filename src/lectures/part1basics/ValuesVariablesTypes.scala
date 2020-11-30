package lectures.part1basics

object  ValuesVariablesTypes extends App {

  // Vals are immutable
  // compiler can infer types
  val x: Int = 42

  val aString: String = "hello"
  val anoterString = "blabla"
  val aBoolean: Boolean = false // can be also too
  val achar: Char = 'a'
  val aShort: Short = 12
  val aLong: Long = 2390234322398723432L
  val aFloat: Float = 12.0f
  val aDouble: Double = 12.3

  // variables
  var aVariable = 3
  aVariable = 2 // side effects
}
