package lectures.part1basics

object Expressions extends App {

    val x = 1 + 2 // this is an expression
    println(!(1 == x))

    var aVariable = 2
    aVariable += 3 // also works with *= -= /= ... these are all side effects

    // Instructions vs Expressions
    // An instruction tells a computer what to do

    // IF expression
    val aCondition = true
    val aConditionedValue = if (aCondition) 5 else 3 //IF returns a value. Hence it's an expression

    // Loops
    // discouraged because remnant of imperative non-functional code
    var i = 0
    while (i < 10) {
        println(1)
        i += 1
    } // NEVER WRITE THIS BECAUSE IT IS NOT AN EXPRESSION
    // EVERYTHING in Scala is an Expression!

    val aWeirdValue: Unit = (aVariable = 3) // Unit === void
    print(aWeirdValue) // prints ()

    // Code blocks
    val aCodeBlock = {
        val y = 2
        val z = y + 1

        if (z > 2) "hello" else "bye"
    } // This is an expression
    // y and z are defined within aCodeBlock. Not available outside of it

    // 1. Difference between "hello world" and println("hello world")?
    //  the 1st is a val String, the 2nd is a Unit

    // 2.
    val someValue = {
        2 < 3
    }

    val someOtherValue = {
        if (someValue) 239 else 966
        42
    }

}
