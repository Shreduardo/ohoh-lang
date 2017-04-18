package luccs.proglang.p3a.scala

<<<<<<< HEAD

object TestFixtures {

    val EOL = scala.util.Properties.lineSeparator
    val INDENT = ".."

    /**Assignments**/

    val basicAssignmentString = "x = 5"
    val basicAssignment = Assignment(Variable("x"), Constant(5))
    val basicAssignmentFormatted = "x = 5" + EOL
=======
object TestFixtures {

    /**Assignments**/
    /*Correct*/
    val basicAssignmentString = "x = 5"
    val basicAssignment = Assignment(Variable("x"), Constant(5))
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

    val repAssignmentString = "x = 5 y = 7"
    val repAssignment = Sequence(
                                Assignment(Variable("x"), Constant(5)),
                                Assignment(Variable("y"), Constant(7))
<<<<<<< HEAD
                                )
=======
                              )
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

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
<<<<<<< HEAD




    /**Expressions**/
=======
    /*Incorect*/


    /**Expressions**/
    /*Correct*/
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

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
<<<<<<< HEAD
    //Incorrect
=======

    //Still wrong, but not worth the time to fix right now
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
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

<<<<<<< HEAD



    /**Blocks**/

=======
    /*Incorrect*/


    /**Blocks**/
    /*Correct*/
    /* TODO: REP */
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
    val complexBlockString = "{ r = r + x y = y + 1 }"
    val complexBlock = Sequence(
                            Assignment(
                                Variable("r"),
                                Plus(
                                    Variable("r"),
                                    Variable("x")
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

<<<<<<< HEAD





    /**Conditionals**/
=======
    /*Incorrect*/


    /* TODO: Conditionals */
    /**Conditionals**/
    /*Correct*/
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

    val basicConditionalString = "if (1) { x = 2 }"
    val basicConditional = Condition(
                                Constant(1),
                                Assignment(
                                    Variable("x"),
                                    Constant(2)
                                ),
                                None
                            )

    val simpleConditionalString = "if (1) { x = 2 } else { x = 3 }"
    val simpleConditional = Condition(
                                Constant(1),
                                Assignment(
                                    Variable("x"),
                                    Constant(2)
                                ),
                                Option(Assignment(
                                    Variable("x"),
                                    Constant(3)
                                ))
                            )

<<<<<<< HEAD

    val conditionalRepExpressionBlockString = "if (4) { r = r + x  y = y + 1 }"
    val conditionalRepExpressionBlock = Condition(
                                            Constant(4),
                                            Sequence(
                                                Assignment(
                                                    Variable("r"),
                                                    Plus(
                                                        Variable("r"),
                                                        Variable("x")
                                                    )
                                                ),
                                                Assignment(
                                                    Variable("y"),
                                                    Plus(
                                                        Variable("y"),
                                                        Constant(1)
                                                    )
                                                )
                                            ),
                                            None
                                        )






    /**Loops**/

    val simpleLoopString = "while (y) { r = r + x  y = y - 1 }"
    val simpleLoop = Loop(
                        Variable("y"),
                        Sequence(
                            Assignment(
                                Variable("r"),
                                Plus(
                                    Variable("r"),
                                    Variable("x")
                                )
                            ),
                            Assignment(
                                Variable("y"),
                                Minus(
                                    Variable("y"),
                                    Constant(1)
                                )
                            )
                        )
                     )
=======
    // /* TODO: REP */
    // val conditionalRepExpressionBlockString = "if (4) { r = r + x  y = y + 1 }"

    /*Incorrect*/

    /**Loops**/
    /*Correct*/
    /* TODO: REP */
    val simpleLoopString = "while (y) { r = r + x  y = y - 1 }"

    /*Incorrect*/

>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
}
