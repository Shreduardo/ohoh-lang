package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import TestFixtures._

class TestFormatter extends FunSuite {

    //print(basicAssignment.getClass)
    val formattedBasicAssignment = Formatter.toFormattedString(basicAssignment)
    test("Basic Assignment") { assert(formattedBasicAssignment == basicAssignmentFormatted)}


}
