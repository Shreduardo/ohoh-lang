package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

// object MainMiniJSParser extends App {
//     TestMiniJSParser
// }
class TestMiniJSParser extends FunSuite {

    /* Assignments */
    val parsedBasicAssignment = MiniJSParser.parseAll(MiniJSParser.assignment, basicAssignmentString)
    test("Basic assignment Parser") { assert(parsedBasicAssignment.get === basicAssignment) }

    val parsedAssignmentToExpression = MiniJSParser.parseAll(MiniJSParser.assignment, assignmentToExpressionString)
    test("Assignment to Expression Parser") { assert(parsedAssignmentToExpression.get === assignmentToExpression)}

    val parsedRepeatedAssignment = MiniJSParser.parseAll(MiniJSParser.repeated, repAssignmentString)
    test("Repeated Assignment") { assert(parsedRepeatedAssignment.get === repAssignment) }



    /* Expressions */
    val parsedComplexExpression = MiniJSParser.parseAll(MiniJSParser.expr, complexExpressionString)
    test("Complex Expression") { assert(parsedComplexExpression.get === complexExpression) }



    /* Block */
    val parsedComplexBlock = MiniJSParser.parseAll(MiniJSParser.block, complexBlockString)
    print(parsedComplexBlock.get)
    test("Complex Block") { assert(parsedComplexBlock.get === complexBlock)}
    /* TODO: REP */

}


//
// val complexBlockString = "{ r = r + x  y = y + 1 }"
// val complexBlock = Sequence(
//                         Assignment(
//                             Variable("r"),
//                             Plus(
//                                 Variable("r"),
//                                 Variable("s")
//                             )
//                         ),
//                         Assignment(
//                             Variable("y"),
//                             Plus(
//                                 Variable("y"),
//                                 Constant(1)
//                             )
//                         )
//                     )
