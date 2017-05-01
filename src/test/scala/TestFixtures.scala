package luccs.proglang.p3a.scala


object TestFixtures {

    val EOL = scala.util.Properties.lineSeparator
    val INDENT = ".."

    /**Assignments**/

    val basicAssignmentString = "x = 5"
    val basicAssignment = Assignment(Variable("x"), Constant(5))
    val basicAssignmentFormatted =
      """|Assignment(
         |..Variable(
         |....x),
         |..Constant(
         |....5))""".stripMargin

    val basicAssignmentPretty = "x = 5" + EOL


    val repAssignmentString = "x = 5 y = 7"
    val repAssignment = Sequence(
                                Assignment(Variable("x"), Constant(5)),
                                Assignment(Variable("y"), Constant(7))
                        )



    val assignmentToExpressionString = "x = ((1 + y2) - (3 * y4)) % 5"
    //Changed the Div to Mod to test the new addition.  Also applied UMinus to a constant
    val assignmentToExpression = Assignment(
                                        Variable("x"),
                                        Mod(
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


    /**Expressions**/
    /*Correct*/
    val complexExpressionString = "(-(1 + y2) - -(3 * y4)) / - 5"
  //UMinus was applied to a longer statement here.
    val complexExpression = Div(
                                Minus(
                                    UMinus(
                                      Plus(
                                        Constant(1),
                                        Variable("y2")
                                      )
                                    ),
                                    UMinus(
                                      Mult(
                                        Constant(3),
                                        Variable("y4")
                                      )
                                    )
                                ),
                                UMinus(
                                  Constant(5)
                                )
                            )
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




    /**Blocks**/

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

    /**Conditionals**/

    val basicConditionalString = "if (1) { x = 2 }"
    val basicConditional = Condition(
                                Constant(1),
                                Assignment(
                                    Variable("x"),
                                    Constant(2)
                                ),
                                Void
                            )

    val simpleConditionalString = "if (1) { x = 2 } else { x = 3 }"
    val simpleConditional = Condition(
                                Constant(1),
                                Assignment(
                                    Variable("x"),
                                    Constant(2)
                                ),
                                Assignment(
                                    Variable("x"),
                                    Constant(3)
                                )
                            )


    val conditionalRepExpressionBlockString = "if (4) { r = r + x y = y + 1 }"
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
                                            Void
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
}
