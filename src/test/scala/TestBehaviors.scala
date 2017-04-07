package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

// object MainMiniJSParser extends App {
//     TestMiniJSParser
// }
//CLEARLY UNFINISHED
class TestBehaviors extends FunSuite {

  val behaviorAssignment = Behaviors.toFormattedString("")(complex1)
  test("Basic behavior") { assert(behaviorAssignment == complex1TreeString) }
//  test("Basic assignment Parser") { assert(parsedBasicAssignment.get === basicAssignment) }
//
//  val parsedRepAssignment = MiniJSParser.parseAll(MiniJSParser.assignment, repAssignmentString)
//  test("Repeated assignment Parser") { assert(parsedRepAssignment.get === repAssignment) }


}