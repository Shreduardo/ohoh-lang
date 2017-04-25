package luccs.proglang.p3a.scala

//import sun.tools.jstat.Operator

/*
* Originally `Behaviors`
* Changed to `PrettyPrinter` because it only handles print formatting
*/

object Formatter {
      val EOL = scala.util.Properties.lineSeparator
      val INDENT = ".."
      val PRETTY_INDENT = "\t"

      def toFormattedString(prefix: String)(e: Statement): String = e match {
          case Constant(c) => buildUnaryStatementString(prefix, "Constant", prefix + INDENT + c.toString)
          case Variable(x) => buildUnaryStatementString(prefix, "Variable", prefix + INDENT + x)

          case UMinus(r)   => buildUnaryStatementString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
          case Plus(l, r)  => buildStatementString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Minus(l, r) => buildStatementString(prefix, "Minus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Mult(l, r) => buildStatementString(prefix, "Times", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Div(l, r)   => buildStatementString(prefix, "Div", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Mod(l, r)   => buildStatementString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))

          case Assignment(l, r) => buildStatementString(prefix, "Assignment", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))

          /* TODO: Condition */
          //case Condition(g, b1, b2) => buildStatementString(prefix, "Condition", toFormattedString(prefix + INDENT)(g), toFormattedString(prefix + INDENT)(b))
          case Loop(g, b) => buildStatementString(prefix, "Loop", toFormattedString(prefix + INDENT)(g), toFormattedString(prefix + INDENT)(b))

          case Sequence(s) => buildLinearStatementString(prefix, "Sequence", s)
      }

      def toFormattedString(e: Statement): String = toFormattedString("")(e)

      def buildStatementString(prefix: String, nodeString: String, leftString: String, rightString: String) = {
          val result = new StringBuilder(prefix)
          result.append(nodeString)
          result.append("(")
          result.append(EOL)
          result.append(leftString)
          result.append(", ")
          result.append(EOL)
          result.append(rightString)
          result.append(")")
          result.toString
      }

      def buildUnaryStatementString(prefix: String, nodeString: String, StatementString: String) = {
          val result = new StringBuilder(prefix)
          result.append(nodeString)
          result.append("(")
          result.append(EOL)
          result.append(StatementString)
          result.append(")")
          result.toString
      }

      def buildLinearStatementString(prefix: String, nodeString: String, statements: Statement*) = {
          val result = new StringBuilder(prefix)
          result.append(nodeString)
          result.append("(")
          result.append(EOL)

          val aggregate = statements.foldLeft("") ((aggregate, next:Statement) => {
              aggregate + toFormattedString(prefix)(next)
            })

          result.append(aggregate)
          result.append(")")
          result.toString
      }

      def prettyPrinter() = {

      }
}
