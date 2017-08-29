package shredev.ohohlang.scala

//import sun.tools.jstat.Operator

/*
* Originally `Behaviors`
* Changed to `PrettyPrinter` because it only handles print formatting
*/

object Formatter {
      val EOL = scala.util.Properties.lineSeparator
      val INDENT = ".."
      val PRETTY_INDENT = "\t"

      def toFormattedString(prefix: String)(e: Syntax): String = e match {
          case Constant(c) => buildUnarySyntaxString(prefix, "Constant", prefix + INDENT + c.toString)
          case Variable(x) => buildUnarySyntaxString(prefix, "Variable", prefix + INDENT + x)

          case UMinus(r)   => buildUnarySyntaxString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
          case Plus(l, r)  => buildSyntaxString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Minus(l, r) => buildSyntaxString(prefix, "Minus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Mult(l, r) => buildSyntaxString(prefix, "Mult", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Div(l, r)   => buildSyntaxString(prefix, "Div", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
          case Mod(l, r)   => buildSyntaxString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))

          case Assignment(l, r) => buildSyntaxString(prefix, "Assignment", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))

          /* TODO: Condition */
          //case Condition(g, b1, b2) => buildSyntaxString(prefix, "Condition", toFormattedString(prefix + INDENT)(g), toFormattedString(prefix + INDENT)(b))
         // case Loop(g, b) => buildSyntaxString(prefix, "Loop", toFormattedString(prefix + INDENT)(g), toFormattedString(prefix + INDENT)(b))

         // case Sequence(s @ _*) => buildLinearSyntaxString(prefix, "Sequence", s: _*)
      }

      def toFormattedString(e: Syntax): String = toFormattedString("")(e)

      def buildSyntaxString(prefix: String, nodeString: String, leftString: String, rightString: String) = {
          val result = new StringBuilder(prefix)
          result.append(nodeString)
          result.append("(")
          result.append(EOL)
          result.append(leftString)
          result.append(",")
          result.append(EOL)
          result.append(rightString)
          result.append(")")
          result.toString
      }

      def buildUnarySyntaxString(prefix: String, nodeString: String, SyntaxString: String) = {
          val result = new StringBuilder(prefix)
          result.append(nodeString)
          result.append("(")
          result.append(EOL)
          result.append(SyntaxString)
          result.append(")")
          result.toString
      }

    //   def buildLinearSyntaxString(prefix: String, nodeString: String, Syntaxs: Syntax*) = {
    //       val result = new StringBuilder(prefix)
    //       result.append(nodeString)
    //       result.append("(")
    //       result.append(EOL)
      //
    //       val aggregate = Syntaxs.foldLeft("") ((aggregate, next:Syntax) => {
    //           aggregate + toFormattedString(prefix + INDENT)(next)
    //         })
      //
    //       result.append(aggregate)
    //       result.append(",")
    //       result.append(EOL)
    //       result.append(")")
    //       result.toString
    //   }
      //
    //   def prettyPrinter() = {
      //
    //   }
}
