package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

class TestFormatter extends FunSuite {

    val formattedBasicAssignment = Formatter.toFormattedString(basicAssignment)
    test("Basic Assignment") { assert(formattedBasicAssignment === basicAssignmentFormatted)}

    val formattedComplexExpression = Formatter.toFormattedString(complexExpression)
    test("Complex Expression") { assert(formattedComplexExpression === complexExpressionFormatted) }

    // val formattedSimpleCondition = Formatter.toFormattedString(simpleConditional)
    // test("Simple Conditional") { assert(formattedSimpleCondition === simpleConditionalFormatted) }

    // val formattedSimpleLoop = Formatter.toFormattedString(simpleLoop)
    // test("Simple Loop") { assert(formattedSimpleLoop === simpleLoopFormatted) }


}
