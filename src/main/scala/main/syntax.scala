package luccs.proglang.p3a.scala


trait Statement

abstract class BinaryStatement(left: Statement, right: Statement) extends Statement {
    require(left != null)
    require(right != null)
}

/* Blank Stantment to handle nullity */
case object Void extends Statement

/*Effect-less Statements*/
case class Constant(value: Int) extends Statement
case class UMinus(value: Statement) extends Statement
case class Plus(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Minus(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Mult(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Div(left: Statement, right: Statement) extends BinaryStatement(left, right)
case class Mod(left: Statement, right: Statement) extends BinaryStatement(left, right)


/*Imperative Statements*/
case class Variable(name: String) extends Statement {
    require(name != null)
}
case class Sequence(statements: Statement*) extends Statement {
    require(statements != null)
}

case class Loop(guard: Statement, body: Statement) extends BinaryStatement(guard, body)
case class Assignment(left: Variable, right: Statement) extends BinaryStatement(left, right)


/* TODO: Condition */
case class Condition(guard: Statement, body: Statement, elseBody: Statement) extends Statement {
    require(guard != null)
    require(body != null)
}


case class Struct(elements: Statement*) extends Statement {
    require(elements != null)
}

case class Field(key: String, value: Statement) extends Statement {
    require(key != null)
    require(value != null)
}


/* Questions
    1) Void() syntax for optional statements
    2) Nested List vs Wrapped Array (test failure)
    3) Formatting for unparser test fixtures

*   Field--------
      X 1) key a variable?
      2) is it essential an assignment?
      3)
*/
