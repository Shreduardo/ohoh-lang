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

/*Imperative Statements*/
case class Variable(name: String) extends Statement {
    require(name != null)
}
case class Sequence(statements: Statement*) extends Statement {
    require(statements != null)
}

/* TODO: Condition */
//case class Condition(guard: Statement, body: Statement, elseBody: Statement) extends BinaryStatement(guard, body)
case class While(guard: Statement, body: Statement) extends BinaryStatement(guard, body)
case class Assignment(left: Variable, right: Statement) extends BinaryStatement(left, right)
