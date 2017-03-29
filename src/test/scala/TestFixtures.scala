package luccs.proglang.p3a.scala

object TestFixtures {

    /**Assignments**/
    /*Correct*/
    val basicAssignment = "x = 5";
    val repAssignment = "x = 5 ; y = 7"
    val assignmentToExpression = "x = ((1 + y2) - (3 * y4)) / 5;"

    /*Incorect*/


    /**Expressions**/
    /*Correct*/
    val complexExpression = "((1 + y2) - (3 * y4)) / 5;"

    /*Incorrect*/


    /**Blocks**/
    /*Correct*/
    val complexBlock = "{ r = r + x; y = y + 1 ; }"

    /*Incorrect*/


    /**Conditionals**/
    /*Correct*/
    val basicConditional = "if (1) { x = 2; }"
    val simpleCondiitonal = "if (1) { x = 2; } else { x = 3; }"
    val conditionalRepExpressionBlock = "if (4) { r = r + x; y = y + 1; }"

    /*Incorrect*/

    /**Loops**/
    /*Correct*/
    val simpleLoop = "while (y) {
                        r = r + x;
                        y = y - 1;
                      }"

    /*Incorrect*/
    
}
