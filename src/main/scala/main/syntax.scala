package luccs.proglang.p3a.scala


trait Statement

abstract class BinaryStatement(left: Statement, right: Statement) extends Statement {
    require(left != null)
    require(right != null)
}
//WE NEED TO ADD SOME STATEMENTS.  LOOK AT BEHAVIORS
/*Effect-less Statements*/
case class Constant(value: Int) extends Statement
case class Plus(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Minus(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Mult(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Div(left: Statement, right: Statement) extends BinaryStatement(left, right)
<<<<<<< HEAD
=======
case class Mod(left: Statement, right: Statement) extends BinaryStatement(left, right)
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34

/*Imperative Statements*/
case class Variable(name: String) extends Statement {
    require(name != null)
}
case class Sequence(statements: Statement*) extends Statement {
    require(statements != null)
}

/* TODO: Condition */
case class Condition(guard: Statement, body: Statement, elseBody: Option[Statement]) extends Statement {
    require(guard != null)
    require(body != null)
}

<<<<<<< HEAD
case class Loop(guard: Statement, body: Statement) extends BinaryStatement(guard, body)
=======
case class While(guard: Statement, body: Statement) extends BinaryStatement(guard, body)
>>>>>>> e1132f4c759c5fb7964e2a0c090c266cb97fcb34
case class Assignment(left: Variable, right: Statement) extends BinaryStatement(left, right)
