package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

// object MainMiniJSParser extends App {
//     TestMiniJSParser
// }
class TestMiniJSParser extends FunSuite {

    val parsedBasicAssignment = MiniJSParser.parseAll(MiniJSParser.assignment, basicAssignmentString)
    test("Basic assignment Parser") { assert(parsedBasicAssignment.get === basicAssignment) }

    val parsedRepAssignment = MiniJSParser.parseAll(MiniJSParser.assignment, repAssignmentString)
    test("Repeated assignment Parser") { assert(parsedRepAssignment.get === repAssignment) }


}

// val repAssignmentString = "x = 5  y = 7"
//
// val repAssignment = Sequence(
//                             Assignment(Variable("x"), Constant(5)),
//                             Assignment(Variable("y"), Constant(7))
//                           )
//
//
// val assignmentToExpressionString = "x = ((1 + y2) - (3 * y4)) / 5"
//
// val assingmentToExpressionString = Assignment(
//                                     Variable("x"),
//                                     Div(
//                                         Minus(
//                                             Plus(
//                                                 Constant(1),
//                                                 Variable("y2")
//                                             ),
//                                             Mult(
//                                                 Constant(3),
//                                                 Variable("y4")
//                                             )
//                                         ),
//                                         Constant(5)
//                                     )
//                                    )
