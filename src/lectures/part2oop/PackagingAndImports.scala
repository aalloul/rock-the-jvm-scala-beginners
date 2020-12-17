package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}
// import playground._ will import everything
// the alias Princess will be used instead of Cinderella

import java.util.Date
import java.sql.{Date => SqlDate} // aliasing to avoid name clashing

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Author("Adam", "Alloul", 2020)

  // to use a class from another package, you need to import it
  // or use a fully qualified name

  val cinderella = new Princess

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello // package objects are available without any further import

  // imports
  val prince = new PrinceCharming

  // Default imports : those that are imported automatically
  // java.lang - String, Object, Exception
  // scala - Imt ...
  // scala.Predef - println, ...
}
