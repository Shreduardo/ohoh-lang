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



<<<<<<< HEAD

=======
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
    /* Expressions */
    val parsedComplexExpression = MiniJSParser.parseAll(MiniJSParser.expr, complexExpressionString)
    test("Complex Expression") { assert(parsedComplexExpression.get === complexExpression) }



<<<<<<< HEAD

=======
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
    /* Block */
    val parsedComplexBlock = MiniJSParser.parseAll(MiniJSParser.block, complexBlockString)
    test("Complex Block") { assert(parsedComplexBlock.get === complexBlock) }




    /* Conditional */
    val parsedBasicConditional = MiniJSParser.parseAll(MiniJSParser.conditional, basicConditionalString)
    test("Basic Conitional") { assert(parsedBasicConditional.get === basicConditional) }

<<<<<<< HEAD
    val parsedConditionalRepExpressionBlock = MiniJSParser.parseAll(MiniJSParser.conditional, conditionalRepExpressionBlockString)
    test("Conditional with Repeated Expression Block") { assert(parsedConditionalRepExpressionBlock === conditionalRepExpressionBlock) }

=======
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
    /* TODO: Conditionals with `else` */
    // val parsedSimpleConditional = MiniJSParser.parseAll(MiniJSParser.conditional, simpleConditionalString)
    // test("Simple Conditional") { assert(parsedSimpleConditional.get === simpleConditional) }

<<<<<<< HEAD



    /* Loop */
    val parsedSimpleLoop = MiniJSParser.parseAll(MiniJSParser.loop, simpleLoopString)
    test("Simple Loop with repeated Expression Block") { assert(parsedSimpleLoop.get === simpleLoop)}
=======
    /* Loop */

    /* TODO: REP */
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

}
