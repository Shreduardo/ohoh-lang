package luccs.proglang.p3a.scala

//import sun.tools.jstat.Operator

/*
* Originally `Behaviors`
* Changed to `PrettyPrinter` because it only handles print formatting
*/

object PrettyPrinter {
  val EOL = scala.util.Properties.lineSeparator
  val INDENT = ".."

  def toFormattedString(prefix: String)(e: Statement): String = e match {
  case Constant(c) => prefix + c.toString
 // case UMinus(r)   => buildUnaryStatementString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
  case Plus(l, r)  => buildStatementString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  case Minus(l, r) => buildStatementString(prefix, "Minus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  case Mult(l, r) => buildStatementString(prefix, "Times", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  case Div(l, r)   => buildStatementString(prefix, "Div", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  case Mod(l, r)   => buildStatementString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
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



  //Print formatting relative to each Statement
  // def toFormattedString(e: Statement): String = e match {
  //   case Constant(c) => c.toString + " "
  //   case Variable(x) => x.toString + " "
  //   //case UMinus(r)   => buildUnaryStatementString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
  //   case Plus(l, r)  => buildStatementString(INDENT, "Plus", toFormattedString(l), toFormattedString(r)) + EOL
  //   case Minus(l, r) => buildStatementString(INDENT, "Minus", toFormattedString(l), toFormattedString(r)) + EOL
  //   case Mult(l, r) => buildStatementString(INDENT, "Mult", toFormattedString(l), toFormattedString(r)) + EOL
  //   case Div(l, r)   => buildStatementString(INDENT, "Div", toFormattedString(l), toFormattedString(r)) + EOL
  //   //case Mod(l, r)   => buildStatementString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  // }

 //def toFormattedString(prefix: String, e: Statement): String = toFormattedString("")(e)


  // def buildStatementString(prefix: String, nodeString: String, leftString: String, rightString: String): String = nodeString match {
  //   case "Plus" => prefix + leftString + " + " + rightString
  //   case "Minus" => prefix + leftString + " - " + rightString
  //   case "Mult" => prefix + leftString + " * " + rightString
  //   case "Div" => prefix + leftString + " / " + rightString
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
  //}



  // def buildUnaryStatementString(prefix: String, nodeString: String, StatementString: String) = {
  //   val result = new StringBuilder(prefix)
  //   result.append(nodeString)
  //   result.append("(")
  //   result.append(EOL)
  //   result.append(StatementString)
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
  //     //case Plus(l, r)  => buildStatementString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  //   }
}
