package luccs.proglang.p3a.scala

//import sun.tools.jstat.Operator

/*
* Originally `Behaviors`
* Changed to `PrettyPrinter` because it only handles print formatting
*/

object PrettyPrinter {
  val EOL = scala.util.Properties.lineSeparator
  val INDENT = ".."

  //Print formatting relative to each Statement
  def toFormattedString(e: Statement): String = e match {
    case Constant(c) => c.toString + " "
    case Variable(x) => x.toString + " "
    //case UMinus(r)   => buildUnaryExprString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
    case Plus(l, r)  => buildExprString(INDENT, "Plus", toFormattedString(l), toFormattedString(r)) + EOL
    case Minus(l, r) => buildExprString(INDENT, "Minus", toFormattedString(l), toFormattedString(r)) + EOL
    case Mult(l, r) => buildExprString(INDENT, "Mult", toFormattedString(l), toFormattedString(r)) + EOL
    case Div(l, r)   => buildExprString(INDENT, "Div", toFormattedString(l), toFormattedString(r)) + EOL
    //case Mod(l, r)   => buildExprString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  }

 //def toFormattedString(prefix: String, e: Statement): String = toFormattedString("")(e)


  def buildExprString(prefix: String, nodeString: String, leftString: String, rightString: String): String = nodeString match {
    case "Plus" => prefix + leftString + " + " + rightString
    case "Minus" => prefix + leftString + " - " + rightString
    case "Mult" => prefix + leftString + " * " + rightString
    case "Div" => prefix + leftString + " / " + rightString
    // val result = new StringBuilder()
    // result.append(nodeString)
    // result.append("(")
    // result.append(EOL)
    // result.append(leftString)
    // result.append(", ")
    // result.append(EOL)
    // result.append(rightString)
    // result.append(")")
    // result.toString
  }



  // def buildUnaryExprString(prefix: String, nodeString: String, exprString: String) = {
  //   val result = new StringBuilder(prefix)
  //   result.append(nodeString)
  //   result.append("(")
  //   result.append(EOL)
  //   result.append(exprString)
  //   result.append(")")
  //   result.toString
  // }
  //
  // //Maybe wrong, but probably not
  // def buildUnparsedString(prefix: String, operator: String, leftString: String, rightString: String) = {
  //   val result = new StringBuilder(prefix)
  //   result.append("(")
  //   result.append(leftString + " ")
  //   result.append(operator)
  //   result.append(" " + rightString)
  //   result.append(")")
  //   result.toString
  // }
  // //UNFINISHED BELOW
  //   def unparser(prefix: String, nodeString: String, leftString: String, rightString: String) = {
  //     case Constant(c) => prefix + c.toString()
  //     case Plus(l,r) => buildUnparsedString()
  //     //case Plus(l, r)  => buildExprString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  //   }
}
