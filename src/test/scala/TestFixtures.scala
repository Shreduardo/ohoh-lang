package luccs.proglang.p3a.scala

object TestFixtures {

    /**Assignments**/
    /*Correct*/
    val basicAssignment = Assignment(Variable("x"), Constant(5))
    val basicAssignmentString = "x = 5"


    val repAssignmentString = "x = 5  y = 7"

    val assignmentToExpressionString = "x = ((1 + y2) - (3 * y4)) / 5"

    /*Incorect*/


    /**Expressions**/
    /*Correct*/

    val complexExpressionString = "((1 + y2) - (3 * y4)) / 5"

    /*Incorrect*/


    /**Blocks**/
    /*Correct*/

    val complexBlockString = "{ r = r + x  y = y + 1 }"

    /*Incorrect*/


    /**Conditionals**/
    /*Correct*/
    val basicConditionalString = "if (1) { x = 2 }"
    val simpleCondiitonalString = "if (1) { x = 2 } else { x = 3 }"
    val conditionalRepExpressionBlockString = "if (4) { r = r + x  y = y + 1 }"

    /*Incorrect*/

    /**Loops**/
    /*Correct*/
    val simpleLoopString = "while (y) { r = r + x  y = y - 1 }"

    /*Incorrect*/

}
