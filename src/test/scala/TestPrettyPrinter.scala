package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

class TestPrettyPrinter extends FunSuite {

    //print(basicAssignment.getClass)
    val unparsedBasicAssignment = PrettyPrinter.toFormattedString( MiniJSParser.parseAll(MiniJSParser.assignment, basicAssignmentString).get )
    test("Basic Assignment") { assert(unparsedBasicAssignment == basicAssignmentFormatted)}



}
