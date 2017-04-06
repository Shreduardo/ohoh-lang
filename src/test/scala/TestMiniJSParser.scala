package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

// object MainMiniJSParser extends App {
//     TestMiniJSParser
// }
class TestMiniJSParser extends FunSuite {
    val parsedBasicAssignment = MiniJSParser.parseAll(MiniJSParser.assignment, basicAssignmentString)
    test("Basic ssignment Parser") { assert(parsedBasicAssignment.get === basicAssignment) }
}
