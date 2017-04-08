package luccs.proglang.p3a.scala

object TestFixtures {

    /**Assignments**/
    /*Correct*/
    val basicAssignmentString = "x = 5"
    val basicAssignment = Assignment(Variable("x"), Constant(5))

    /* TODO: REP */
    val repAssignmentString = "x = 5  y = 7"
    val repAssignment = Sequence(
                                Assignment(Variable("x"), Constant(5)),
                                Assignment(Variable("y"), Constant(7))
                              )

    val assignmentToExpressionString = "x = ((1 + y2) - (3 * y4)) / 5"
    val assignmentToExpression = Assignment(
                                        Variable("x"),
                                        Div(
                                            Minus(
                                                Plus(
                                                    Constant(1),
                                                    Variable("y2")
                                                ),
                                                Mult(
                                                    Constant(3),
                                                    Variable("y4")
                                                )
                                            ),
                                            Constant(5)
                                        )
                                       )
    /*Incorect*/


    /**Expressions**/
    /*Correct*/

    val complexExpressionString = "((1 + y2) - (3 * y4)) / 5"
    val complexExpression = Div(
                                Minus(
                                    Plus(
                                        Constant(1),
                                        Variable("y2")
                                    ),
                                    Mult(
                                        Constant(3),
                                        Variable("y4")
                                    )
                                ),
                                Constant(5)
                            )

    //Still wrong, but not worth the time to fix right now
    //   val complexExpressionTreeString =
    //     """Div(
    //       |..Minus(
    //       |....Plus(
    //       |......1,
    //       |......2
    //       |....),
    //       |....Mult(
    //       |......3,
    //       |......4
    //       |....)
    //       |..),
    //       |..5
    //       |)""".stripMargin

    /*Incorrect*/


    /**Blocks**/
    /*Correct*/
    /* TODO: REP */
    val complexBlockString = "{ r = r + x  y = y + 1 }"
    val complexBlock = Sequence(
                            Assignment(
                                Variable("r"),
                                Plus(
                                    Variable("r"),
                                    Variable("s")
                                )
                            ),
                            Assignment(
                                Variable("y"),
                                Plus(
                                    Variable("y"),
                                    Constant(1)
                                )
                            )
                        )

    /*Incorrect*/


    /* TODO: Conditionals */
    /**Conditionals**/
    /*Correct*/

    // val basicConditionalString = "if (1) { x = 2 }"
    // val basicConditional = Conditional(
    //                             Constant(1),
    //                             Assignment(
    //                                 Variable("x"),
    //                                 Constant(2)
    //                             ),
    //                             NiL
    //                         )
    //
    // val simpleCondiitonalString = "if (1) { x = 2 } else { x = 3 }"
    // val simpleConditional = Conditional(
    //                             Constant(1),
    //                             Assignment(
    //                                 Variable("x"),
    //                                 Constant(2)
    //                             ),
    //                             Assignment(
    //                                 Variable("x"),
    //                                 Constant(3)
    //                             )
    //                         )
    //
    // /* TODO: REP */
    // val conditionalRepExpressionBlockString = "if (4) { r = r + x  y = y + 1 }"

    /*Incorrect*/

    /**Loops**/
    /*Correct*/
    /* TODO: REP */
    val simpleLoopString = "while (y) { r = r + x  y = y - 1 }"

    /*Incorrect*/

}
