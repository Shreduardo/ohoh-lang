package luccs.proglang.p3a.scala

/* Top level syntax trait */
trait Syntax

/* Syntax category traits */
trait Statement extends Syntax
trait Expression extends Syntax

/* Blank Syntax to handle nullity */
case object Void extends Syntax

abstract class BinaryExpression (left: Expression, right: Expression) extends Expression {
    require(left != null)
    require(right != null)
}

abstract class BinaryStatement(left: Syntax, right: Syntax) extends Statement {
    require(left != null)
    require(right != null)
}


case class Sequence(repeatedSyntax: Syntax*) extends Syntax {
    require(repeatedSyntax != null)
}

/*Effect-less Expressions*/
case class Constant(value: Int) extends Expression
case class UMinus(value: Expression) extends Expression
case class Plus(left: Expression, right: Expression) extends BinaryExpression(left, right)
case class Minus(left: Expression, right: Expression) extends BinaryExpression(left, right)
case class Mult(left: Expression, right: Expression) extends BinaryExpression(left, right)
case class Div(left: Expression, right: Expression) extends BinaryExpression(left, right)
case class Mod(left: Expression, right: Expression) extends BinaryExpression(left, right)

case class Variable(name: String) extends Expression {
    require(name != null)
}



 case class Loop(guard: Expression, body: Syntax) extends BinaryStatement(guard, body)

 case class Assignment(left: Variable, right: Syntax) extends BinaryStatement(left, right)


/* TODO: Condition */
case class Condition(guard: Expression, body: Syntax, elseBody: Syntax) extends Statement {
    require(guard != null)
    require(body != null)
}

case class Struct(elements: Field*) extends Statement {
    require(elements != null)
}

case class Field(key: String, value: Syntax) extends Statement {
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
