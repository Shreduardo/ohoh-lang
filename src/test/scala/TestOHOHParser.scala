package shredev.ohohlang.scala

import org.scalatest.FunSuite
import TestFixtures._


class TestOHOHParser extends FunSuite {

    /* Assignments */
    val parsedBasicAssignment = OHOHParser.parseAll(OHOHParser.assignment, basicAssignmentString)
    test("Basic Assignment Parser") { assert(parsedBasicAssignment.get === basicAssignment) }

    val parsedAssignmentToVariable = OHOHParser.parseAll(OHOHParser.assignment, assignmentToVariableString)
    test("Assignment to Variable Parser") { assert(parsedAssignmentToVariable.get === assignmentToVariable) }

    val parsedAssignmentToExpression = OHOHParser.parseAll(OHOHParser.assignment, assignmentToExpressionString)
    test("Assignment to Expression Parser") { assert(parsedAssignmentToExpression.get === assignmentToExpression)}

    val parsedRepeatedAssignment = OHOHParser.parseAll(OHOHParser.repeated, repAssignmentString)
    test("Repeated Assignment") { assert(parsedRepeatedAssignment.get === repAssignment) }


    /* Expressions */
    val parsedComplexExpression = OHOHParser.parseAll(OHOHParser.expr, complexExpressionString)
    test("Complex Expression") { assert(parsedComplexExpression.get === complexExpression) }




    /* Block */
    val parsedComplexBlock = OHOHParser.parseAll(OHOHParser.block, complexBlockString)
    test("Complex Block") { assert(parsedComplexBlock.get === complexBlock) }




    /* Conditional */
    val parsedBasicConditional = OHOHParser.parseAll(OHOHParser.conditional, basicConditionalString)
    test("Basic Conitional") { assert(parsedBasicConditional.get === basicConditional) }

    val parsedConditionalRepExpressionBlock = OHOHParser.parseAll(OHOHParser.conditional, conditionalRepExpressionBlockString)
    test("Conditional with Repeated Expression Block") { assert(parsedConditionalRepExpressionBlock.get === conditionalRepExpressionBlock) }

    /* TODO: Conditionals with `else` */
    val parsedSimpleConditional = OHOHParser.parseAll(OHOHParser.conditional, simpleConditionalString)
    test("Simple Conditional") { assert(parsedSimpleConditional.get === simpleConditional) }





    /* Loop */
    val parsedSimpleLoop = OHOHParser.parseAll(OHOHParser.loop, simpleLoopString)
    test("Simple Loop with Repeated Expression Block") { assert(parsedSimpleLoop.get === simpleLoop)}


}
