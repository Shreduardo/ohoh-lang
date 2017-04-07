package luccs.proglang.p3a.scala

import sun.tools.jstat.Operator


object Behaviors {

  def toFormattedString(prefix: String)(e: Statement): String = e match {
    case Constant(c) => prefix + c.toString
    //case UMinus(r)   => buildUnaryExprString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
    case Plus(l, r)  => buildExprString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Minus(l, r) => buildExprString(prefix, "Minus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Mult(l, r) => buildExprString(prefix, "Mult", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Div(l, r)   => buildExprString(prefix, "Div", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    //case Mod(l, r)   => buildExprString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  }

  def toFormattedString(e: Statement): String = toFormattedString("")(e)

  //Below not yet looked at
  def buildExprString(prefix: String, nodeString: String, leftString: String, rightString: String) = {
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

  def buildUnaryExprString(prefix: String, nodeString: String, exprString: String) = {
    val result = new StringBuilder(prefix)
    result.append(nodeString)
    result.append("(")
    result.append(EOL)
    result.append(exprString)
    result.append(")")
    result.toString
  }

  val EOL = scala.util.Properties.lineSeparator
  val INDENT = ".."

  def buildUnparsedString(prefix: String, operator: String, leftString: String, rightString: String) = {
    val result = new StringBuilder(prefix)
    result.append("(")
    result.append(leftString + " ")
    result.append(operator)
    result.append(" " + rightString)
    result.append(")")
    result.toString
  }

  def unparser(prefix: String, nodeString: String, leftString: String, rightString: String) = {
    case Constant(c) => prefix + c.toString()
    case Plus(l,r) => buildUnparsedString()
    //case Plus(l, r)  => buildExprString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  }
}
